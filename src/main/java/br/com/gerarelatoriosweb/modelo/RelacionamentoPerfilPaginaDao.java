/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Session;

/**
 *
 * @author byron
 */
@RequestScoped
public class RelacionamentoPerfilPaginaDao {

    GenericDao genericDao;

    @Inject
    public RelacionamentoPerfilPaginaDao(GenericDao dao) {
        genericDao = dao;
    }

    public RelacionamentoPerfilPaginaDao() {
        this(null);
    }

    public void updatePermissao(RelacionamentoPerfilPagina relacionamento) {
        Session session = genericDao.getSessao();
        RelacionamentoPerfilPagina relacionamentoPerfilPagina = (RelacionamentoPerfilPagina) session.get(relacionamento.getClass(), relacionamento.getId());
        relacionamentoPerfilPagina.setPermissao(relacionamento.getPermissao());

    }
}
