/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author byron
 */
@Entity
@Table(name = "tbequipamento")
public class Equipamento {

    @Id 
    @GeneratedValue
    private Integer id;
    private String ponto;
    private String cartaoAcesso;
    private String receptor;
    @OneToOne
    private EstoqueSerial serial;
    private String propriedadeEquipamento;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private boolean habilitado;

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPonto() {
        return ponto;
    }

    public void setPonto(String ponto) {
        this.ponto = ponto;
    }

    public String getCartaoAcesso() {
        return cartaoAcesso;
    }

    public void setCartaoAcesso(String cartaoAcesso) {
        this.cartaoAcesso = cartaoAcesso;
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public EstoqueSerial getSerial() {
        return serial;
    }

    public void setSerial(EstoqueSerial serial) {
        this.serial = serial;
    }

    public String getPropriedadeEquipamento() {
        return propriedadeEquipamento;
    }

    public void setPropriedadeEquipamento(String propriedadeEquipamento) {
        this.propriedadeEquipamento = propriedadeEquipamento;
    }

}
