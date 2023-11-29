package com.dg.banco_utl.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.dg.banco_utl.modelos.Cajero;
import com.dg.bu.db.ConexionMySQL;

/**
 *
 * @author Damian Gamboa
 */
public class CajeroDAO {

  ConexionMySQL conexion = new ConexionMySQL();
  Connection connection;

  public List<Cajero> obtenerCajeros() {
    List<Cajero> cajeros = new ArrayList<>();
    try {
      connection = conexion.open();// obtener la conexión a la base de datos
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM cajeros");

      while (resultSet.next()) {
        Cajero cajero = new Cajero(
            resultSet.getInt("idcajeros"),
            resultSet.getString("nombre"),
            resultSet.getInt("cantidad"));

        cajeros.add(cajero);
      }

      resultSet.close();
      statement.close();
      connection.close();
      conexion.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return cajeros;
  }

  public boolean updateCajero(int cantidad, int idCajero) {

    try {
      connection = conexion.open();// obtener la conexión a la base de datos
      PreparedStatement preparedStatement = connection
          .prepareStatement("UPDATE cajeros SET cantidad = ? WHERE idcajeros = ?");
      preparedStatement.setInt(1, cantidad);
      preparedStatement.setInt(2, 1);
      preparedStatement.executeUpdate();
      preparedStatement.close();
      connection.close();
      conexion.close();

      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  public int getCantidadCajero(int idCajero) {
    int cantidadCajero = 0;

    try {
      connection = conexion.open();
      PreparedStatement preparedStatement = connection
          .prepareStatement("SELECT cantidad FROM cajeros WHERE idcajeros = ?");

      preparedStatement.setInt(1, idCajero);

      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()) {
        cantidadCajero = resultSet.getInt("cantidad");
      }

      resultSet.close();
      preparedStatement.close();
      connection.close();
      conexion.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    return cantidadCajero;
  }

}
