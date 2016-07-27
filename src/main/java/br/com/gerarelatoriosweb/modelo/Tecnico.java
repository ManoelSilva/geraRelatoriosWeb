/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author byron
 */
@Entity
@Table(name = "tbtecnico")
public class Tecnico implements Serializable {

    private static final long serialVersionUID = 2806421523585360625L;
    @Id
    @GeneratedValue
    private int id;
    private BigDecimal numeroOs;
    private BigDecimal valorOs;
    @ManyToOne
    private Equipe equipe;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="tecnico_areas",
            joinColumns = @JoinColumn(name="TECNICO_id"),
            inverseJoinColumns = @JoinColumn(name = "AREA_id"))
    private List<Area> areas;
    @OneToOne
    private Funcionario funcionario;
    private boolean habilitado;
    @ManyToMany(mappedBy = "lista")
    private List<FrequenciaTecnico> listaFrequencia = new ArrayList<FrequenciaTecnico>();

    public List<FrequenciaTecnico> getListaFrequencia() {
        return listaFrequencia;
    }

    public void setListaFrequencia(List<FrequenciaTecnico> listaFrequencia) {
        this.listaFrequencia = listaFrequencia;
    }

    private String idSky;

    public String getIdSky() {
        return idSky;
    }

    public void setIdSky(String idSky) {
        this.idSky = idSky;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getNumeroOs() {
        return numeroOs;
    }

    public void setNumeroOs(BigDecimal numeroOs) {
        this.numeroOs = numeroOs;
    }

    public BigDecimal getValorOs() {
        return valorOs;
    }

    public void setValorOs(BigDecimal valorOs) {
        this.valorOs = valorOs;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

}
