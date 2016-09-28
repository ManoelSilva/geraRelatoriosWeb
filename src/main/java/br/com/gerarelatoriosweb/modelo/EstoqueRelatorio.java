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
public class EstoqueRelatorio {

    private Estoque estoque;

    public EstoqueRelatorio(Estoque estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return this.estoque.getProduto().getNome();
    }

    public BigDecimal getEstoque() {
        return this.estoque.getEstoque();
    }
}
