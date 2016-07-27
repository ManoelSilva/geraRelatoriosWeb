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
public enum StatusVistoriaEnum {

   R("Realizada"),A("Agendada");
      
   private String item;

    private StatusVistoriaEnum(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

}
