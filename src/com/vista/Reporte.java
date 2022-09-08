package com.vista;

import com.chart.ModelChartLine;
import com.component.ModelPieChart;
import com.component.PieChart;
import com.connection.Conexion;
import com.model.ModelReports;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Reporte extends javax.swing.JFrame {

    LocalDate now = LocalDate.now();
    int year = now.getYear();
    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    Connection conn = con.getConnection();

    public Reporte() {
        initComponents();
        init();
        init2();
        init3();
        mostrarCont();

    }

    void init() {
        String sql = "SELECT (select count(id_empleado) from tbl_empleado where genero='M' and status=1)as Mujer, (select count(id_empleado) from tbl_empleado where genero='H' and status=1)as Hombre;";
        //   ModelReports md = new ModelReports();
        try {

            psql = conn.prepareStatement(sql);
            int totalM;
            int totalH;
            rs = psql.executeQuery();
            if (rs.next()) {

                totalM = (rs.getInt("Mujer"));
                totalH = (rs.getInt("Hombre"));
                rs.close();
                pieChart1.setChartType(PieChart.PeiChartType.DONUT_CHART);
                pieChart1.addData(new ModelPieChart("Mujer", totalM, new Color(255, 204, 0)));
                pieChart1.addData(new ModelPieChart("Hombre", totalH, new Color(0, 102, 153)));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    void init2() {
        Conexion cc = new Conexion();
        Connection con = cc.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT (select count(id_empleado) from tbl_empleado where status=1 )as activo,sum( if(tipo_contratacion='Honorarios' and status=1,1,0))as honorarios,sum( if(tipo_contratacion='Nómina' and status=1,1,0))as nomina\n"
                    + "FROM tbl_empleo INNER JOIN tbl_empleado ON tbl_empleado.id_empleado=tbl_empleo.id_empleado;");
            ResultSet res = ps.executeQuery();
            res.next();
            int activo = (res.getInt("activo"));
            int totalH = (res.getInt("honorarios"));
            int totalN = (res.getInt("nomina"));
            res.close();
            pieChart2.setChartType(PieChart.PeiChartType.DONUT_CHART);
            //  lbTotal.setText("" + activo);
            pieChart2.addData(new ModelPieChart("Honorarios", totalH, new Color(40, 180, 99)));
            pieChart2.addData(new ModelPieChart("Nómina", totalN, new Color(133, 193, 233)));

            lbtitulo.setText("Total de Empleados Activos -  Año " + year);
            lbActivos.setText("" + activo);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    void init3() {
        Conexion cc = new Conexion();
        Connection con = cc.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT sum( if(categoria='Directivo' and status=1,1,0))as directivo,sum( if(categoria='Administrativo' and status=1,1,0))as administrativo,sum( if(categoria='Docente' and status=1,1,0))as docente,sum( if(categoria='Honorarios' and status=1,1,0)) as honorarios,sum( if(categoria='Servicios Generales' and status=1,1,0)) as servicios\n"
                    + "FROM tbl_empleo INNER JOIN tbl_empleado ON tbl_empleado.id_empleado=tbl_empleo.id_empleado;");
            ResultSet res = ps.executeQuery();
            res.next();
            int directivo = (res.getInt("directivo"));
            int administrativo = (res.getInt("administrativo"));
            int docente = (res.getInt("docente"));
            int honorarios = (res.getInt("honorarios"));
            int servicios = (res.getInt("servicios"));
            res.close();
            pieChart4.setChartType(PieChart.PeiChartType.DEFAULT);
            //  lbTotal.setText("" + activo);
            pieChart4.addData(new ModelPieChart("Directivos", directivo, new Color(52, 152, 219)));
            pieChart4.addData(new ModelPieChart("Administrativos", administrativo, new Color(142, 68, 173)));
            pieChart4.addData(new ModelPieChart("Docentes", docente, new Color(231, 76, 60)));
            pieChart4.addData(new ModelPieChart("Honorarios", honorarios, new Color(46, 204, 113)));
            pieChart4.addData(new ModelPieChart("Servicios Generales", servicios, new Color(241, 196, 15)));
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public ArrayList<ModelReports> listado() {
        ArrayList listaPersonal = new ArrayList();

        ModelReports personal;

        String SentenciaSQL = "select date_format(fecha_ingreso, '%M')as mes,count(id_empleo)as contrataciones\n"
                + "  from tbl_empleo where year(fecha_ingreso)=year(curdate())\n"
                + "  group by date_format(fecha_ingreso, '%M') order by fecha_ingreso;";

        try {
            psql = conn.prepareStatement(SentenciaSQL);
            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelReports();

                personal.setMes(rs.getString(1));
                personal.setContrataciones(rs.getInt(2));

                listaPersonal.add(personal);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
//        finally {
//            try {
//                if (con != null) {
//                    this.cerrar();
//                }
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
//                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
//            }
//        } 
        return listaPersonal;
    }

    private void mostrarCont() {

        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        ModelReports vo;
        int numReg = this.listado().size();
        //  ArrayList<ModelReports> list = this.listado();
        String mes;
        int cont;
        for (int i = 0; i < numReg; i++) {

            mes = this.listado().get(i).getMes();
            cont = this.listado().get(i).getContrataciones();

            switch (mes) {
                case "January":
                    datos.setValue(cont, "Contrataciones", "Enero");

                    break;
                case "February":
                    datos.setValue(cont, "Contrataciones", "Febrero");

                    break;
                case "March":
                    datos.setValue(cont, "Contrataciones", "Marzo");

                    break;
                case "April":
                    datos.setValue(cont, "Contrataciones", "Abril");

                    break;
                case "May":
                    datos.setValue(cont, "Contrataciones", "Mayo");

                    break;
                case "June":
                    datos.setValue(cont, "Contrataciones", "Junio");

                    break;
                case "July":
                    datos.setValue(cont, "Contrataciones", "Julio");

                    break;
                case "August":
                    datos.setValue(cont, "Contrataciones", "Agosto");

                    break;
                case "September":
                    datos.setValue(cont, "Contrataciones", "Septiembre");

                    break;
                case "October":
                    datos.setValue(cont, "Contrataciones", "Octubre");
                    break;
                case "November":
                    datos.setValue(cont, "Contrataciones", "Noviembre");
                    break;
                case "December":
                    datos.setValue(cont, "Contrataciones", "Diciembre");
                    break;
                default:
                    break;
            }

        }
        //se agregan los datos a la gráfica
        JFreeChart grafica = ChartFactory.createBarChart3D("Contrataciones del año - " + year, "Meses", "No. contraciones", datos,
                PlotOrientation.VERTICAL, true, true, false);
        grafica.getTitle().setFont(new Font("Poppins", 0, 14));
        grafica.getPlot().setBackgroundPaint(Color.LIGHT_GRAY);
        ChartPanel chartp = new ChartPanel(grafica);

        jPanel1.removeAll();
        jPanel1.add(chartp, BorderLayout.CENTER);
        jPanel1.revalidate();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbtitulo = new javax.swing.JLabel();
        lbActivos = new javax.swing.JLabel();
        graphics = new javax.swing.JPanel();
        pieChart1 = new com.component.PieChart();
        jPanel1 = new javax.swing.JPanel();
        pieChart4 = new com.component.PieChart();
        pieChart2 = new com.component.PieChart();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        title.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reporte gráfico");

        lbtitulo.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lbtitulo.setForeground(new java.awt.Color(102, 102, 102));
        lbtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtitulo.setText("<html><center>Total de Empleados Activos -  Año</center></html> ");

        lbActivos.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        lbActivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbActivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-green-circle-30.png"))); // NOI18N
        lbActivos.setIconTextGap(2);

        javax.swing.GroupLayout titleLayout = new javax.swing.GroupLayout(title);
        title.setLayout(titleLayout);
        titleLayout.setHorizontalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addContainerGap(239, Short.MAX_VALUE)
                .addGroup(titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(lbActivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        titleLayout.setVerticalGroup(
            titleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        graphics.setOpaque(false);
        graphics.setPreferredSize(new java.awt.Dimension(500, 500));
        graphics.setLayout(new java.awt.GridLayout(2, 2));

        pieChart1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total de Empleados por Género", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N
        graphics.add(pieChart1);

        jPanel1.setLayout(new java.awt.BorderLayout());
        graphics.add(jPanel1);

        pieChart4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empleados por Categoría", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N
        graphics.add(pieChart4);

        pieChart2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total de Empleados  por Tipo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N
        graphics.add(pieChart2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(graphics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(graphics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graphics;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbActivos;
    private javax.swing.JLabel lbtitulo;
    private com.component.PieChart pieChart1;
    private com.component.PieChart pieChart2;
    private com.component.PieChart pieChart4;
    private javax.swing.JPanel title;
    // End of variables declaration//GEN-END:variables
}
