/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dg.banco_utl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dg.banco_utl.modelos.Transaccion;
import com.dg.bu.db.ConexionMySQL;

/**
 *
 * @author damia
 */
public class TransaccionDAO {

  ConexionMySQL conexion = new ConexionMySQL();
  Connection connection;

  public Boolean insertarTransaccion(Transaccion transaccion) {
        try {
            connection = conexion.open();
            String sql = "INSERT INTO transacciones (numtarjeta, banco, codigo, cantidadretiro) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, transaccion.getNumTarjeta());
            pstmt.setString(2, transaccion.getBanco());
            pstmt.setString(3, transaccion.getCodigo());
            pstmt.setInt(4, transaccion.getCantidadRetiro());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();
            conexion.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    
}
