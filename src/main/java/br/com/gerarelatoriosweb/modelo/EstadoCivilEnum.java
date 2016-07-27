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
public enum EstadoCivilEnum {
        S("solteiro"), C("casado"),D("divorciado"),V("viuvo");
	private String descricao;	
        private EstadoCivilEnum(String descricao) {
		this.descricao= descricao;
	}

    public String getDescricao() {
        return descricao;
    }

 
	
}
