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
@Table(name = "tbestoqueusuario")
public class EstoqueUsuario implements Serializable {

    private static final long serialVersionUID = 2806421523585360625L;
    @Id
    @GeneratedValue
    private int id;
    private BigDecimal estoque;
    @OneToOne
    private Produto produto;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EstoqueSerial> seriais;
    @OneToOne
    private Tecnico tecnico;

    public List<EstoqueSerial> getSeriais() {
        return seriais;
    }

    public void setSeriais(List<EstoqueSerial> seriais) {
        this.seriais = seriais;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
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
