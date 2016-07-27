/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author byron
 */
@Table(name = "tbvistoria")
@Entity
public class Vistoria implements Serializable {

    private static final long serialVersionUID = 2806421523585360625L;
    @Id
    @GeneratedValue
    private int id;
    private Calendar data;
    private StatusVistoriaEnum statusVistoriaEnum;
    private Calendar inicio;
    private Calendar termino;
    private boolean habilitado;
    private boolean moduloTerrestre;
    private boolean moduloFuncionando;
    private String pdv;
    private String tipoInstalacao;
    private boolean lcdLed;
    private boolean bandaLarga;
    private String provedor;
    private String tipoLNB;
    private boolean SBTVD;
    private String ponto;
    private String modelo;
    private String smartCard;
    private String checkupSky;
    private int nivelSinal;
    private String instalacaoAntena;
    private String conexaoDistribuicao;
    private String outros;
    private String antena;
    private String cabo;
    private String servicoTec;
    private String atendimento;
    private String sky;
    private String LNB;
    private String Distribuicao;
    @NotEmpty
    private String comentario;
    @NotNull
    @OneToOne
    private OS os;

    public Calendar getInicio() {
        return inicio;
    }

    public void setInicio(Calendar inicio) {
        this.inicio = inicio;
    }

    public Calendar getTermino() {
        return termino;
    }

    public void setTermino(Calendar termino) {
        this.termino = termino;
    }

    public boolean isModuloTerrestre() {
        return moduloTerrestre;
    }

    public void setModuloTerrestre(boolean moduloTerrestre) {
        this.moduloTerrestre = moduloTerrestre;
    }

    public boolean isModuloFuncionando() {
        return moduloFuncionando;
    }

    public void setModuloFuncionando(boolean moduloFuncionando) {
        this.moduloFuncionando = moduloFuncionando;
    }

    public String getPdv() {
        return pdv;
    }

    public void setPdv(String pdv) {
        this.pdv = pdv;
    }

    public String getTipoInstalacao() {
        return tipoInstalacao;
    }

    public void setTipoInstalacao(String tipoInstalacao) {
        this.tipoInstalacao = tipoInstalacao;
    }

    public boolean isLcdLed() {
        return lcdLed;
    }

    public void setLcdLed(boolean lcdLed) {
        this.lcdLed = lcdLed;
    }

    public boolean isBandaLarga() {
        return bandaLarga;
    }

    public void setBandaLarga(boolean bandaLarga) {
        this.bandaLarga = bandaLarga;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public String getTipoLNB() {
        return tipoLNB;
    }

    public void setTipoLNB(String tipoLNB) {
        this.tipoLNB = tipoLNB;
    }

    public boolean isSBTVD() {
        return SBTVD;
    }

    public void setSBTVD(boolean SBTVD) {
        this.SBTVD = SBTVD;
    }

    public String getPonto() {
        return ponto;
    }

    public void setPonto(String ponto) {
        this.ponto = ponto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSmartCard() {
        return smartCard;
    }

    public void setSmartCard(String smartCard) {
        this.smartCard = smartCard;
    }

    public String getCheckupSky() {
        return checkupSky;
    }

    public void setCheckupSky(String checkupSky) {
        this.checkupSky = checkupSky;
    }

    public int getNivelSinal() {
        return nivelSinal;
    }

    public void setNivelSinal(int nivelSinal) {
        this.nivelSinal = nivelSinal;
    }

    public String getInstalacaoAntena() {
        return instalacaoAntena;
    }

    public void setInstalacaoAntena(String instalacaoAntena) {
        this.instalacaoAntena = instalacaoAntena;
    }

    public String getConexaoDistribuicao() {
        return conexaoDistribuicao;
    }

    public void setConexaoDistribuicao(String conexaoDistribuicao) {
        this.conexaoDistribuicao = conexaoDistribuicao;
    }

    public String getOutros() {
        return outros;
    }

    public void setOutros(String outros) {
        this.outros = outros;
    }

    public String getAntena() {
        return antena;
    }

    public void setAntena(String antena) {
        this.antena = antena;
    }

    public String getCabo() {
        return cabo;
    }

    public void setCabo(String cabo) {
        this.cabo = cabo;
    }

    public String getServicoTec() {
        return servicoTec;
    }

    public void setServicoTec(String servicoTec) {
        this.servicoTec = servicoTec;
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }

    public String getSky() {
        return sky;
    }

    public void setSky(String sky) {
        this.sky = sky;
    }

    public String getLNB() {
        return LNB;
    }

    public void setLNB(String LNB) {
        this.LNB = LNB;
    }

    public String getDistribuicao() {
        return Distribuicao;
    }

    public void setDistribuicao(String Distribuicao) {
        this.Distribuicao = Distribuicao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public StatusVistoriaEnum getStatusVistoria() {
        return statusVistoriaEnum;
    }

    @Enumerated(EnumType.STRING)
    public void setStatusVistoriaEnum(StatusVistoriaEnum statusVistoriaEnum) {
        this.statusVistoriaEnum = statusVistoriaEnum;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

}
