/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author touti
 */
public class MultaRelatorio {

    private Multa multa;

    public MultaRelatorio(Multa multa) {
        this.multa = multa;
    }

    public String getNome() {
        return this.multa.getVistoria().getOs().getTecnico().getFuncionario().getNome();
    }

    public Date getData() {
        return this.multa.getVistoria().getData().getTime();
    }

    public BigDecimal getValor() {
        return this.multa.getErro().getValor();
    }
}
