package com.dg.bu.db;

/**
 *
 * @author Componentes Unidos
 * @date 20/10/2022
 */
public class PruebaConexion {
    
    public static void main(String[] args) {
        ConexionMySQL connMySQl = new ConexionMySQL();
        try {
            connMySQl.open();
            System.out.println("Conexión establecida con MySQl!");
            connMySQl.close();
            System.out.println("Conexión Cerrada correctamente con MySQL!");
            
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }
    }
}
