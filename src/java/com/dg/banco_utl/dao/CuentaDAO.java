    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dg.banco_utl.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.dg.banco_utl.modelos.Cuenta;
import com.dg.bu.db.ConexionMySQL;

/**
 *
 * @author Damian Gamboa
 */
public class CuentaDAO {

  ConexionMySQL conexion = new ConexionMySQL();
  Connection connection;

  public List<Cuenta> getAll() {
    List<Cuenta> cuentas = new ArrayList<>();

    try {

      connection = conexion.open();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM cuentas");

      while (resultSet.next()) {
        Cuenta cuenta = new Cuenta(
            resultSet.getInt("idcuenta"),
            resultSet.getString("nombre"),
            resultSet.getString("apellidop"),
            resultSet.getString("apellidom"),
            resultSet.getInt("capital"),
            resultSet.getString("banco"),
            resultSet.getString("nip"),
            resultSet.getString("numtarjeta"));
        cuentas.add(cuenta);
      }

      resultSet.close();
      statement.close();
      connection.close();
      conexion.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return cuentas;
  }

  public Cuenta getByNumTarjeta(String numTarjeta) {
    Cuenta cuenta = null;

    try {
      connection = conexion.open();
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cuentas WHERE numtarjeta = ?");
      preparedStatement.setString(1, numTarjeta);
      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        cuenta = new Cuenta(
            resultSet.getInt("idcuenta"),
            resultSet.getString("nombre"),
            resultSet.getString("apellidop"),
            resultSet.getString("apellidom"),
            resultSet.getInt("capital"),
            resultSet.getString("banco"),
            resultSet.getString("nip"),
            resultSet.getString("numtarjeta"));
      }

      resultSet.close();
      preparedStatement.close();
      connection.close();
      conexion.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return cuenta;
  }

  public Cuenta update(Cuenta cuenta) {
    try {
      connection = conexion.open();
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cuentas SET capital = ? WHERE numtarjeta = ?");
      preparedStatement.setInt(1, cuenta.getCapital());
      preparedStatement.setString(2, cuenta.getNumTarjeta());
      preparedStatement.executeUpdate();
      preparedStatement.close();

      // Retrieve the updated account
      preparedStatement = connection.prepareStatement("SELECT * FROM cuentas WHERE numtarjeta = ?");
      preparedStatement.setString(1, cuenta.getNumTarjeta());
      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        cuenta = new Cuenta(
            resultSet.getInt("idcuenta"),
            resultSet.getString("nombre"),
            resultSet.getString("apellidop"),
            resultSet.getString("apellidom"),
            resultSet.getInt("capital"),
            resultSet.getString("banco"),
            resultSet.getString("nip"),
            resultSet.getString("numtarjeta"));
      }

      resultSet.close();
      preparedStatement.close();
      connection.close();
      conexion.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return cuenta;
  }

}
