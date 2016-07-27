/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author byron
 */
@RequestScoped
public class LoginDao {
  private Session session;
  
   protected LoginDao() {
        this(null);
    }

    @Inject
    public LoginDao(Session session) {
        this.session = session;
    }

    public Usuario login(Usuario user) {
        Criteria crit = session.createCriteria(Usuario.class);
        crit.createAlias("funcionario", "a");
        crit.add(Restrictions.eq("a.email", user.getFuncionario().getEmail()));
        crit.add(Restrictions.eq("a.senha", user.getFuncionario().getSenha()));
        Usuario retorno= (Usuario) crit.uniqueResult();
        crit = session.createCriteria(RelacionamentoPerfilPagina.class);
        crit.add(Restrictions.eq("perfil.id", retorno.getPerfilUsuario().getId()));
        retorno.getPerfilUsuario().setLista(crit.list());
        return retorno;

    }
 

}
