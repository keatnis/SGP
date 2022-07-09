package com.vista;

import com.DAO.MantenimientoDAO;
import com.component.GestionEncabezadoTabla;
import com.model.MantenimientoModel;
import static java.awt.image.ImageObserver.ERROR;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public final class Mantenimiento extends javax.swing.JPanel {

    MantenimientoDAO dao = new MantenimientoDAO();
MantenimientoModel model =new MantenimientoModel();
    public Mantenimiento() {
        initComponents();
        bloquearTextfiel();
        LlenarTabla(tablaJfeInmediato);
        LlenarTabla_Puestos(tablapuestos);
        LlenarTabla_Areas(tb_areas);
    }
    public void bloquearTextfiel(){
        txtPuesto.setEnabled(false);
        txtArea.setEnabled(false);
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

        int numReg = dao.listJI().size();
        //numReg de solo UNA TABLA faltan las demas
        Object[] columna = new Object[2];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.listJI().get(i).getId();
            columna[1] = dao.listJI().get(i).getNombre();

            modeloTabla.addRow(columna);

        }

    }
     public void LlenarTabla_Puestos(JTable tablaD) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaD.setModel(modeloTabla);
        JTableHeader jtableHeader = tablaD.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaD.setTableHeader(jtableHeader);
        tablaD.setRowHeight(20);

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre Puesto");

        TableColumnModel columnModel = tablaD.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(180);

        int numReg = dao.listPuestos().size();
        //numReg de solo UNA TABLA faltan las demas
        Object[] columna = new Object[2];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.listPuestos().get(i).getId();
            columna[1] = dao.listPuestos().get(i).getNombre();

            modeloTabla.addRow(columna);

        }
     }
     public void LlenarTabla_Areas(JTable tablaD) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaD.setModel(modeloTabla);
        JTableHeader jtableHeader = tablaD.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaD.setTableHeader(jtableHeader);
        tablaD.setRowHeight(20);

        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre Área");

        TableColumnModel columnModel = tablaD.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(180);

        int numReg = dao.listAreas().size();
        //numReg de solo UNA TABLA faltan las demas
        Object[] columna = new Object[2];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.listAreas().get(i).getId();
            columna[1] = dao.listAreas().get(i).getNombre();

            modeloTabla.addRow(columna);

        }

    }
    private void editar(JTable tabla,JTextField txt){
        int filaEditar = tabla.getSelectedRow();
        int numFS = tabla.getSelectedRowCount();
        if (filaEditar >= 0 && numFS == 1) {
          
         String id=String.valueOf(tabla.getValueAt(filaEditar, 0));
         model.setId(Integer.parseInt(id));
 
         txt.setEnabled(true);
        txt.setText(String.valueOf(tabla.getValueAt(filaEditar, 1)));
        }
    }
   
    public void LimpiarCJI(){
        txtAbrev.setText("");
        txtNombre.setText("");
        txtApe1.setText("");
        txtApe2.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Editar = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        editarPuestos = new javax.swing.JPopupMenu();
        editarp = new javax.swing.JMenuItem();
        editarArea = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pJefeInmediato = new javax.swing.JPanel();
        txtAbrev = new com.swing.JCTextField();
        txtNombre = new com.swing.JCTextField();
        txtApe1 = new com.swing.JCTextField();
        txtApe2 = new com.swing.JCTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaJfeInmediato = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        txtPuesto = new com.swing.JCTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablapuestos = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        jButton6 = new javax.swing.JButton();
        btnGuardarPuesto = new javax.swing.JButton();
        btnActualizarpuesto = new javax.swing.JButton();
        btnEliminarPuesto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtArea = new com.swing.JCTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_areas = new javax.swing.JTable();
        jToolBar3 = new javax.swing.JToolBar();
        tbnNuevoArea = new javax.swing.JButton();
        btnGuardarArea = new javax.swing.JButton();
        btnActualizarArea = new javax.swing.JButton();
        btnEliminarArea = new javax.swing.JButton();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/edit.png"))); // NOI18N
        jMenuItem1.setText("Editar");
        jMenuItem1.setToolTipText("");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Editar.add(jMenuItem1);
        jMenuItem1.getAccessibleContext().setAccessibleName("EditarDatos");

        editarp.setText("Editar");
        editarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarpActionPerformed(evt);
            }
        });
        editarPuestos.add(editarp);

        jMenuItem2.setText("Editar Area");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        editarArea.add(jMenuItem2);

        setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setForeground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        pJefeInmediato.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAbrev.setPlaceholder("abrev.");
        pJefeInmediato.add(txtAbrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 130, -1));

        txtNombre.setPlaceholder("Nombre (s)");
        pJefeInmediato.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 134, -1));

        txtApe1.setPlaceholder("Apellido Paterno");
        pJefeInmediato.add(txtApe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 134, -1));

        txtApe2.setPlaceholder("Apellido Materno");
        pJefeInmediato.add(txtApe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 134, -1));

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
        tablaJfeInmediato.setComponentPopupMenu(Editar);
        tablaJfeInmediato.setPreferredSize(null);
        jScrollPane1.setViewportView(tablaJfeInmediato);

        pJefeInmediato.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 558, 255));

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/add_25px.png"))); // NOI18N
        jButton1.setText("Nuevo");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

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
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
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

        pJefeInmediato.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 111, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setText("Abrev.");
        pJefeInmediato.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Nombre (s):");
        pJefeInmediato.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("A. Paterno:");
        pJefeInmediato.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("A. Materno:");
        pJefeInmediato.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jTabbedPane1.addTab("Jefe Inmediato", pJefeInmediato);

        txtPuesto.setPlaceholder("Nombre del puesto");

        tablapuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Puesto", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablapuestos.setComponentPopupMenu(editarPuestos);
        jScrollPane2.setViewportView(tablapuestos);
        if (tablapuestos.getColumnModel().getColumnCount() > 0) {
            tablapuestos.getColumnModel().getColumn(0).setMinWidth(80);
            tablapuestos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tablapuestos.getColumnModel().getColumn(1).setMinWidth(150);
            tablapuestos.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jToolBar2.setRollover(true);

        jButton6.setText("Nuevo");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton6);

        btnGuardarPuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/save_35px.png"))); // NOI18N
        btnGuardarPuesto.setFocusable(false);
        btnGuardarPuesto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarPuesto.setLabel("Guardar");
        btnGuardarPuesto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPuestoActionPerformed(evt);
            }
        });
        jToolBar2.add(btnGuardarPuesto);

        btnActualizarpuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/update_35px.png"))); // NOI18N
        btnActualizarpuesto.setText("Actualizar");
        btnActualizarpuesto.setFocusable(false);
        btnActualizarpuesto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarpuesto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizarpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarpuestoActionPerformed(evt);
            }
        });
        jToolBar2.add(btnActualizarpuesto);

        btnEliminarPuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/cancel_35px.png"))); // NOI18N
        btnEliminarPuesto.setText("Eliminar");
        btnEliminarPuesto.setFocusable(false);
        btnEliminarPuesto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarPuesto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPuestoActionPerformed(evt);
            }
        });
        jToolBar2.add(btnEliminarPuesto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(289, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Puesto", jLayeredPane1);

        txtArea.setPlaceholder("Nombre del Área");

        tb_areas.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_areas.setComponentPopupMenu(editarArea);
        jScrollPane3.setViewportView(tb_areas);

        jToolBar3.setRollover(true);

        tbnNuevoArea.setText("Nuevo");
        tbnNuevoArea.setFocusable(false);
        tbnNuevoArea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbnNuevoArea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbnNuevoArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnNuevoAreaActionPerformed(evt);
            }
        });
        jToolBar3.add(tbnNuevoArea);

        btnGuardarArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/save_35px.png"))); // NOI18N
        btnGuardarArea.setFocusable(false);
        btnGuardarArea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardarArea.setLabel("Guardar");
        btnGuardarArea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarAreaActionPerformed(evt);
            }
        });
        jToolBar3.add(btnGuardarArea);

        btnActualizarArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/update_35px.png"))); // NOI18N
        btnActualizarArea.setText("Actualizar");
        btnActualizarArea.setFocusable(false);
        btnActualizarArea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarArea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAreaActionPerformed(evt);
            }
        });
        jToolBar3.add(btnActualizarArea);

        btnEliminarArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/cancel_35px.png"))); // NOI18N
        btnEliminarArea.setText("Eliminar");
        btnEliminarArea.setFocusable(false);
        btnEliminarArea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminarArea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAreaActionPerformed(evt);
            }
        });
        jToolBar3.add(btnEliminarArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Areas", jPanel2);

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
        LlenarTabla(tablaJfeInmediato);
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          int filaInicio = tablaJfeInmediato.getSelectedRow();
        int numFS = tablaJfeInmediato.getSelectedRowCount();
        ArrayList<String> listId = new ArrayList();
        String id = "";
        String nombre="" ;
        if (filaInicio >= 0) {
            for (int i = 0; i < numFS; i++) {
                id = String.valueOf( tablaJfeInmediato.getValueAt(i + filaInicio, 0));
                 nombre= String.valueOf( tablaJfeInmediato.getValueAt(i + filaInicio, 1));
                listId.add(id);
            }
            System.out.println(listId);

            for (int i = 0; i < numFS; i++) {
                int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quiere eliminar el registro con ID=" + id +" "+nombre+ " ?");
                if (rptaUsuario == 0) {
                    dao.eliminarJefeInm(Integer.parseInt(id));
                }
            }
            LlenarTabla(tablaJfeInmediato);
        } else {
            JOptionPane.showMessageDialog(null, "debes seleccionar solo una fila");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnGuardarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPuestoActionPerformed
     String nombre = txtPuesto.getText();
 
        dao.GuardarPuesto(nombre);
        LlenarTabla_Puestos(tablapuestos);
    }//GEN-LAST:event_btnGuardarPuestoActionPerformed

    private void btnEliminarPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPuestoActionPerformed
int filaInicio = tablapuestos.getSelectedRow();
        int numFS = tablapuestos.getSelectedRowCount();
        ArrayList<String> listId = new ArrayList();
        String id = "";
        String nombre="" ;
        if (filaInicio >= 0) {
            for (int i = 0; i < numFS; i++) {
                id = String.valueOf( tablapuestos.getValueAt(i + filaInicio, 0));
                 nombre= String.valueOf( tablapuestos.getValueAt(i + filaInicio, 1));
                listId.add(id);
            }
            System.out.println(listId);

            for (int i = 0; i < numFS; i++) {
                int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quiere eliminar el registro con ID=" + id +" "+nombre+ " ?");
                if (rptaUsuario == 0) {
                    dao.eliminarPuesto(Integer.parseInt(id));
                }
            }
            LlenarTabla_Puestos(tablapuestos);
        } else {
            JOptionPane.showMessageDialog(null, "debes seleccionar solo una fila");
        }  
    }//GEN-LAST:event_btnEliminarPuestoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int filaEditar = tablaJfeInmediato.getSelectedRow();
        int numFS = tablaJfeInmediato.getSelectedRowCount();

        if (filaEditar >= 0 && numFS == 1) {
           
         String numEmp=String.valueOf(tablaJfeInmediato.getValueAt(filaEditar, 0));
       
      model.setId(Integer.parseInt(numEmp));
        txtAbrev.setText(dao.obtenerDatosJE(numEmp).get(0).getAbrev());
         txtNombre.setText(dao.obtenerDatosJE(numEmp).get(0).getNombre());
         txtApe1.setText(dao.obtenerDatosJE(numEmp).get(0).getApePaterno());
        txtApe2.setText(dao.obtenerDatosJE(numEmp).get(0).getApeMaterno());
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       model.setAbrev(txtAbrev.getText());
       model.setNombre(txtNombre.getText());
       model.setApePaterno(txtApe1.getText());
      model.setApeMaterno(txtApe2.getText());
       

       dao.editarDatosJI(model);
       LimpiarCJI();
       LlenarTabla(tablaJfeInmediato);
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    txtPuesto.setEnabled(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void editarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarpActionPerformed
    editar(tablapuestos,txtPuesto);
       
    }//GEN-LAST:event_editarpActionPerformed

    private void btnActualizarpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarpuestoActionPerformed
       model.setNombre(txtPuesto.getText());
       
       dao.editarDatosPuestos(model);
       LlenarTabla_Puestos(tablapuestos);
    }//GEN-LAST:event_btnActualizarpuestoActionPerformed

    private void tbnNuevoAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnNuevoAreaActionPerformed
     txtArea.setText("");
     txtArea.setEnabled(true);
    }//GEN-LAST:event_tbnNuevoAreaActionPerformed

    private void btnGuardarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarAreaActionPerformed
       String nombre = txtArea.getText();
 
        dao.GuardarArea(nombre);
        LlenarTabla_Areas(tb_areas);
        txtArea.setText("");
    }//GEN-LAST:event_btnGuardarAreaActionPerformed

    private void btnActualizarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAreaActionPerformed
     model.setNombre(txtArea.getText());
       
       dao.editarArea(model);
       LlenarTabla_Areas(tb_areas);
       txtArea.setText("");
    }//GEN-LAST:event_btnActualizarAreaActionPerformed

    private void btnEliminarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAreaActionPerformed
     int filaInicio = tb_areas.getSelectedRow();
        int numFS = tb_areas.getSelectedRowCount();
        ArrayList<String> listId = new ArrayList();
        String id = "";
        String nombre="" ;
        if (filaInicio >= 0) {
            for (int i = 0; i < numFS; i++) {
                id = String.valueOf( tb_areas.getValueAt(i + filaInicio, 0));
                 nombre= String.valueOf( tb_areas.getValueAt(i + filaInicio, 1));
                listId.add(id);
            }
           

            for (int i = 0; i < numFS; i++) {
                int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quiere eliminar el registro con ID=" + id +" "+nombre+ " ?");
                if (rptaUsuario == 0) {
                    dao.eliminarArea(Integer.parseInt(id));
                }
            }
            LlenarTabla_Areas(tb_areas);
        } else {
            JOptionPane.showMessageDialog(null, "debes seleccionar solo una fila");
        }    
    }//GEN-LAST:event_btnEliminarAreaActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    editar(tb_areas,txtArea);
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu Editar;
    private javax.swing.JButton btnActualizarArea;
    private javax.swing.JButton btnActualizarpuesto;
    private javax.swing.JButton btnEliminarArea;
    private javax.swing.JButton btnEliminarPuesto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarArea;
    private javax.swing.JButton btnGuardarPuesto;
    private javax.swing.JPopupMenu editarArea;
    private javax.swing.JPopupMenu editarPuestos;
    private javax.swing.JMenuItem editarp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JPanel pJefeInmediato;
    private javax.swing.JTable tablaJfeInmediato;
    private javax.swing.JTable tablapuestos;
    private javax.swing.JTable tb_areas;
    private javax.swing.JButton tbnNuevoArea;
    private com.swing.JCTextField txtAbrev;
    private com.swing.JCTextField txtApe1;
    private com.swing.JCTextField txtApe2;
    private com.swing.JCTextField txtArea;
    private com.swing.JCTextField txtNombre;
    private com.swing.JCTextField txtPuesto;
    // End of variables declaration//GEN-END:variables
}
