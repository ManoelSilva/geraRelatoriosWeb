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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author byron
 */
@Table(name = "tbprodutos")
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 2806421523585360625L;
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    private String nome;
    private BigDecimal precoCusto;
    private boolean serialHabilitado;
    private boolean habilitado;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private SubGrupoProduto subgrupoProduto;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private GrupoProduto grupoProduto;
    private String ean13;
    private UnidadesEnum unidades;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Ncm ncm;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "estoque_id")
    private Estoque estoque;
    private BigDecimal estoqueMinimo;
    private BigDecimal estoqueMaximo;
    private boolean estoqueAlerta;
    private boolean foto;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "produtos")
    private List<Servicos> servicos;

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public List<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servicos> servicos) {
        this.servicos = servicos;
    }

    public boolean isSerialHabilitado() {
        return serialHabilitado;
    }

    public void setSerialHabilitado(boolean serialHabilitado) {
        this.serialHabilitado = serialHabilitado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(BigDecimal precoCusto) {
        this.precoCusto = precoCusto;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public SubGrupoProduto getSubgrupoProduto() {
        return subgrupoProduto;
    }

    public void setSubgrupoProduto(SubGrupoProduto subgrupoProduto) {
        this.subgrupoProduto = subgrupoProduto;
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    @Enumerated(EnumType.STRING)
    public UnidadesEnum getUnidades() {
        return unidades;
    }

    @Enumerated(EnumType.STRING)
    public void setUnidades(UnidadesEnum unidades) {
        this.unidades = unidades;
    }

    public Ncm getNcm() {
        return ncm;
    }

    public void setNcm(Ncm ncm) {
        this.ncm = ncm;
    }

    public BigDecimal getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(BigDecimal estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public BigDecimal getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(BigDecimal estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public boolean isEstoqueAlerta() {
        return estoqueAlerta;
    }

    public void setEstoqueAlerta(boolean estoqueAlerta) {
        this.estoqueAlerta = estoqueAlerta;
    }

    public boolean isFoto() {
        return foto;
    }

    public void setFoto(boolean foto) {
        this.foto = foto;
    }

}
