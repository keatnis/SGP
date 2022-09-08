
package com.vista;

import com.DAO.ListadoDAO;
import com.component.FixedColumnExample;
import com.component.PlantillaFiltros;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Listado extends javax.swing.JPanel {

    ListadoDAO dao = new ListadoDAO();

    public Listado() {
        initComponents();
        llenarTabla(table_data);
    }

    private void llenarTabla(JTable tabla) {
        DefaultTableModel modeloTabla;
        Object[][] data;
        int numReg = dao.listPersonalCompleto().size();

        Object[] column;
        column = new Object[]{"No. Emp", "Nombre (s)", "A. Patermo", "A. Materno", "Status", "Sexo", "Fecha Nacimiento", "Teléfono", "Correo Personal", "Correo Institucional", "CURP", "RFC", "IMSS", "Estado Civil", "Lengua Indígena", "Dirección",
            "Contacto de emergencia", "Tipo de Sangre", "Plantel", " N/H", "Código", "Fecha de Ingreso", "Fecha Termino Contrato", "Jefe Inmediato ", "Puesto", "Adscripción", "Categoría", "Horas Laborales", "Tipo Plaza", "Sindicato", "Horario ", "Monto Mensual", "Nivel de Estudio", "Carrera", "Institución", "Estado", "Año Egreso", "Título", "Posgrado", "Maestría", "Doctorado"};

        data = new Object[numReg][41];

        for (int i = 0; i < numReg; i++) {
            data[i][0] = dao.listPersonalCompleto().get(i).getNumEmpleado();
            data[i][1] = dao.listPersonalCompleto().get(i).getNombres();
            data[i][2] = dao.listPersonalCompleto().get(i).getApellidoP();
            data[i][3] = dao.listPersonalCompleto().get(i).getApellidoM();
            data[i][4] = dao.listPersonalCompleto().get(i).getStatus();
            data[i][5] = dao.listPersonalCompleto().get(i).getSexo();
            data[i][6] = dao.listPersonalCompleto().get(i).getFechaNacimiento();
            data[i][7] = dao.listPersonalCompleto().get(i).getTelefono();
            data[i][8] = dao.listPersonalCompleto().get(i).getCorreoPersonal();
            data[i][9] = dao.listPersonalCompleto().get(i).getCorreoInst();
            data[i][10] = dao.listPersonalCompleto().get(i).getCURP();
            data[i][11] = dao.listPersonalCompleto().get(i).getRFC();
            data[i][12] = dao.listPersonalCompleto().get(i).getIMSS();
            data[i][13] = dao.listPersonalCompleto().get(i).getEstadoCivil();
            data[i][14] = dao.listPersonalCompleto().get(i).getLenguaIndigena();
            data[i][15] = dao.listPersonalCompleto().get(i).getDirección();
            data[i][16] = dao.listPersonalCompleto().get(i).getTelefonoCE();
            data[i][17] = dao.listPersonalCompleto().get(i).getTipoSangre();
            data[i][18] = dao.listPersonalCompleto().get(i).getPlantel();
            data[i][19] = dao.listPersonalCompleto().get(i).getTipoContratacion();
            data[i][20] = dao.listPersonalCompleto().get(i).getCodigo();
            data[i][21] = dao.listPersonalCompleto().get(i).getFechaIngreso();
            data[i][22] = dao.listPersonalCompleto().get(i).getFechaTerminoCont();
            data[i][23] = dao.listPersonalCompleto().get(i).getJefeInmediato();
            data[i][24] = dao.listPersonalCompleto().get(i).getPuesto();
            data[i][25] = dao.listPersonalCompleto().get(i).getAreaAdscripción();
            data[i][26] = dao.listPersonalCompleto().get(i).getCategoria();
            data[i][27] = dao.listPersonalCompleto().get(i).getHorasLaborales();
            data[i][28] = dao.listPersonalCompleto().get(i).getTipoPlaza();
            data[i][29] = dao.listPersonalCompleto().get(i).getSindicato();
            data[i][30] = dao.listPersonalCompleto().get(i).getHorarioTrabajo();
            data[i][31] = dao.listPersonalCompleto().get(i).getSueldo();
            data[i][32] = dao.listPersonalCompleto().get(i).getNivelEstudios();
            data[i][33] = dao.listPersonalCompleto().get(i).getCarreraProfesional();
            data[i][34] = dao.listPersonalCompleto().get(i).getNombreInst();
            data[i][35] = dao.listPersonalCompleto().get(i).getEstado();
            data[i][36] = dao.listPersonalCompleto().get(i).getAnio_egreso();
            data[i][37] = dao.listPersonalCompleto().get(i).getConTitulo();
            data[i][38] = dao.listPersonalCompleto().get(i).getConPosgrado();
            data[i][39] = dao.listPersonalCompleto().get(i).getConMaestria();
            data[i][40] = dao.listPersonalCompleto().get(i).getConDoctorado();
        }

        modeloTabla = new DefaultTableModel(data, column){
           @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setModel(modeloTabla);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabla.doLayout();

        int[] anchos = {55, 150, 100, 100, 50, 50, 100, 150, 150, 150, 160, 100, 100, 80, 80, 150, 100, 80, 80, 80, 80, 100, 100, 200, 100, 100, 80, 80, 80, 80, 100, 100, 80, 80, 80, 80, 80, 80, 80, 80, 80};
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            //    table_data.set
            tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new com.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        btnExportar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_data = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setOpaque(false);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setPlaceholder("Buscar ...");
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 238, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, 54));

        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/pdf30.png"))); // NOI18N
        btnExportar.setText("Exportar tabla");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/microsoft_excel_2019_30px.png"))); // NOI18N
        jButton1.setText("Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        table_data.setAutoCreateRowSorter(true);
        table_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(table_data);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/filter.png"))); // NOI18N
        jButton2.setText("Filtro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(455, Short.MAX_VALUE)
                .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(456, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportar)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed


    }//GEN-LAST:event_btnExportarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FixedColumnExample tb = new FixedColumnExample();
        tb.exportarExcel();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        DefaultTableModel modelt = (DefaultTableModel) table_data.getModel();
        String query = txtBuscar.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(modelt);
        table_data.setRowSorter(tr);
        if (query != "") {
            tr.setRowFilter(RowFilter.regexFilter("(?i)" + query));
            //rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        } else {
            table_data.setRowSorter(tr);
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PlantillaFiltros dialog = new PlantillaFiltros(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    dialog.setVisible(false);
                }
            });
            dialog.setVisible(true); 
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_data;
    private com.swing.JCTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
