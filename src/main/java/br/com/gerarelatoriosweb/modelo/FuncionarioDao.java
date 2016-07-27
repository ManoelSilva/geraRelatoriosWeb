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
public class FuncionarioDao {

    private Session session;

    protected FuncionarioDao() {
    }

    @Inject
    public FuncionarioDao(Session session) {
        this.session = session;
    }

    public void salvarUsuario(Funcionario user) {

        if (user.getId() > 0) {
            Funcionario usuario = (Funcionario) session.get(Funcionario.class, user.getId());
            usuario.setBairro(user.getBairro());
            usuario.setHabilitado(true);
            usuario.setCep(user.getCep());
            usuario.setComplemento(user.getComplemento());
            usuario.setCpf(user.getCpf());
            usuario.setCpts(user.getCpts());
            usuario.setDataAdimissao(user.getDataAdimissao());
            usuario.setDataNascimento(user.getDataNascimento());
            usuario.setEmail(user.getEmail());
            usuario.setEstadoCivil(user.getEstadoCivil());
            usuario.setGalpao(user.getGalpao());
            usuario.setNome(user.getNome());
            usuario.setObs(user.getObs());
            usuario.setRg(user.getRg());
            usuario.setSexo(user.getSexo());
            usuario.setTelefone(user.getTelefone());
            usuario.setTelefoneDois(user.getTelefoneDois());
            usuario.setGalpao(user.getGalpao());

        } else {
           user.setHabilitado(true);
           session.save(user);

        }

    }

}



    


