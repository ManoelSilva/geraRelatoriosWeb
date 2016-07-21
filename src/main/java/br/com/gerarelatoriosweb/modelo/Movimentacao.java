/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author touti
 */
@Entity @Table(name = "movimentacoes")
public class Movimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //private Integer categoria_id;
    //private Integer conta_id;
    @Temporal(TemporalType.DATE)
    private Calendar data;
    private BigDecimal valor;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;
    @ManyToMany
    private List<Categoria> categoria;
    @ManyToOne
    private Conta conta;

    /*public Integer getCategoria_id() {
    return categoria_id;
    }
    
    public void setCategoria_id(Integer categoria_id) {
    this.categoria_id = categoria_id;
    }
    
    public Integer getConta_id() {
    return conta_id;
    }
    
    public void setConta_id(Integer conta_id) {
    this.conta_id = conta_id;
    }*/
    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(TipoMovimentacao tipo) {
        this.tipoMovimentacao = tipo;
    }

}
