/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.servlet;

import br.com.gerarelatoriosweb.dao.RelatorioDAO;
import br.com.gerarelatoriosweb.factory.RelatorioFactory;
import br.com.gerarelatoriosweb.util.RelatorioUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author touti
 */
@WebServlet("/relatorioMulta")
public class RelatorioMultaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String dataIni = request.getParameter("data_ini");
            String dataFim = request.getParameter("data_fim");
            String TITLE = "RELATÓRIO DE MULTAS";
            String HEADER_1 = "FUNCIONÁRIO";
            String HEADER_2 = "DATA";
            String HEADER_3 = "VALOR";
            String GROUPFOOTER_MSG = "SOMA DAS MULTAS POR FUNCIONÁRIO";
            String SUMMARY_MSG = "SOMA TOTAL DAS MULTAS DO PERÍODO \n" + dataIni + " À " + dataFim;
            String PAGE = "Página: ";
            String OF = " de ";
            String caminhoDoLogo = "/home/touti/NetBeansProjects/gera-relatorios-web/src/main/"
                    + "java/br/com/gerarelatoriosweb/images/images.jpg";

            JasperCompileManager.compileReportToFile(request.getRealPath("/WEB-INF/jasper/relatorioMultas.jrxml"));

            String nome = request.getServletContext().getRealPath("/WEB-INF/jasper/relatorioMultas.jasper");

            RelatorioDAO dao = new RelatorioDAO();

            RelatorioUtil relatorioUtil = new RelatorioUtil();

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("TITLE", TITLE);
            parametros.put("PAGE", PAGE);
            parametros.put("OF", OF);
            parametros.put("HEADER_1", HEADER_1);
            parametros.put("HEADER_2", HEADER_2);
            parametros.put("HEADER_3", HEADER_3);
            parametros.put("GROUPFOOTER_MSG", GROUPFOOTER_MSG);
            parametros.put("SUMMARY_MSG", SUMMARY_MSG);
            parametros.put("LOGO", relatorioUtil.getInputStreamParametroLogo(caminhoDoLogo));

            JRDataSource dataSource = new JRBeanCollectionDataSource(dao.getListaMultas(dataIni, dataFim), false);

            RelatorioFactory factory = new RelatorioFactory(nome, parametros, dataSource);

            factory.geraPDFParaOutputStream(response.getOutputStream());

        } catch (JRException ex) {
            Logger.getLogger(RelatorioSugestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioSugestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
