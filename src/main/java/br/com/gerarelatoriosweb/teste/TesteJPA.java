/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.teste;

import br.com.gerarelatoriosweb.modelo.Conta;
import br.com.gerarelatoriosweb.util.JPAutil;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;



/**
 *
 * @author touti
 */
public class TesteJPA {
    
    public static void main(String[] args) {
        EntityManager manager = new JPAutil().getEntityManager();
        
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        
        CriteriaQuery<Conta> query = criteriaBuilder.createQuery(Conta.class);
        
        query.from(Conta.class);
        
        TypedQuery<Conta> typedQuery = manager.createQuery(query);
        
        Collection<Conta> contas = typedQuery.getResultList();
        
        for(Conta m: contas){
            System.out.println("Titular:" + m.getTitular());
        }
    }   
}
