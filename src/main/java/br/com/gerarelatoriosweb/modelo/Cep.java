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
public class Cep {

    //Classe usada na consulta no webService dos correios

    private String cidade;
    private String rua;
    private String cep;
    private String bairro;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String [] local = cidade.split("\\s+");
        this.cidade = local[1].trim();
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua.trim();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro.trim();
    }
    
    

}
