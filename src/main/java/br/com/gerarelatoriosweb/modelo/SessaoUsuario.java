/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import br.com.gerarelatoriosweb.modelo.Usuario;
//import static br.com.caelum.vraptor.view.Results.logic;
//import br.com.x2tec.controllers.IndexController;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author byron
 */

@SessionScoped
public class SessaoUsuario implements Serializable{
    
    private String titulo;
    private Usuario usuario;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void logout(){
          this.usuario=null;
      
    }
    
    
}
