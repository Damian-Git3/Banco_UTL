/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dg.banco_utl.appservice;

import com.dg.banco_utl.cqrs.CuentaCQRS;
import com.dg.banco_utl.cqrs.TransaccionCQRS;
import com.dg.banco_utl.dao.TransaccionDAO;
import com.dg.banco_utl.modelos.Transaccion;
import com.dg.banco_utl.viewmodel.CuentaViewModel;

import jakarta.ws.rs.core.Response;

/**
 *
 * @author damia
 */
public class CuentaAppService {

  public Boolean retiro(CuentaViewModel cuentavm){

    CuentaCQRS cuentaCQRS = new CuentaCQRS();

    return cuentaCQRS.actualizarSaldo(cuentavm.getNumTarjeta(),cuentavm.getCantidadRetiro());
  }

  public Response retiroExterno(CuentaViewModel cuentavm){

    CuentaCQRS cuentaCQRS = new CuentaCQRS();

    if(cuentaCQRS.validarNumTarjeta(cuentavm) == false){
      return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"Numero de tarjeta Inexistente\"}").build();
    }

    if(cuentaCQRS.validarNip(cuentavm) == false){
      return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"NIP incorrecto\"}").build();
    }

    if(cuentaCQRS.validarSaldo(cuentavm) == false){
      return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"Saldo de la Cuenta Insuficiente\"}").build();
    }

    if(cuentaCQRS.actualizarSaldo(cuentavm.getNumTarjeta(),cuentavm.getCantidadRetiro())){
      Transaccion transaccion = new Transaccion();

      TransaccionDAO transaccionDAO = new TransaccionDAO();
      TransaccionAppService transaccionAS = new TransaccionAppService();
      transaccion.setNumTarjeta(cuentavm.getNumTarjeta());
      transaccion.setBanco("INBS");
      transaccion.setCantidadRetiro(cuentavm.getCantidadRetiro());
      transaccion.setCodigo(transaccionAS.generarCodigo("INBS"));

      transaccionDAO.insertarTransaccion(transaccion);
      
      return Response.status(Response.Status.OK).entity("{\"message\": \"Retiro Exitoso\"}").build();
    }

    return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"error\"}").build();
  }
  


}
