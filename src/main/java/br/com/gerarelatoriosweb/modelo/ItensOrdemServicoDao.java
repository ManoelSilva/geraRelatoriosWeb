/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author byron
 */
@RequestScoped
public class ItensOrdemServicoDao {

    GenericDao genericDao;
    Criterion criterion;
    Disjunction disjunction = Restrictions.disjunction();

    @Inject
    public ItensOrdemServicoDao(GenericDao dao) {
        genericDao = dao;
    }

    public ItensOrdemServicoDao() {
        this(null);
    }

    public  List<ItensOrdemServico> getLista(int id) {
        Session session = genericDao.getSessao();
        Criteria c = session.createCriteria(ItensOrdemServico.class);
        c.createAlias("ordens", "ordens");
        c.createAlias("statusItem", "statusItem");
        Criterion um = Restrictions.eq("statusItem.nome", "finalizado");
        Criterion dois = Restrictions.eq("statusItem.nome", "executado");
        Criterion tres = Restrictions.eq("statusItem.nome", "devolvido");
        Criterion quatro = Restrictions.eq("ordens.id", id);
        criterion = Restrictions.or(um, dois, tres);
        disjunction.add(criterion); //add your restirction herere
        disjunction.add(quatro); //add your restirction herere
        c.add(disjunction);
        List<ItensOrdemServico> lista = c.list();
          
          return lista;
        

    }
}
