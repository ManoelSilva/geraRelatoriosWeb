/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author byron
 */
@Table(name="tbindice") 
@Entity
public class Indice implements Serializable{
    private static final long serialVersionUID = 2806421523585360625L;
    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    @Column(unique = true)
    private String nome;
    private BigDecimal valor;
    private boolean habilitado;
    private BigDecimal remuneracaoIndice;
    private BigDecimal remuneracaoForaIndice;

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public BigDecimal getRemuneracaoIndice() {
        return remuneracaoIndice;
    }

    public void setRemuneracaoIndice(BigDecimal remuneracaoIndice) {
        this.remuneracaoIndice = remuneracaoIndice;
    }

    public BigDecimal getRemuneracaoForaIndice() {
        return remuneracaoForaIndice;
    }

    public void setRemuneracaoForaIndice(BigDecimal remuneracaoForaIndice) {
        this.remuneracaoForaIndice = remuneracaoForaIndice;
    }
    
    
    
}
