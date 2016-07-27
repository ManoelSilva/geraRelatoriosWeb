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
public enum StatusPosAtendimentoEnum {

    R("Realizado com sucesso"), RF("Tentativa sem sucesso"),N("Não foi feito");

    private String item;

    private StatusPosAtendimentoEnum(String item) {
        this.item = item;
    }

    public String getItem() {
        return this.item;
    }

}
