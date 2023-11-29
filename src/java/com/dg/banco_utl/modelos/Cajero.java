package com.dg.banco_utl.modelos;

/**
 *
 * @author Damian Gamboa
 */
public class Cajero {
    
    private int idCajero;
    private String nombre;
    private int cantidad;

    public Cajero(int idCajero, String nombre, int cantidad) {
        this.idCajero = idCajero;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Cajero() {
    }

    public Cajero(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cajero{");
        sb.append("idCajero=").append(idCajero);
        sb.append(", nombre=").append(nombre);
        sb.append(", cantidad=").append(cantidad);
        sb.append('}');
        return sb.toString();
    }
    
    
}
