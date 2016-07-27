/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.util.Calendar;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author byron
 */
@RequestScoped
public class FrequenciaTecnicoDao {

    GenericDao genericDao;
    Criterion criterion;
    Disjunction disjunction = Restrictions.disjunction();

    @Inject
    public FrequenciaTecnicoDao(GenericDao dao) {
        genericDao = dao;
    }

    public FrequenciaTecnicoDao() {
        this(null);
    }

    public List<Tecnico> getLista() {
        Calendar calDois = Calendar.getInstance();
        calDois.add(Calendar.DATE, 1);
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.HOUR, 0);
        calendario.set(Calendar.MINUTE, 0);
        calendario.set(Calendar.SECOND, 0);
        calendario.set(Calendar.HOUR_OF_DAY, 0);
        calDois.set(Calendar.HOUR, 0);
        calDois.set(Calendar.MINUTE, 0);
        calDois.set(Calendar.SECOND, 0);
        calDois.set(Calendar.HOUR_OF_DAY, 0);
        Criterion criterion = Restrictions.between("listaFrequencia.data", calendario, calDois);
        Criterion habilitado = Restrictions.eq("habilitado", true);
        LogicalExpression expression = Restrictions.and(habilitado, criterion);
        List<Tecnico> retorno = genericDao.getSessao().createCriteria(Tecnico.class).createAlias("listaFrequencia", "listaFrequencia").add(expression).list();

        return retorno;

    }
    
     public List<Tecnico> getListaTecnico() {
        Criterion criterion = Restrictions.isNotNull("funcionario.id");
        Criterion habilitado = Restrictions.eq("habilitado", true);
        LogicalExpression expression = Restrictions.and(habilitado, criterion);
        List<Tecnico> retorno = genericDao.getSessao().createCriteria(Tecnico.class).createAlias("funcionario", "funcionario").add(expression).list();

        return retorno;

    }
}
