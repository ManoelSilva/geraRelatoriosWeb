/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.dao;

import br.com.gerarelatoriosweb.modelo.Conta;
import br.com.gerarelatoriosweb.util.JPAutil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author touti
 */
public class ContaDAO {
    private EntityManager manager = new JPAutil().getEntityManager();
    
    public List<Conta> getListFromConta(){
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        
        CriteriaQuery<Conta> query = criteriaBuilder.createQuery(Conta.class);
        
        query.from(Conta.class);
        
        TypedQuery<Conta> typedQuery = manager.createQuery(query);
        
        List<Conta> contas = typedQuery.getResultList();
        
        return contas;
    }
}
