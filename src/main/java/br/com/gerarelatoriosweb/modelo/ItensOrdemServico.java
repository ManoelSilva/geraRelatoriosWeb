/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author byron
 */
@Entity
@Table(name = "tbitensordemservico")
public class ItensOrdemServico {

    @Id
    private Integer id;
    private boolean habilitado;
    private int item;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Servicos servico;
    @ManyToOne
    @JoinColumn(name = "os_id")
    private OS ordens;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Tecnico tecnico;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private StatusItem statusItem;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Equipamento equipamento;
    private String ordemEnvio;
    private Calendar execucao;
    private String devolvido;
    private String acaoTomada;
    private String obsSac;
    private String irdHabilitado;
    private String responsavelPagamento;
    private String propriedadeEquipamento;
    private String modoPagamento;
    private String numeroIrdModelo;
    private String numeroSmartCard;
    private String obsDevMonitor;
    private String motivoDevolucao;
    private String obsDevCredenciado;
    private String laudoTecnico;
    private String faltaEstoque;
    private String numeroProposta;
    private String credenciadoBonus;
    private String credenciadoMulta;
    private String parceiro;
    private String ultimaMovimentacao;
    private String ativacao;
    private String cancelamento;
    private String observacao;
    @OneToOne(cascade = CascadeType.ALL)
    private Rota rota;

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public OS getOrdens() {
        return ordens;
    }

    public void setOrdens(OS ordens) {
        this.ordens = ordens;
    }

    public String getUltimaMovimentacao() {
        return ultimaMovimentacao;
    }

    public void setUltimaMovimentacao(String ultimaMovimentacao) {
        this.ultimaMovimentacao = ultimaMovimentacao;
    }

    public String getAtivacao() {
        return ativacao;
    }

    public void setAtivacao(String ativacao) {
        this.ativacao = ativacao;
    }

    public String getCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(String cancelamento) {
        this.cancelamento = cancelamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public String getParceiro() {
        return parceiro;
    }

    public void setParceiro(String parceiro) {
        this.parceiro = parceiro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    public String getOrdemEnvio() {
        return ordemEnvio;
    }

    public void setOrdemEnvio(String ordemEnvio) {
        this.ordemEnvio = ordemEnvio;
    }

    public Calendar getExecucao() {
        return execucao;
    }

    public void setExecucao(Calendar execucao) {
        this.execucao = execucao;
    }

    public String getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(String devolvido) {
        this.devolvido = devolvido;
    }

    public String getAcaoTomada() {
        return acaoTomada;
    }

    public void setAcaoTomada(String acaoTomada) {
        this.acaoTomada = acaoTomada;
    }

    public String getObsSac() {
        return obsSac;
    }

    public void setObsSac(String obsSac) {
        this.obsSac = obsSac;
    }

    public String getIrdHabilitado() {
        return irdHabilitado;
    }

    public void setIrdHabilitado(String irdHabilitado) {
        this.irdHabilitado = irdHabilitado;
    }

    public String getResponsavelPagamento() {
        return responsavelPagamento;
    }

    public void setResponsavelPagamento(String responsavelPagamento) {
        this.responsavelPagamento = responsavelPagamento;
    }

    public String getPropriedadeEquipamento() {
        return propriedadeEquipamento;
    }

    public void setPropriedadeEquipamento(String propriedadeEquipamento) {
        this.propriedadeEquipamento = propriedadeEquipamento;
    }

    public String getModoPagamento() {
        return modoPagamento;
    }

    public void setModoPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    public String getNumeroIrdModelo() {
        return numeroIrdModelo;
    }

    public void setNumeroIrdModelo(String numeroIrdModelo) {
        this.numeroIrdModelo = numeroIrdModelo;
    }

    public String getNumeroSmartCard() {
        return numeroSmartCard;
    }

    public void setNumeroSmartCard(String numeroSmartCard) {
        this.numeroSmartCard = numeroSmartCard;
    }

    public StatusItem getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(StatusItem statusItem) {
        this.statusItem = statusItem;
    }

    public String getObsDevMonitor() {
        return obsDevMonitor;
    }

    public void setObsDevMonitor(String obsDevMonitor) {
        this.obsDevMonitor = obsDevMonitor;
    }

    public String getMotivoDevolucao() {
        return motivoDevolucao;
    }

    public void setMotivoDevolucao(String motivoDevolucao) {
        this.motivoDevolucao = motivoDevolucao;
    }

    public String getObsDevCredenciado() {
        return obsDevCredenciado;
    }

    public void setObsDevCredenciado(String obsDevCredenciado) {
        this.obsDevCredenciado = obsDevCredenciado;
    }

    public String getLaudoTecnico() {
        return laudoTecnico;
    }

    public void setLaudoTecnico(String laudoTecnico) {
        this.laudoTecnico = laudoTecnico;
    }

    public String getFaltaEstoque() {
        return faltaEstoque;
    }

    public void setFaltaEstoque(String faltaEstoque) {
        this.faltaEstoque = faltaEstoque;
    }

    public String getNumeroProposta() {
        return numeroProposta;
    }

    public void setNumeroProposta(String numeroProposta) {
        this.numeroProposta = numeroProposta;
    }

    public String getCredenciadoBonus() {
        return credenciadoBonus;
    }

    public void setCredenciadoBonus(String credenciadoBonus) {
        this.credenciadoBonus = credenciadoBonus;
    }

    public String getCredenciadoMulta() {
        return credenciadoMulta;
    }

    public void setCredenciadoMulta(String credenciadoMulta) {
        this.credenciadoMulta = credenciadoMulta;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }
    
    

}
