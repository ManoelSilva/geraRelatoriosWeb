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
public enum UnidadesEnum {

    Pct("enum.pct"), 
    Mt("enum.mt");

    private String item;

    private UnidadesEnum(String item) {
        this.item = item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

}
