/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author byron
 */
@Entity
@Table(name = "tbreagendamento")
public class Reagendamento {

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Motivo motivo;
    @NotNull
    private String agendamentoConfirmacao;
    @NotNull
    private String novaData;
    @NotNull
    private TurnoEnum turnoEnum;
    @NotNull
    private int osNumero;
    private boolean habilitado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    

    public int getOsNumero() {
        return osNumero;
    }

    public void setOsNumero(int osNumero) {
        this.osNumero = osNumero;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }

    public String getAgendamentoConfirmacao() {
        return agendamentoConfirmacao;
    }

    public void setAgendamentoConfirmacao(String agendamentoConfirmacao) {
        this.agendamentoConfirmacao = agendamentoConfirmacao;
    }

    public String getNovaData() {
        return novaData;
    }

    public void setNovaData(String novaData) {
        this.novaData = novaData;
    }

    @Enumerated(EnumType.STRING)
    public TurnoEnum getTurnoEnum() {
        return turnoEnum;
    }

    @Enumerated(EnumType.STRING)
    public void setTurnoEnum(TurnoEnum turnoEnum) {
        this.turnoEnum = turnoEnum;
    }

}
