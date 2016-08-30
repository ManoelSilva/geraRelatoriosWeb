/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author byron
 */
@Table(name = "tbsevicos")
@Entity
public class Servicos implements Serializable {

    private static final long serialVersionUID = 2806421523585360625L;

    @Id
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private TipoServico tipoServico;
    @ManyToOne(cascade = CascadeType.ALL)
    private SubTipoServico subTipoServico;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Produto> produtos;
    private BigDecimal remuneracaoTecnico;
    private BigDecimal remuneracaoSky;
    private boolean habilitado;
    @NotEmpty
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SubTipoServico getSubTipoServico() {
        return subTipoServico;
    }

    public void setSubTipoServico(SubTipoServico subTipoServico) {
        this.subTipoServico = subTipoServico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public BigDecimal getRemuneracaoTecnico() {
        return remuneracaoTecnico;
    }

    public void setRemuneracaoTecnico(BigDecimal remuneracaoTecnico) {
        this.remuneracaoTecnico = remuneracaoTecnico;
    }

    public BigDecimal getRemuneracaoSky() {
        return remuneracaoSky;
    }

    public void setRemuneracaoSky(BigDecimal remuneracaoSky) {
        this.remuneracaoSky = remuneracaoSky;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

}
