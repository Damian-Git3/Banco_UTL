/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dg.banco_utl.appservice;

import com.dg.banco_utl.cqrs.CajeroCQRS;
import com.dg.banco_utl.cqrs.CuentaCQRS;
import com.dg.banco_utl.dao.CajeroDAO;
import com.dg.banco_utl.dao.TransaccionDAO;
import com.dg.banco_utl.modelos.Transaccion;
import com.dg.banco_utl.viewmodel.CuentaViewModel;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 *
 * @author damia
 */
public class CajeroAppService {

  public Boolean actualizarSaldo(CuentaViewModel cuentaVM) {

    CajeroDAO cajeroDAO = new CajeroDAO();

    System.out.println("Cantidad a retirar: " + cuentaVM.getCantidadRetiro());
    System.out.println("Cantidad en cajero: " + cajeroDAO.getCantidadCajero(1));

    int nuevaCantidadCajero = cajeroDAO.getCantidadCajero(1) - cuentaVM.getCantidadRetiro();

    return cajeroDAO.updateCajero(nuevaCantidadCajero, 1);
  }

  public Response retirar(CuentaViewModel cuentaVM) {

    CuentaAppService cuentaAS = new CuentaAppService();
    CuentaCQRS cuentaCQRS = new CuentaCQRS();
    CajeroCQRS cajeroCQRS = new CajeroCQRS();

    System.out.println("NumTarjeta Valida:" + cuentaCQRS.validarNumTarjeta(cuentaVM));
    if (cuentaCQRS.validarNumTarjeta(cuentaVM) == false) {
      return Response.status(Status.BAD_REQUEST).entity("{\"error\": \"Numero de tarjeta Inexistente\"}").build();
    }
    System.out.println("Nip Valido: " + cuentaCQRS.validarNip(cuentaVM));
    if (cuentaCQRS.validarNip(cuentaVM) == false) {
      return Response.status(Status.BAD_REQUEST).entity("{\"error\": \"NIP incorrecto\"}").build();
    }

    System.out.println("Saldo Cuenta Suficiente: " + cuentaCQRS.validarSaldo(cuentaVM));
    if (cuentaCQRS.validarSaldo(cuentaVM) == false) {
      return Response.status(Status.BAD_REQUEST).entity("{\"error\": \"Saldo de la Cuenta Insuficiente\"}").build();
    }

    System.out.println("Saldo Cajero Suficiente: " + cajeroCQRS.validarSaldo(cuentaVM, 1));
    if (cajeroCQRS.validarSaldo(cuentaVM, 1) == false) {
      return Response.status(Status.BAD_REQUEST).entity("{\"error\": \"Saldo del cajero insuficiente\"}").build();
    }

    System.out.println(cuentaAS.retiro(cuentaVM));
    if (cuentaAS.retiro(cuentaVM)) {

      Transaccion transaccion = new Transaccion();
      TransaccionDAO transaccionDAO = new TransaccionDAO();
      TransaccionAppService transaccionAS = new TransaccionAppService();

      transaccion.setNumTarjeta(cuentaVM.getNumTarjeta());
      transaccion.setBanco("INBS");
      transaccion.setCodigo(transaccionAS.generarCodigo("INBS"));
      transaccion.setCantidadRetiro(cuentaVM.getCantidadRetiro());

      if (actualizarSaldo(cuentaVM)) {

        if (!transaccionDAO.insertarTransaccion(transaccion)) {
          return Response.status(Status.BAD_REQUEST).entity("{\"error\": \"Error en la Transaccion\"}").build();
        }
        return Response.ok("{\"mensaje\": \"Transaccion Completada\", \"codigo\":\"" + transaccion.getCodigo() + "\"}")
            .build();
      }

      return Response.ok("{\"mensaje\": \"Transaccion Completada\"}").build();
    }

    return Response.status(Status.BAD_GATEWAY).entity("{\"error\": \"error\"}").build();
  }

  public Response retiroExterno(CuentaViewModel cuentaVM, String banco) {

    CajeroCQRS cajeroCQRS = new CajeroCQRS();

    if (cajeroCQRS.validarSaldo(cuentaVM, 1) == false) {
      return Response.status(Status.BAD_REQUEST).entity("{\"error\": \"Saldo del cajero insuficiente\"}").build();
    }

    Transaccion transaccion = new Transaccion();
    TransaccionDAO transaccionDAO = new TransaccionDAO();
    TransaccionAppService transaccionAS = new TransaccionAppService();

    transaccion.setNumTarjeta(cuentaVM.getNumTarjeta());
    transaccion.setBanco(banco);
    transaccion.setCodigo(transaccionAS.generarCodigo(banco));
    transaccion.setCantidadRetiro(cuentaVM.getCantidadRetiro());

    if (actualizarSaldo(cuentaVM)) {

      if (!transaccionDAO.insertarTransaccion(transaccion)) {
        return Response.status(Status.BAD_REQUEST).entity("{\"error\": \"Error de Retiro\"}").build();
      }
      return Response.ok("{\"mensaje\": \"Transaccion Completada\", \"codigo\":\"" + transaccion.getCodigo() + "\"}")
          .build();
    }

    return Response.status(Status.BAD_GATEWAY).entity("{\"error\": error}").build();
  }

}
