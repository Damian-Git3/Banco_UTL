/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dg.banco_utl.appservice;

/**
 *
 * @author damia
 */
public class TransaccionAppService {

  public String generarCodigo(String banco) {
    String codigo = banco + "-";
    int numero = 0;
    for (int i = 0; i < 4; i++) {
      numero = (int) (Math.random() * 10);
      codigo += numero;
    }
    return codigo;
  }
    
}
