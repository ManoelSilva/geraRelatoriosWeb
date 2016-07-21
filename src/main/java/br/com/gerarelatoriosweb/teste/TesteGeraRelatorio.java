/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gerarelatoriosweb.teste;

import br.com.gerarelatoriosweb.dao.ContaDAO;
import br.com.gerarelatoriosweb.modelo.Conta;
import br.com.gerarelatoriosweb.util.JPAutil;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 *
 * @author touti
 */
public class TesteGeraRelatorio {

    public static void main(String[] args) throws SQLException, JRException, ClassNotFoundException, FileNotFoundException {
        EntityManager manager = new JPAutil().getEntityManager();

        ContaDAO dao = new ContaDAO();

        JasperCompileManager.compileReportToFile("/home/touti/NetBeansProjects/gera-relatorios-web/src/main/java/br/com/gerarelatoriosweb/jasper/contas.jrxml");

        Map<String, Object> params = new HashMap();

        List<Conta> listaContas = new ContaDAO().getListFromConta();

        JRDataSource dataSource = new JRBeanCollectionDataSource(listaContas, false);

        JasperPrint jasperPrint = JasperFillManager.fillReport("/home/touti/NetBeansProjects/gera-relatorios-web/src/main/java/br/com/gerarelatoriosweb/jasper/contas.jasper", params, dataSource);

        JRExporter exporter = new JRPdfExporter();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream("contas.pdf"));

        exporter.exportReport();

        System.out.println("PDF gerado com sucesso!");
    }
}
