/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author byron
 */
@Entity
@Table(name = "tbfrequencia")
public class FrequenciaTecnico implements Serializable {

    private static final long serialVersionUID = 2806421523585360625L;
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private Calendar data;
    @ManyToMany
    @JoinTable(
            name = "Tecnico_Frequencia",
            joinColumns = @JoinColumn(name = "FREQUENCIATECNICO_id"),
            inverseJoinColumns = @JoinColumn(name = "TECNICO_id"))
    private List<Tecnico> lista = new ArrayList<Tecnico>();
    private boolean habilitado;
    private boolean emExecucao;

    public boolean isEmExecucao() {
        return emExecucao;
    }

    public void setEmExecucao(boolean emExecucao) {
        this.emExecucao = emExecucao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public List<Tecnico> getLista() {
        return lista;
    }

    public void setLista(List<Tecnico> lista) {
        this.lista = lista;
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

    public Calendar getDate() {
        return data;
    }

    public void setDate(Calendar data) {
        this.data = data;
    }

}
