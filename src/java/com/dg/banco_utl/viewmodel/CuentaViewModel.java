/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dg.banco_utl.viewmodel;

/**
 *
 * @author damia
 */
public class CuentaViewModel {
    
    private String numTarjeta;
    private String nip;
    private int cantidadRetiro;

    public CuentaViewModel(String numTarjeta, String nip, int cantidadRetiro) {
        this.numTarjeta = numTarjeta;
        this.nip = nip;
        this.cantidadRetiro = cantidadRetiro;
    }

    public CuentaViewModel() {
    }
    
    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public int getCantidadRetiro() {
        return cantidadRetiro;
    }

    public void setCantidadRetiro(int cantidadRetiro) {
        this.cantidadRetiro = cantidadRetiro;
    }
    
    
}
