/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author byron
 */
@Table(name="tbncm") 
@Entity
public class Ncm implements Serializable{
    private static final long serialVersionUID = 2806421523585360625L;
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private int ncmCodigo;

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

    public int getNcmCodigo() {
        return ncmCodigo;
    }

    public void setNcmCodigo(int ncmCodigo) {
        this.ncmCodigo = ncmCodigo;
    }
    
    
    
}
