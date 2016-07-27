/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

/**
 *
 * @author byron
 */

public enum TipoClienteEnum{
    PF("Pessoa Física"),PJ("Pessoa Jurídica");
      
   private String item;
   private TipoClienteEnum(String item){
      this.item = item;
   }
   public String getItem(){
      return this.item;
   }
}

