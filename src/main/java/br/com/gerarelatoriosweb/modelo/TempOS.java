/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.util.Calendar;

/**
 *
 * @author byron
 */
public class TempOS {

    private int id;
    private Status status;
    private Calendar DataCriacao;
    private String confirmacaoAgendameto;

    public String getConfirmacaoAgendameto() {
        return confirmacaoAgendameto;
    }

    public void setConfirmacaoAgendameto(String confirmacaoAgendameto) {
        this.confirmacaoAgendameto = confirmacaoAgendameto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Calendar getDataCriacao() {
        return DataCriacao;
    }

    public void setDataCriacao(Calendar DataCriacao) {
        this.DataCriacao = DataCriacao;
    }

}
