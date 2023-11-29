package com.dg.banco_utl.modelos;

/**
 *
 * @author Damian Gamboa
 */
public class Banco {
    
    private int idBanco;
    private String nombre;
    private String clave;

    public Banco(int idBanco, String nombre, String clave) {
        this.idBanco = idBanco;
        this.nombre = nombre;
        this.clave = clave;
    }

    public Banco(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public Banco() {
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Banco{");
        sb.append("idBanco=").append(idBanco);
        sb.append(", nombre=").append(nombre);
        sb.append(", clave=").append(clave);
        sb.append('}');
        return sb.toString();
    }
    
}
