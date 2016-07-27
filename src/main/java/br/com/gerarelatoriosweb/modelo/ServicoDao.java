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
public class ServicoDao {

    GenericDao genericDao;

    @Inject
    public ServicoDao(GenericDao dao) {
        genericDao = dao;
    }

    public ServicoDao() {
        this(null);
    }

    public void updatePermissao(Servicos servico) {
        Session session = genericDao.getSessao();
        Servicos temp = new Servicos();
        temp = (Servicos) session.get(servico.getClass(), servico.getId());
        temp.setRemuneracaoTecnico(servico.getRemuneracaoTecnico());
        temp.setRemuneracaoSky(servico.getRemuneracaoSky());
        
        


    }
}
