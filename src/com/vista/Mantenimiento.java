package com.vista;

import com.DAO.ConsultasJAP;
import com.DAO.MantenimientoDAO;
import com.component.GestionEncabezadoTabla;
import com.model.MantenimientoModel;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public final class Mantenimiento extends javax.swing.JPanel {

    MantenimientoDAO dao = new MantenimientoDAO();
    MantenimientoModel model = new MantenimientoModel();
    ConsultasJAP jap = new ConsultasJAP();

    public Mantenimiento() {
        initComponents();
        bloquearTextfiel();
        LlenarTabla(tablaJfeInmediato);
        LlenarTabla_Puestos(tablapuestos);
        LlenarTabla_Areas(tb_areas);
        jap.ObteberPuestos(cmbPuesto);
        bloquearDelete();
        activa_botonJefes(true, true, false);
        activa_botonPuestos(true, true, false);
        activa_botonAreas(true, true, false);
    }

    public void bloquearTextfiel() {
        txtPuesto.setEnabled(false);
        txtArea.setEnabled(false);
    }

    void bloquearDelete() {
        jButton3.setEnabled(false);
        btnEliminarPuesto.setEnabled(false);
        btnEliminarArea.setEnabled(false);
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
        modeloTabla.addColumn("Puesto");

        TableColumnModel columnModel = tablaD.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(20);
        columnModel.getColumn(1).setPreferredWidth(180);
        columnModel.getColumn(2).setPreferredWidth(100);

        int numReg = dao.listJI().size();
        //numReg de solo UNA TABLA faltan las demas
        Object[] columna = new Object[3];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.listJI().get(i).getId();
            columna[1] = dao.listJI().get(i).getNombre();
            columna[2] = dao.listJI().get(i).getPuesto();

            modeloTabla.addRow(columna);

        }

    }

    private void activa_botonJefes(boolean a, boolean b, boolean c) {
        tbnNew.setEnabled(a);
        btnGuardar.setEnabled(b);
        btnActualizarJ.setEnabled(c);

    }

    private void activa_botonAreas(boolean a, boolean b, boolean c) {
        tbnNuevoArea.setEnabled(a);
        btnGuardarArea.setEnabled(b);
        btnActualizarArea.setEnabled(c);

    }

    private void activa_botonPuestos(boolean a, boolean b, boolean c) {
        btnNP.setEnabled(a);
        btnGuardarPuesto.setEnabled(b);
        btnActualizarpuesto.setEnabled(c);

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

    private void editar(JTable tabla, JTextField txt) {
        int filaEditar = tabla.getSelectedRow();
        int numFS = tabla.getSelectedRowCount();
        if (filaEditar >= 0 && numFS == 1) {

            String id = String.valueOf(tabla.getValueAt(filaEditar, 0));
            model.setId(Integer.parseInt(id));

            txt.setEnabled(true);
            txt.setText(String.valueOf(tabla.getValueAt(filaEditar, 1)));
        }
    }

    public void LimpiarCJI() {
        txtAbrev.setText("");
        txtNombre.setText("");
        txtApe1.setText("");
        txtApe2.setText("");
        cmbPuesto.setSelectedIndex(0);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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
        tbnNew = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizarJ = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbPuesto = new javax.swing.JComboBox<>();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        txtPuesto = new com.swing.JCTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablapuestos = new javax.swing.JTable();
        jToolBar2 = new javax.swing.JToolBar();
        btnNP = new javax.swing.JButton();
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

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(826, 417));
        setLayout(new java.awt.GridBagLayout());

        jTabbedPane1.setForeground(new java.awt.Color(102, 102, 102));
        jTabbedPane1.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(625, 556));

        pJefeInmediato.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAbrev.setPlaceholder("abrev.");
        pJefeInmediato.add(txtAbrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 130, -1));

        txtNombre.setPlaceholder("Nombre (s)");
        pJefeInmediato.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 134, -1));

        txtApe1.setPlaceholder("Apellido Paterno");
        pJefeInmediato.add(txtApe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 134, -1));

        txtApe2.setPlaceholder("Apellido Materno");
        pJefeInmediato.add(txtApe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 134, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tablaJfeInmediato.setAutoCreateRowSorter(true);
        tablaJfeInmediato.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tablaJfeInmediato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Puesto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaJfeInmediato.setComponentPopupMenu(Editar);
        jScrollPane1.setViewportView(tablaJfeInmediato);
        if (tablaJfeInmediato.getColumnModel().getColumnCount() > 0) {
            tablaJfeInmediato.getColumnModel().getColumn(2).setPreferredWidth(400);
        }

        pJefeInmediato.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 650, 480));

        jToolBar1.setRollover(true);

        tbnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/add_25px.png"))); // NOI18N
        tbnNew.setText("Nuevo");
        tbnNew.setFocusable(false);
        tbnNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbnNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnNewActionPerformed(evt);
            }
        });
        jToolBar1.add(tbnNew);

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

        btnActualizarJ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/update_35px.png"))); // NOI18N
        btnActualizarJ.setText("Actualizar");
        btnActualizarJ.setFocusable(false);
        btnActualizarJ.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizarJ.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizarJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarJActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActualizarJ);

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

        pJefeInmediato.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setText("Puesto");
        pJefeInmediato.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel2.setText("Nombre (s):");
        pJefeInmediato.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel3.setText("A. Paterno:");
        pJefeInmediato.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("A. Materno:");
        pJefeInmediato.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setText("Abrev.");
        pJefeInmediato.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        cmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        pJefeInmediato.add(cmbPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 200, -1));

        jTabbedPane1.addTab("Jefe Inmediato", pJefeInmediato);

        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setLayout(new java.awt.CardLayout());

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
            tablapuestos.getColumnModel().getColumn(0).setMinWidth(150);
            tablapuestos.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablapuestos.getColumnModel().getColumn(1).setMinWidth(150);
            tablapuestos.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jToolBar2.setRollover(true);

        btnNP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/add_25px.png"))); // NOI18N
        btnNP.setText("Nuevo");
        btnNP.setFocusable(false);
        btnNP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNPActionPerformed(evt);
            }
        });
        jToolBar2.add(btnNP);

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jLayeredPane1.add(jPanel1, "card2");

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_areas.setComponentPopupMenu(editarArea);
        tb_areas.setPreferredSize(new java.awt.Dimension(452, 402));
        jScrollPane3.setViewportView(tb_areas);
        if (tb_areas.getColumnModel().getColumnCount() > 0) {
            tb_areas.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        jToolBar3.setRollover(true);

        tbnNuevoArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/add_25px.png"))); // NOI18N
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Areas", jPanel2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 151;
        gridBagConstraints.ipady = 154;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 50, 11, 0);
        add(jTabbedPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (cmbPuesto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "No ha seleccionado el puesto del jefe inmediato");
        } else {
            String clave = txtAbrev.getText();
            String nombre = txtNombre.getText();
            String aPaterno = txtApe1.getText();
            String aMaterno = txtApe2.getText();
            //String puesto=txtPuestoJ.getText();

            if (clave.equals("") || nombre.equals("") || aPaterno.equals("") || aMaterno.equals("")) {
                JOptionPane.showMessageDialog(null, "Campos Vacíos, Favor de verificar");
            }
            String cadena = (String) cmbPuesto.getSelectedItem();

//Compilamos el regex y el matcher al texto, ignorando mayúsculas/minúsculas (esto es estándar)
//            Pattern pattern = Pattern.compile("([0-9]+)", Pattern.CASE_INSENSITIVE);
//            Matcher matcher = pattern.matcher(cadena);
            String puesto = cadena.substring(cadena.lastIndexOf("-") + 1);

            dao.GuardarJefes(clave, nombre, aPaterno, aMaterno, puesto);
            LlenarTabla(tablaJfeInmediato);
            LimpiarCJI();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked


    }//GEN-LAST:event_btnGuardarMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int filaInicio = tablaJfeInmediato.getSelectedRow();
        int numFS = tablaJfeInmediato.getSelectedRowCount();
        ArrayList<String> listId = new ArrayList();
        String id = "";
        String nombre = "";
        if (filaInicio >= 0) {
            for (int i = 0; i < numFS; i++) {
                id = String.valueOf(tablaJfeInmediato.getValueAt(i + filaInicio, 0));
                nombre = String.valueOf(tablaJfeInmediato.getValueAt(i + filaInicio, 1));
                listId.add(id);
            }
            System.out.println(listId);

            for (int i = 0; i < numFS; i++) {
                int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quiere eliminar el registro con ID=" + id + " " + nombre + " ?");
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
        String nombre = "";
        if (filaInicio >= 0) {
            for (int i = 0; i < numFS; i++) {
                id = String.valueOf(tablapuestos.getValueAt(i + filaInicio, 0));
                nombre = String.valueOf(tablapuestos.getValueAt(i + filaInicio, 1));
                listId.add(id);
            }
            System.out.println(listId);

            for (int i = 0; i < numFS; i++) {
                int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quiere eliminar el registro con ID=" + id + " " + nombre + " ?");
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
        activa_botonJefes(false, false, true);
        int filaEditar = tablaJfeInmediato.getSelectedRow();
        int numFS = tablaJfeInmediato.getSelectedRowCount();

        if (filaEditar >= 0 && numFS == 1) {
            btnGuardar.setEnabled(false);
            String numEmp = String.valueOf(tablaJfeInmediato.getValueAt(filaEditar, 0));

            model.setId(Integer.parseInt(numEmp));
            txtAbrev.setText(dao.obtenerDatosJE(numEmp).get(0).getAbrev());
            txtNombre.setText(dao.obtenerDatosJE(numEmp).get(0).getNombre());
            txtApe1.setText(dao.obtenerDatosJE(numEmp).get(0).getApePaterno());
            txtApe2.setText(dao.obtenerDatosJE(numEmp).get(0).getApeMaterno());

            cmbPuesto.setSelectedItem(dao.obtenerDatosJE(numEmp).get(0).getPuesto());
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnActualizarJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarJActionPerformed

        model.setAbrev(txtAbrev.getText());
        model.setNombre(txtNombre.getText());
        model.setApePaterno(txtApe1.getText());
        model.setApeMaterno(txtApe2.getText());
        String puest = (String) cmbPuesto.getSelectedItem();
        String puestos = puest.substring(puest.lastIndexOf("-") + 1);
        model.setPuesto(puestos);

        dao.editarDatosJI(model);
        LimpiarCJI();
        LlenarTabla(tablaJfeInmediato);
        tbnNew.setEnabled(true);

    }//GEN-LAST:event_btnActualizarJActionPerformed

    private void btnNPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNPActionPerformed
        txtPuesto.setText("");
        txtPuesto.setEnabled(true);
        activa_botonPuestos(true, true, false);
    }//GEN-LAST:event_btnNPActionPerformed

    private void editarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarpActionPerformed
        btnGuardarPuesto.setEnabled(false);
        editar(tablapuestos, txtPuesto);
        activa_botonPuestos(false, false, true);


    }//GEN-LAST:event_editarpActionPerformed

    private void btnActualizarpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarpuestoActionPerformed
        model.setNombre(txtPuesto.getText());

        dao.editarDatosPuestos(model);
        LlenarTabla_Puestos(tablapuestos);
        btnNP.setEnabled(true);
    }//GEN-LAST:event_btnActualizarpuestoActionPerformed

    private void tbnNuevoAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnNuevoAreaActionPerformed
        activa_botonAreas(true, true, false);
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
        tbnNuevoArea.setEnabled(true);
    }//GEN-LAST:event_btnActualizarAreaActionPerformed

    private void btnEliminarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAreaActionPerformed
        int filaInicio = tb_areas.getSelectedRow();
        int numFS = tb_areas.getSelectedRowCount();
        ArrayList<String> listId = new ArrayList();
        String id = "";
        String nombre = "";
        if (filaInicio >= 0) {
            for (int i = 0; i < numFS; i++) {
                id = String.valueOf(tb_areas.getValueAt(i + filaInicio, 0));
                nombre = String.valueOf(tb_areas.getValueAt(i + filaInicio, 1));
                listId.add(id);
            }

            for (int i = 0; i < numFS; i++) {
                int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quiere eliminar el registro con ID=" + id + " " + nombre + " ?");
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
        //btnGuardarArea.setEnabled(false);
        activa_botonAreas(false, false, true);
        editar(tb_areas, txtArea);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tbnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnNewActionPerformed
        LimpiarCJI();
        activa_botonJefes(true, true, false);

    }//GEN-LAST:event_tbnNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu Editar;
    private javax.swing.JButton btnActualizarArea;
    private javax.swing.JButton btnActualizarJ;
    private javax.swing.JButton btnActualizarpuesto;
    private javax.swing.JButton btnEliminarArea;
    private javax.swing.JButton btnEliminarPuesto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarArea;
    private javax.swing.JButton btnGuardarPuesto;
    private javax.swing.JButton btnNP;
    private javax.swing.JComboBox<String> cmbPuesto;
    private javax.swing.JPopupMenu editarArea;
    private javax.swing.JPopupMenu editarPuestos;
    private javax.swing.JMenuItem editarp;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JButton tbnNew;
    private javax.swing.JButton tbnNuevoArea;
    private com.swing.JCTextField txtAbrev;
    private com.swing.JCTextField txtApe1;
    private com.swing.JCTextField txtApe2;
    private com.swing.JCTextField txtArea;
    private com.swing.JCTextField txtNombre;
    private com.swing.JCTextField txtPuesto;
    // End of variables declaration//GEN-END:variables
}
