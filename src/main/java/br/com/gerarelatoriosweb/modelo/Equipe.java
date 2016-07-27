/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.util.List;  
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author byron
 */
@Entity
@Table(name = "tbequipe")
public class Equipe implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    private String nome;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Servicos> servicos;
    private boolean habilitado;
    @OneToMany(mappedBy = "equipe")
    
    private List<Tecnico> tecnico;

    public List<Tecnico> getTecnico() {
        return tecnico;
    }

    public void setTecnico(List<Tecnico> tecnico) {
        this.tecnico = tecnico;
    }
  
    public List<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servicos> servicos) {
        this.servicos = servicos;
    }

   

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
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


}
