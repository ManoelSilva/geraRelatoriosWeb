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
@Table(name = "tbestoque")
public class Estoque implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private BigDecimal estoque;
    @OneToOne(mappedBy = "estoque")
    private Produto produto;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "produtos")
    private List<EstoqueSerial> seriais;

    public List<EstoqueSerial> getSeriais() {
        return seriais;
    }

    public void setSeriais(List<EstoqueSerial> seriais) {
        this.seriais = seriais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getEstoque() {
        return estoque;
    }

    public void setEstoque(BigDecimal estoque) {
        this.estoque = estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
