/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.math.BigDecimal;

/**
 *
 * @author touti
 */
public class EstoqueUsuarioRelatorio {
    EstoqueUsuario estoqueUsuario;
    
    public EstoqueUsuarioRelatorio(EstoqueUsuario estoqueUsuario){
        this.estoqueUsuario = estoqueUsuario;
    }
    
    public String getProduto(){
        return this.estoqueUsuario.getProduto().getNome();
    }
    
    public String getNome(){
        return this.estoqueUsuario.getTecnico().getFuncionario().getNome();
    }
    
    public BigDecimal getQuantidade(){
        return this.estoqueUsuario.getEstoque();
    }
}
