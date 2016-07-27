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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author byron
 */
@Entity
@Table(name="tbexpedicao") 
public class Expedicao implements Serializable{
private static final long serialVersionUID = 2806421523585360625L;    
    @Id
    @GeneratedValue
    private int id;
    private int idExpedicao;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EstoqueSerial> seriais;
    @OneToOne
    private Produto produtos;
    private BigDecimal Quantidade;
    @OneToOne
    private CFOP CFOP;
    private String descricao;
    private Calendar data;
    @OneToOne
    private Fornecedor fornecedor;
    private BigDecimal valorNota;
    private String chaveNota;

    public Produto getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    
    
    public int getIdExpedicao() {
        return idExpedicao;
    }

    public void setIdExpedicao(int idExpedicao) {
        this.idExpedicao = idExpedicao;
    }

    public List<EstoqueSerial> getSeriais() {
        return seriais;
    }

    public void setSeriais(List<EstoqueSerial> seriais) {
        this.seriais = seriais;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public BigDecimal getValorNota() {
        return valorNota;
    }

    public void setValorNota(BigDecimal valorNota) {
        this.valorNota = valorNota;
    }

    public String getChaveNota() {
        return chaveNota;
    }

    public void setChaveNota(String chaveNota) {
        this.chaveNota = chaveNota;
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(BigDecimal Quantidade) {
        this.Quantidade = Quantidade;
    }

    public CFOP getCFOP() {
        return CFOP;
    }

    public void setCFOP(CFOP CFOP) {
        this.CFOP = CFOP;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
