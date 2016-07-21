/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.servlet;

import br.com.gerarelatoriosweb.factory.RelatorioFactory;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

/**
 *
 * @author touti
 */
@WebServlet(name = "RelatorioServlet", urlPatterns = {"/contas"})
public class RelatorioServlet extends HttpServlet {

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
            JasperCompileManager.compileReportToFile("/WEB-INF/jasper/contasRelatorio.jrxml");
            String nome = request.getServletContext().getRealPath("/WEB-INF/jasper/contasRelatorio.jasper");
            
            Map<String, Object> parametros = new HashMap<String, Object>();

            //JRDataSource beanCollection = (JRDataSource) new ContaBeanFactory().createBeanCollection();
            
           // RelatorioFactory relatorioFactory = new RelatorioFactory(nome, parametros, beanCollection);
           // relatorioFactory.geraPDFParaOutputStream(response.getOutputStream());
            
        } catch (JRException ex) {
            Logger.getLogger(RelatorioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
