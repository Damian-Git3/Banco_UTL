package com.dg.banco_utl.cqrs;

import com.dg.banco_utl.dao.CajeroDAO;
import com.dg.banco_utl.viewmodel.CuentaViewModel;

/**
 *
 * @author Damian Gamboa
 */
public class CajeroCQRS {

  CajeroDAO cajeroDAO = new CajeroDAO();

  public boolean validarSaldo(CuentaViewModel cuentavm, int idCajero) {
    int saldo = cajeroDAO.getCantidadCajero(idCajero);

    if (saldo >= cuentavm.getCantidadRetiro()) {
      return true;
    }

    return false;
  }

}
