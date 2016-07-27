/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.util.Date;

/**
 *
 * @author touti
 */
public class OSRelatorio {

    private OS os;

    public OSRelatorio(OS os) {
        this.os = os;
    }

    public String getNome() {
        return this.getStatus().getNome();
    }

    public Date getDataAgendamento() {
        return os.getDataAgendamento().getTime();
    }

    public Date getDataLiberacao() {
        return os.getDataLiberacao().getTime();
    }

    public Date getDataDirecionamento() {
        return os.getDataDirecionamento().getTime();
    }

    public Date getDataExecucao() {
        return os.getDataExecucao().getTime();
    }

    public Status getStatus() {
        return os.getStatus();
    }

    public Date getDataFinalizacao() {
        return os.getDataFinalizacao().getTime();
    }

    public Date getDataCriacao() {
        return os.getDataCriacao().getTime();
    }

}
