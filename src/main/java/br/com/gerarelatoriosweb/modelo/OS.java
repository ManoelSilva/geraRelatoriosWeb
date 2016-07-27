/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author byron
 */
@Entity
@Table(name = "tbos")
public class OS implements Serializable {

    private static final long serialVersionUID = 2806421523585360625L;

    @Id
    private int id;
    private Calendar dataCriacao;
    private Calendar dataAgendamento;
    private Calendar dataLiberacao;
    private Calendar dataDirecionamento;
    private Calendar dataExecucao;
    @ManyToOne
    @JoinColumn(name = "statusAgendamento_id", referencedColumnName = "id")
    private StatusAgendamento statusAgendamento;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "prioridade_id", referencedColumnName = "id")
    private Prioridade prioridade;
    private Calendar dataFinalizacao;
    private String confirmacaoAgendamento;
    private String planoVisita;
    private String obsCredenciado;
    private String obsSac;
    private boolean skyPremium;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "ordens",cascade = CascadeType.ALL)
    private List<ItensOrdemServico> itens;
    private boolean habilitado;

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public List<ItensOrdemServico> getItens() {
        return itens;
    }

    public void setItens(List<ItensOrdemServico> itens) {
        this.itens = itens;
    }

    public boolean isSkyPremium() {
        return skyPremium;
    }

    public void setSkyPremium(boolean skyPremium) {
        this.skyPremium = skyPremium;
    }

    public Calendar getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Calendar dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public Calendar getDataLiberacao() {
        return dataLiberacao;
    }

    public void setDataLiberacao(Calendar dataLiberacao) {
        this.dataLiberacao = dataLiberacao;
    }

    public Calendar getDataDirecionamento() {
        return dataDirecionamento;
    }

    public void setDataDirecionamento(Calendar dataDirecionamento) {
        this.dataDirecionamento = dataDirecionamento;
    }

    public Calendar getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Calendar dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public StatusAgendamento getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Calendar getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Calendar dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public String getConfirmacaoAgendamento() {
        return confirmacaoAgendamento;
    }

    public void setConfirmacaoAgendamento(String confirmacaoAgendamento) {
        this.confirmacaoAgendamento = confirmacaoAgendamento;
    }

    public String getPlanoVisita() {
        return planoVisita;
    }

    public void setPlanoVisita(String planoVisita) {
        this.planoVisita = planoVisita;
    }

    public String getObsCredenciado() {
        return obsCredenciado;
    }

    public void setObsCredenciado(String obsCredenciado) {
        this.obsCredenciado = obsCredenciado;
    }

    public String getObsSac() {
        return obsSac;
    }

    public void setObsSac(String obsSac) {
        this.obsSac = obsSac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



}
