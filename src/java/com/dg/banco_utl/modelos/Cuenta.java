package com.dg.banco_utl.modelos;

/**
 *
 * @author Damian Gamboa
 */
public class Cuenta {
    
    private int idCuenta;
    private String nombre;
    private String apellidop;
    private String apellidom;
    private int capital;
    private String banco;
    private String nip;
    private String numTarjeta;

    public Cuenta(int idCuenta, String nombre, String apellidop, String apellidom, int capital, String banco,String nip, String numTarjeta) {
        this.idCuenta = idCuenta;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.capital = capital;
        this.banco = banco;
        this.nip = nip;
        this.numTarjeta = numTarjeta;
    }

    public Cuenta(String nombre, String apellidop, String apellidom, int capital, String banco,String nip, String numTarjeta) {
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.capital = capital;
        this.banco = banco;
        this.nip = nip;
        this.numTarjeta = numTarjeta;
    }

    public Cuenta() {
    }
    
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public void setNip(String nip){
        this.nip = nip;
    }

    public String getNip(){
        return nip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{idCuenta=").append(idCuenta);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellidop=").append(apellidop);
        sb.append(", apellidom=").append(apellidom);
        sb.append(", capital=").append(capital);
        sb.append(", banco=").append(banco);
        sb.append(", nip=").append(nip);
        sb.append(", numTarjeta=").append(numTarjeta);
        sb.append('}');
        return sb.toString();
    }
    
    
}
