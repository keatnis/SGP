package com.reports;

import com.DAO.ReportesDAO;
import com.connection.Conexion;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class reporte {

    //<property name="net.sf.jasperreports.awt.ignore.missing.font" value="true"/>
    public static void main(String[] args) throws IOException, JRException {

        JasperReport archivo = JasperCompileManager.compileReport("src/com/reports/evaluacion_jefe.jrxml");
        Map<String, Object> map = new HashMap<String, Object>();
 
Conexion con = new Conexion();
        ReportesDAO img = new ReportesDAO();
        ReportesDAO dao = new ReportesDAO();
        map.put("id", "31");
//
     map.put("clave", "15422");
//        map.put("foto", dao.Foto(15));
//        map.put("logo2", dao.Imagen(2));
        map.put("id_jefe", "5");

        JasperPrint prin = JasperFillManager.fillReport(archivo, map, con.getConnection());
        // JasperExportManager.exportReportToPdfFile(prin, "reporte.pdf");
        JasperViewer view = new JasperViewer(prin, false);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setVisible(true);
    }

}
