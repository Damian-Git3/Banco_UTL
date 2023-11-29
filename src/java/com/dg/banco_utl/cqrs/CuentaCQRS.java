package com.dg.banco_utl.cqrs;

import com.dg.banco_utl.dao.CuentaDAO;
import com.dg.banco_utl.modelos.Cuenta;
import com.dg.banco_utl.viewmodel.CuentaViewModel;

/**
 *
 * @author Damian Gamboa
 */
public class CuentaCQRS {
  private CuentaDAO cuentaDao = null;

  public Boolean validarNip(CuentaViewModel cuentavm) {

    cuentaDao = new CuentaDAO();
    Cuenta cuenta = new Cuenta();

    cuenta = cuentaDao.getByNumTarjeta(cuentavm.getNumTarjeta());

    if (cuenta.getNip().equals(cuentavm.getNip())) {
      return true;
    }

    return false;
  }

  public Boolean validarSaldo(CuentaViewModel cuentavm) {

    cuentaDao = new CuentaDAO();
    Cuenta cuenta = new Cuenta();

    cuenta = cuentaDao.getByNumTarjeta(cuentavm.getNumTarjeta());

    if (cuenta.getCapital() >= cuentavm.getCantidadRetiro()) {
      return true;
    }

    return false;
  }

  public Boolean validarNumTarjeta(CuentaViewModel cuentavm) {

    cuentaDao = new CuentaDAO();
    Cuenta cuenta = new Cuenta();

    cuenta = cuentaDao.getByNumTarjeta(cuentavm.getNumTarjeta());
    
    if(cuenta == null){
      return false;
    }

    if (cuenta.getNumTarjeta().equals(cuentavm.getNumTarjeta())) {
      return true;
    }

    return false;
  }

  public Boolean actualizarSaldo(String numTarjeta, int cantidadRetiro) {

    cuentaDao = new CuentaDAO();
    Cuenta cuenta = new Cuenta();

    cuenta = cuentaDao.getByNumTarjeta(numTarjeta);
    System.out.println("Cuenta: " + cuenta.toString());
    System.out.println("Cantidad Retiro: " + cantidadRetiro);

    if (cuenta.getCapital() < +cantidadRetiro) {

      return false;
    }

    cuenta.setCapital(cuenta.getCapital() - cantidadRetiro);

    cuentaDao.update(cuenta);
    return true;

  }

}
