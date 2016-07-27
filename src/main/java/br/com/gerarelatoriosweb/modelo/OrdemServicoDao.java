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
public class OrdemServicoDao {
    
    GenericDao genericDao;
    
    @Inject
    public OrdemServicoDao(GenericDao dao) {
        genericDao = dao;
    }
    
    public OrdemServicoDao() {
        this(null);
    }
    
    public void updateStatus(OS os) {
        Session session = genericDao.getSessao();
        OS temp = new OS();
        temp = (OS) session.get(os.getClass(), os.getId());
        temp.setStatus(os.getStatus());
        temp.setStatusAgendamento(os.getStatusAgendamento());
        
    }
}
