/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.dao;

import br.com.gerarelatoriosweb.factory.ConnectionFactory;
import br.com.gerarelatoriosweb.modelo.OS;
import br.com.gerarelatoriosweb.modelo.Status;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author touti
 */
public class ProjetoDAO {

    private Connection conexao;

    public ProjetoDAO() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public List<OS> getListaOS() {
        try {
            PreparedStatement stmt = this.conexao
                    .prepareStatement("select dataAgendamento, dataCriacao, "
                            + "dataDirecionamento, dataExecucao, dataFinalizacao, "
                            + "dataLiberacao, nome from tbos inner join tbstatus where "
                            + "tbos.status_id = tbstatus.id;");

            List<OS> osList = new ArrayList<OS>();
            OS os = null;
            Status status = null;
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Calendar dataAgendamento = Calendar.getInstance();
                dataAgendamento.setTime(rs.getDate("dataAgendamento"));
                
                Calendar dataCriacao = Calendar.getInstance();
                dataCriacao.setTime(rs.getDate("dataCriacao"));
                
                Calendar dataDirecionamento = Calendar.getInstance();
                dataDirecionamento.setTime(rs.getDate("dataDirecionamento"));
                
                Calendar dataExecucao = Calendar.getInstance();
                dataExecucao.setTime(rs.getDate("dataExecucao"));
                
                Calendar dataFinalizacao = Calendar.getInstance();
                dataFinalizacao.setTime(rs.getDate("dataFinalizacao"));
                
                Calendar dataLiberacao = Calendar.getInstance();
                dataLiberacao.setTime(rs.getDate("dataLiberacao"));
                
                String statusNome = rs.getString("nome");

                os = new OS();
                status = new Status();

                os.setDataAgendamento(dataAgendamento);
                os.setDataCriacao(dataCriacao);
                os.setDataDirecionamento(dataDirecionamento);
                os.setDataExecucao(dataExecucao);
                os.setDataFinalizacao(dataFinalizacao);
                os.setDataLiberacao(dataLiberacao);
                status.setNome(statusNome);
                os.setStatus(status);
                

                osList.add(os);
            }

            rs.close();
            stmt.close();
            return osList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
