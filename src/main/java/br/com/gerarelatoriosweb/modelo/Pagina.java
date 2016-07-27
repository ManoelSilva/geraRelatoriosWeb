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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author byron
 */
@Table(name="tbpagina") 
@Entity
public class Pagina implements Serializable{
    private static final long serialVersionUID = 2806421523585360625L;
    @Id
    @GeneratedValue
    private int id;
    private int menupai;
    private String nome;
    private String icon;
    private String link;
    @OneToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="tbperfilusuario_tbpagina",  
    joinColumns={@JoinColumn(name="paginas_id", referencedColumnName="id")},  
    inverseJoinColumns={@JoinColumn(name="tbperfilusuario_id", referencedColumnName="id")})  
    private List<PerfilUsuario> perfil;

    public int getMenupai() {
        return menupai;
    }

    public void setMenupai(int menupai) {
        this.menupai = menupai;
    }
    
    

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
