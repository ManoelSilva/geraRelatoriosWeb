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
public class ServicoProdutoRelacionalRelatorio {

    private ServicoProdutoRelacional relacional;
    
    private OS os;

    public ServicoProdutoRelacionalRelatorio(ServicoProdutoRelacional relacional) {
        this.relacional = relacional;
    }

    public int getOs() {
        return os.getId();
    }

    public void setOs(OS os) {
        this.os = os;
    }
    
    public String getProduto() {
        return relacional.getProduto().getNome();
    }

    public BigDecimal getQuantidade() {
        return relacional.getQuantidade();
    }
}
