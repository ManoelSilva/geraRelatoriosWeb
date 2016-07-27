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

public enum EstadosEnum {
    AC("Acre"),AL("Alagoas"),AP("Amapá"),AM("Amazonas"),BA("Bahia"),CE("Ceará"),DF("Distrito Federal"),ES("Espirito Santo"),GO("Goiás"),
    MA("Maranhã"),MT("Mato Grosso"),MS("Mato Grosso do Sul"),MG("Minas Gerais"),PA("Pará"),PB("Paraíba"),PR("Parana"),PE("Pernambuco"),
    PI("Piauí"),RJ("Rio de Janeiro"),RN("Rio Grande do Norte"),RS("Rio Grande do Sul"),RO("Roraima"),RR("Rondônia"),SC("Santa Catarina"),SP("São Paulo"),
    SE("Sergipe"),TO("Tocantins");
      
        private String descricao;
        
        private EstadosEnum(String descricao) {
		this.descricao= descricao;
	}
	public String toString() {
		return this.descricao;
	}
}

