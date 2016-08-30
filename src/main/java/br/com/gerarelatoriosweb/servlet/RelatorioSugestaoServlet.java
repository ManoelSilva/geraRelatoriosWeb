/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.servlet;

import br.com.gerarelatoriosweb.dao.RelatorioDAO;
import br.com.gerarelatoriosweb.factory.RelatorioFactory;
import br.com.gerarelatoriosweb.modelo.EstoqueUsuarioRelatorio;
import br.com.gerarelatoriosweb.modelo.ItensOrdemServicoRelatorio;
import br.com.gerarelatoriosweb.modelo.ServicoProdutoRelacionalRelatorio;
import br.com.gerarelatoriosweb.util.RelatorioUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author touti
 */
@WebServlet("/relatorioSugestao")
public class RelatorioSugestaoServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String TITLE = "RELATÓRIO DE ROTA E SUGESTÃO DE MATERIAL";
            String parameter1 = "Data da Rota";
            String parameter2 = "Técnico";
            String parameter3 = "Cod. Tec";
            String TITLE_1 = "ROTA";
            String HEADER_1 = "O.S";
            String HEADER_2 = "SERVIÇO";
            String TITLE_2 = "MATERIAL A RETIRAR";
            String HEADER_3 = "MATERIAL";
            String TITLE_3 = "RESUMO DE MATERIAL A RETIRAR";
            String HEADER_4 = "QUANTIDADE";
            String TITLE_4 = "ESTOQUE DO TÉCNICO";
            String HEADER_5 = "EQUIPAMENTO";
            String PAGE = "Página: ";
            String OF = " de ";
            String caminhoDoLogo = "/home/touti/NetBeansProjects/gera-relatorios-web/src/main/"
                    + "java/br/com/gerarelatoriosweb/images/images.jpg";

            Integer rotaId = Integer.parseInt(request.getParameter("idSky"));

            JasperCompileManager.compileReportToFile(request.getRealPath("/WEB-INF/jasper/relatorioSugestao.jrxml"));
            JasperCompileManager.compileReportToFile(request.getRealPath("/WEB-INF/jasper/relatorioSugestao_subreport1.jrxml"));
            JasperCompileManager.compileReportToFile(request.getRealPath("/WEB-INF/jasper/relatorioSugestao_subreport2.jrxml"));
            JasperCompileManager.compileReportToFile(request.getRealPath("/WEB-INF/jasper/relatorioSugestao_subreport3.jrxml"));
            JasperCompileManager.compileReportToFile(request.getRealPath("/WEB-INF/jasper/relatorioSugestao_subreport4.jrxml"));
            JasperCompileManager.compileReportToFile(request.getRealPath("/WEB-INF/jasper/relatorioSugestao_subreport5.jrxml"));

            String nome = request.getServletContext().getRealPath("/WEB-INF/jasper/relatorioSugestao.jasper");

            RelatorioDAO dao = new RelatorioDAO();

            RelatorioUtil relatorioUtil = new RelatorioUtil();

            List<ItensOrdemServicoRelatorio> osListaSub = dao.getDataSourceRota(rotaId);
            JRDataSource dataSourceSub = new JRBeanCollectionDataSource(osListaSub, false);

            List<ItensOrdemServicoRelatorio> osListaSub1 = dao.getListaOsDaRota(rotaId);
            JRDataSource dataSourceSub1 = new JRBeanCollectionDataSource(osListaSub1, false);

            List<ServicoProdutoRelacionalRelatorio> osListaSub2 = dao.getListaMaterialAretirar(rotaId);
            JRDataSource dataSourceSub2 = new JRBeanCollectionDataSource(osListaSub2, false);

            List<ServicoProdutoRelacionalRelatorio> osListaSub3 = dao.getListaResumoMaterialAretirar(rotaId);
            JRDataSource dataSourceSub3 = new JRBeanCollectionDataSource(osListaSub3, false);

            List<EstoqueUsuarioRelatorio> osListaSub4 = dao.getListaEstoqueDoTecnico(rotaId);
            JRDataSource dataSourceSub4 = new JRBeanCollectionDataSource(osListaSub4, false);

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("TITLE", TITLE);
            parametros.put("PAGE", PAGE);
            parametros.put("OF", OF);
            parametros.put("parameter_1", parameter1);
            parametros.put("parameter_2", parameter2);
            parametros.put("parameter_3", parameter3);
            parametros.put("TITLE_1", TITLE_1);
            parametros.put("HEADER_1", HEADER_1);
            parametros.put("HEADER_2", HEADER_2);
            parametros.put("TITLE_2", TITLE_2);
            parametros.put("TITLE_3", TITLE_3);
            parametros.put("HEADER_3", HEADER_3);
            parametros.put("HEADER_4", HEADER_4);
            parametros.put("TITLE_4", TITLE_4);
            parametros.put("HEADER_5", HEADER_5);
            parametros.put("LOGO", relatorioUtil.getInputStreamParametroLogo(caminhoDoLogo));
            parametros.put("subreport_datasource", dataSourceSub);
            parametros.put("subreport_datasource_2", dataSourceSub1);
            parametros.put("subreport_datasource_3", dataSourceSub2);
            parametros.put("subreport_datasource_4", dataSourceSub3);
            parametros.put("subreport_datasource_5", dataSourceSub4);

            JRDataSource dataSource = new JREmptyDataSource();

            RelatorioFactory factory = new RelatorioFactory(nome, parametros, dataSource);

            factory.geraPDFParaOutputStream(response.getOutputStream());

        } catch (JRException ex) {
            Logger.getLogger(RelatorioSugestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioSugestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioSugestaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
