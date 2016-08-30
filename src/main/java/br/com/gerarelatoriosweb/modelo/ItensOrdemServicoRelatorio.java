/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author touti
 */
public class ItensOrdemServicoRelatorio {

    private ItensOrdemServico itensOS;

    public ItensOrdemServicoRelatorio(ItensOrdemServico itensOS) {
        this.itensOS = itensOS;
    }

    public Integer getIdRota() {
        return itensOS.getRota().getId();
    }

    public Integer getId() {
        return itensOS.getOrdens().getId();
    }

    public String getNome() {
        return itensOS.getServico().getNome();
    }

    public List<Produto> getProduto() {
        List<Produto> listaProdutos = itensOS.getServico().getProdutos();
        return listaProdutos;
    }

    public Date getDataRota() {
        Date data = itensOS.getRota().getData().getTime();
        if (data == null) {
            return new Date(System.currentTimeMillis());
        } else {
            return data;
        }
    }

    public String getNomeTecnico() {
        return itensOS.getTecnico().getFuncionario().getNome();
    }

    public String getIdSky() {
        return itensOS.getTecnico().getIdSky();
    }
}
