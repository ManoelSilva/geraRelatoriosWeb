/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author byron
 */
@Entity
@Table(name = "tbarea")
public class Area implements Serializable {

    private static final long serialVersionUID = 2806421523585360625L;
    @Id
    @GeneratedValue
    private Integer id;
    private boolean habilitado;
    @Column(unique = true)
    @NotEmpty
    private String descricao;
    @ManyToMany(mappedBy = "areas")
    private List<Tecnico> lista;

    public List<Tecnico> getLista() {
        return lista;
    }

    public void setLista(List<Tecnico> lista) {
        this.lista = lista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
