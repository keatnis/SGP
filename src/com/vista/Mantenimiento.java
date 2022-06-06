package com.vista;

import com.DAO.JefeInmediatoDAO;
import com.component.GestionEncabezadoTabla;
import static java.awt.image.ImageObserver.ERROR;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class Mantenimiento extends javax.swing.JPanel {

    JefeInmediatoDAO dao = new JefeInmediatoDAO();

    public Mantenimiento() {
        initComponents();
        LlenarTabla(tablaJfeInmediato);
    }
    public void LlenarTabla(JTable tablaD) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaD.setModel(modeloTabla);
        JTableHeader jtableHeader = tablaD.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaD.setTableHeader(jtableHeader);
        tablaD.setRowHeight(20);
 
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre Jefe");
       

        TableColumnModel columnModel = tablaD.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(180);
        

        int numReg =dao.listJI().size();
        //numReg de solo UNA TABLA faltan las demas
        Object[] columna = new Object[22];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.listJI().get(i).getId();
            columna[1] = dao.listJI().get(i).getNombre();
            

            modeloTabla.addRow(columna);

//            int total = tablaD.getRowCount();
//            String totalLista = Integer.toString(total);
//          //  totalR.setText(totalLista);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pJefeInmediato = new javax.swing.JPanel();
        txtAbrev = new com.swing.JCTextField();
        txtNombre = new com.swing.JCTextField();
        txtApe1 = new com.swing.JCTextField();
        txtApe2 = new com.swing.JCTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJfeInmediato = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setForeground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        txtAbrev.setPlaceholder("abrev.");

        txtNombre.setPlaceholder("Nombre (s)");

        txtApe1.setPlaceholder("Apellido Paterno");

        txtApe2.setPlaceholder("Apellido Materno");

        tablaJfeInmediato.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tablaJfeInmediato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        tablaJfeInmediato.setPreferredSize(null);
        jScrollPane1.setViewportView(tablaJfeInmediato);

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/save_35px.png"))); // NOI18N
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setLabel("Guardar");
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGuardar);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/update_35px.png"))); // NOI18N
        jButton2.setText("Actualizar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/cancel_35px.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        javax.swing.GroupLayout pJefeInmediatoLayout = new javax.swing.GroupLayout(pJefeInmediato);
        pJefeInmediato.setLayout(pJefeInmediatoLayout);
        pJefeInmediatoLayout.setHorizontalGroup(
            pJefeInmediatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJefeInmediatoLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(pJefeInmediatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pJefeInmediatoLayout.createSequentialGroup()
                        .addComponent(txtAbrev, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtApe1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtApe2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(57, 57, 57)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        pJefeInmediatoLayout.setVerticalGroup(
            pJefeInmediatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pJefeInmediatoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pJefeInmediatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAbrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApe1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApe2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pJefeInmediatoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pJefeInmediatoLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pJefeInmediatoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(167, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Jefe Inmediato", pJefeInmediato);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Puesto", jLayeredPane1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Areas", jPanel2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Categoria", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Plaza", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sindicato", jPanel6);

        add(jTabbedPane1, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

        String clave = txtAbrev.getText();
        String nombre = txtNombre.getText();
        String aPaterno = txtApe1.getText();
        String aMaterno = txtApe2.getText();

        dao.GuardarJefes(clave, nombre, aPaterno, aMaterno);
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JOptionPane.showMessageDialog(null, "Guardar");
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel pJefeInmediato;
    private javax.swing.JTable tablaJfeInmediato;
    private com.swing.JCTextField txtAbrev;
    private com.swing.JCTextField txtApe1;
    private com.swing.JCTextField txtApe2;
    private com.swing.JCTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
