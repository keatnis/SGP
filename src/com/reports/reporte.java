
package com.reports;
import com.connection.Conectar;
import com.connection.Conexion;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class reporte{

    
    public static void main(String[] args) throws IOException, JRException {
         
        JasperReport archivo = JasperCompileManager.compileReport("src/com/reports/pase_salida.jrxml");
        Map<String,Object> map = new HashMap<String, Object>();
        Conectar con = new Conectar("jdbc:mysql://localhost/db_rh?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        map.put("NumEmp","001");
        JasperPrint prin = JasperFillManager.fillReport(archivo, map,con.getConnection());
        JasperExportManager.exportReportToPdfFile(prin,"reporte.pdf");
        JasperViewer view = new JasperViewer(prin, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
    }

}