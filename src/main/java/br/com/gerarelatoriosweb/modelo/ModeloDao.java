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
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

/**
 *
 * @author byron
 */
@RequestScoped
public class ModeloDao {

    GenericDao genericDao;

    @Inject
    public ModeloDao(GenericDao dao) {
        genericDao = dao;
    }

    public ModeloDao() {
        this(null);
    }

    public List<Equipamento> getLista() {
        Disjunction disjunction = Restrictions.disjunction();
        Criterion criterion;
        ProjectionList proList = Projections.projectionList();
        proList.add(Projections.property("id"), "id");
        proList.add(Projections.property("receptor"), "receptor");
        Criteria c = genericDao.getSessao().createCriteria(Equipamento.class);
        proList.add(Projections.groupProperty("receptor"), "receptor");
        //ReMapeando a classe
        c.setProjection(proList)
                .setResultTransformer(Transformers.aliasToBean(Equipamento.class));

        List<Equipamento> lista = c.list();

        return lista;
    }

}
