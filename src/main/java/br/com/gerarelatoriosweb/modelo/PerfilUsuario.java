/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author byron
 */
@Entity
@Table(name="tbperfilusuario") 
    public class PerfilUsuario implements Serializable{
    private static final long serialVersionUID = 2806421523585360625L;
    @Id
    @GeneratedValue
    private int id;
    private boolean admin;
    private boolean habilitado;
    @NotEmpty
    @Column(unique = true)
    private String nome;
    @OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="tbperfilusuario_tbpagina",  
    joinColumns={@JoinColumn(name="tbperfilusuario_id", referencedColumnName="id")},  
    inverseJoinColumns={@JoinColumn(name="paginas_id", referencedColumnName="id")})  
    private List<Pagina> paginas; 
    @OneToMany
    private List<RelacionamentoPerfilPagina> lista;

    public List<RelacionamentoPerfilPagina> getLista() {
        return lista;
    }

    public void setLista(List<RelacionamentoPerfilPagina> lista) {
        this.lista = lista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public List<Pagina> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<Pagina> paginas) {
        this.paginas = paginas;
    }
    
    
}
