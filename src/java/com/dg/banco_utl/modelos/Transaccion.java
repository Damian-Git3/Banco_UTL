package com.dg.banco_utl.modelos;

/**
 *
 * @author Damian Gamboa
 */
public class Transaccion {
    
    private int idTransaccion;
    private String numTarjeta;
    private String banco;
    private String codigo;
    private int cantidadRetiro;

    public Transaccion(int idTransaccion, String numTarjeta, String banco, String codigo, int cantidadRetiro) {
        this.idTransaccion = idTransaccion;
        this.numTarjeta = numTarjeta;
        this.banco = banco;
        this.codigo = codigo;
        this.cantidadRetiro = cantidadRetiro;
    }

    public Transaccion(String numTarjeta, String banco, String codigo, int cantidadRetiro) {
        this.numTarjeta = numTarjeta;
        this.banco = banco;
        this.codigo = codigo;
        this.cantidadRetiro = cantidadRetiro;
    }

    public Transaccion() {
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidadRetiro() {
        return cantidadRetiro;
    }

    public void setCantidadRetiro(int cantidadRetiro) {
        this.cantidadRetiro = cantidadRetiro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaccion{");
        sb.append("idTransaccion=").append(idTransaccion);
        sb.append(", numTarjeta=").append(numTarjeta);
        sb.append(", banco=").append(banco);
        sb.append(", codigo=").append(codigo);
        sb.append(", cantidadRetiro=").append(cantidadRetiro);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
