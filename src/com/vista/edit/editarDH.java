package com.vista.edit;

import com.DAO.PersonalNDAO;
import com.model.ModelPersonalN;
import static java.awt.image.ImageObserver.ERROR;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class editarDH extends javax.swing.JDialog {

    PersonalNDAO dao = new PersonalNDAO();
    ModelPersonalN model = new ModelPersonalN();

    public editarDH(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        bloquear();

    }

    void bloquear() {
        txtnombre.setEnabled(false);
        rbHombre1.setEnabled(false);
        rbMujer1.setEnabled(false);
        txtFechaNacDH.setEnabled(false);
        cmbParentescoDH.setEnabled(false);
        cmbEstatus.setEnabled(false);
    }
 void desbloquear() {
        txtnombre.setEnabled(true);
        rbHombre1.setEnabled(true);
        rbMujer1.setEnabled(true);
        txtFechaNacDH.setEnabled(true);
        cmbParentescoDH.setEnabled(true);
        cmbEstatus.setEnabled(true);
    }

    private void registrar_derechohabiente() {
       

              model.setId(this.id_emp);
            model.setNombredh(txtnombre.getText());
            if (txtFechaNacDH.getDate() == null) {
                model.setFechaNacdh("");
            } else {
                SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
                String pasofecha = (formatofecha.format(txtFechaNacDH.getDate()));
                model.setFechaNacdh(pasofecha);
            }

            String parent = (String) cmbParentescoDH.getSelectedItem();
            model.setParentesco(parent);
            String sexodh = null;
            if (rbMujer1.isSelected()) {
                sexodh = "M";
            }
            if (rbHombre1.isSelected()) {
                sexodh = "H";
            }
            model.setSexo(sexodh);
            model.setEstado("1");

            if (dao.GuardarDerechohabiente(model)) {
                JOptionPane.showMessageDialog(null, "Derechohabiente regristrado correctamente");
                 eliminar(tbl_derechohabiente);
            } else {
                JOptionPane.showMessageDialog(null, ERROR);
            }
   

       
    }

    private void actualizar_derechohabiente(int idh) {

        model.setId_dh(idh);
        model.setNombredh(txtnombre.getText());
        if (txtFechaNacDH.getDate() == null) {
            model.setFechaNacdh("");
        } else {
            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            String pasofecha = (formatofecha.format(txtFechaNacDH.getDate()));
            model.setFechaNacdh(pasofecha);
        }

        String parent = (String) cmbParentescoDH.getSelectedItem();
        model.setParentesco(parent);
        String sexodh = null;
        if (rbMujer1.isSelected()) {
            sexodh = "M";
        }
        if (rbHombre1.isSelected()) {
            sexodh = "H";
        }
        model.setSexo(sexodh);
        String estatus = (String) cmbEstatus.getSelectedItem();
        if (estatus.equals("Activo")) {
            model.setEstado("1");
        } else {
            model.setEstado("0");
        }

        if (dao.UpdateDerechohabiente(model, idh)) {
            JOptionPane.showMessageDialog(null, "Actualización exitosa");
                eliminar(tbl_derechohabiente);

        } else {
            JOptionPane.showMessageDialog(null, ERROR);
        }

    }

    public void listDH(JTable tabla) {

        DefaultTableModel dt = (DefaultTableModel) tabla.getModel();
       dao.setId(id_emp);
        int numReg = dao.listDerechohabiente().size();

        Object[] columna = new Object[7];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.listDerechohabiente().get(i).getId_dh();
            columna[1] = dao.listDerechohabiente().get(i).getNombredh();
            columna[2] = dao.listDerechohabiente().get(i).getFechaNacdh();
            columna[3] = dao.listDerechohabiente().get(i).getSexodh();
            columna[4] = dao.listDerechohabiente().get(i).getParentesco();
            columna[5] = dao.listDerechohabiente().get(i).getEdaddh() + " años y " + dao.listDerechohabiente().get(i).getEdadMesesdh() + " meses";
            columna[6] = dao.listDerechohabiente().get(i).getStatus();
            dt.addRow(columna);
        }

    }
    public void eliminar(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        listDH(tabla);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexodh = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        editardh = new javax.swing.JMenuItem();
        panelRFamiliar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cmbParentescoDH = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtFechaNacDH = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        rbHombre1 = new javax.swing.JRadioButton();
        rbMujer1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new com.swing.JCTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbEstatus = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_derechohabiente = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        jPopupMenu1.setLabel("Editar DH");
        jPopupMenu1.setName(""); // NOI18N

        editardh.setText("Editar");
        editardh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editardhActionPerformed(evt);
            }
        });
        jPopupMenu1.add(editardh);

        jPopupMenu1.getAccessibleContext().setAccessibleName("");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        panelRFamiliar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Familiar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel9.setText("Parentesco");

        cmbParentescoDH.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        cmbParentescoDH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Padre", "Madre", "Esposa", "Esposo", "Hijo", "Hija", "otro" }));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel7.setText("Fecha de Nacimiento");

        txtFechaNacDH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel10.setText("Sexo");

        sexodh.add(rbHombre1);
        rbHombre1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbHombre1.setText("Hombre");

        sexodh.add(rbMujer1);
        rbMujer1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbMujer1.setText("Mujer");

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setText("Estatus");

        cmbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Activo", "Inactivo" }));
        cmbEstatus.setEnabled(false);

        javax.swing.GroupLayout panelRFamiliarLayout = new javax.swing.GroupLayout(panelRFamiliar);
        panelRFamiliar.setLayout(panelRFamiliarLayout);
        panelRFamiliarLayout.setHorizontalGroup(
            panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRFamiliarLayout.createSequentialGroup()
                .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRFamiliarLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel9))
                    .addGroup(panelRFamiliarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRFamiliarLayout.createSequentialGroup()
                                .addComponent(rbHombre1)
                                .addGap(32, 32, 32)
                                .addComponent(rbMujer1))
                            .addComponent(txtFechaNacDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(cmbParentescoDH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRFamiliarLayout.setVerticalGroup(
            panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRFamiliarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(rbHombre1))
                    .addComponent(rbMujer1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRFamiliarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRFamiliarLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addGroup(panelRFamiliarLayout.createSequentialGroup()
                        .addComponent(txtFechaNacDH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbParentescoDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(92, 92, 92))
        );

        tbl_derechohabiente.setAutoCreateRowSorter(true);
        tbl_derechohabiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_derechohabiente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre Completo", "Fecha Nacimiento", "Sexo", "Parentesco", "Edad Actual", "Estatus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_derechohabiente.setComponentPopupMenu(jPopupMenu1);
        tbl_derechohabiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_derechohabienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_derechohabiente);
        if (tbl_derechohabiente.getColumnModel().getColumnCount() > 0) {
            tbl_derechohabiente.getColumnModel().getColumn(0).setResizable(false);
            tbl_derechohabiente.getColumnModel().getColumn(0).setPreferredWidth(15);
            tbl_derechohabiente.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_derechohabiente.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbl_derechohabiente.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbl_derechohabiente.getColumnModel().getColumn(4).setPreferredWidth(80);
            tbl_derechohabiente.getColumnModel().getColumn(5).setPreferredWidth(150);
            tbl_derechohabiente.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        jToolBar1.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/add_25px.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/save_35px.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/cancel_35px.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFocusable(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/update_35px.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setFocusable(false);
        btnActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnActualizar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRFamiliar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(142, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        desbloquear();
        txtnombre.setText("");
        sexodh.clearSelection();
        txtFechaNacDH.setDate(null);
        cmbParentescoDH.setSelectedIndex(0);   
        cmbEstatus.setSelectedIndex(0);

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        registrar_derechohabiente();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tbl_derechohabienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_derechohabienteMouseClicked

    }//GEN-LAST:event_tbl_derechohabienteMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaInicio = tbl_derechohabiente.getSelectedRow();
        int numFS = tbl_derechohabiente.getSelectedRowCount();
        ArrayList<String> listId = new ArrayList();
        String id = "";
        String nombre = "";
        if (filaInicio >= 0) {
            for (int i = 0; i < numFS; i++) {
                id = String.valueOf(tbl_derechohabiente.getValueAt(i + filaInicio, 0));
                nombre = String.valueOf(tbl_derechohabiente.getValueAt(i + filaInicio, 1));
                listId.add(id);
            }
            System.out.println(listId);

            for (int i = 0; i < numFS; i++) {
                int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quiere eliminar el registro con ID=" + id + ": " + nombre + " ?");
                if (rptaUsuario == 0) {
                    dao.eliminarDH(Integer.parseInt(id));
                }
            }
            eliminar(tbl_derechohabiente);
        } else {
            JOptionPane.showMessageDialog(null, "debes seleccionar solo una fila");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (this.getId_dh() > 0) {
            actualizar_derechohabiente(this.getId_dh());
        } else {
            JOptionPane.showMessageDialog(null, "Id no seleccionado");
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void editardhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editardhActionPerformed
      desbloquear();
      
        int filaEditar = tbl_derechohabiente.getSelectedRow();
        int numFS = tbl_derechohabiente.getSelectedRowCount();

        if (filaEditar >= 0 && numFS == 1) {
            this.setId_dh((int) tbl_derechohabiente.getValueAt(filaEditar, 0));
            String nombre = String.valueOf(tbl_derechohabiente.getValueAt(filaEditar, 1));
            String fecha = String.valueOf(tbl_derechohabiente.getValueAt(filaEditar, 2));
            String sexo = String.valueOf(tbl_derechohabiente.getValueAt(filaEditar, 3));
            String parent = String.valueOf(tbl_derechohabiente.getValueAt(filaEditar, 4));
            String estatus = String.valueOf(tbl_derechohabiente.getValueAt(filaEditar, 6));
            txtnombre.setText(nombre);
            if (sexo.equals("M")) {
                rbMujer1.setSelected(true);
            } else if (sexo.equals("H")) {
                rbHombre1.setSelected(true);
            } else {
                sexodh.clearSelection();
            }
            Date date;
            try {
                date = new com.ibm.icu.text.SimpleDateFormat("d MMM y").parse(fecha);
                txtFechaNacDH.setDate(date);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            cmbParentescoDH.setSelectedItem(parent);
            if (estatus.equals("Activo")) {
                cmbEstatus.setSelectedIndex(1);
            } else {
                cmbEstatus.setSelectedIndex(2);
            }
        }
    }//GEN-LAST:event_editardhActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbEstatus;
    private javax.swing.JComboBox<String> cmbParentescoDH;
    private javax.swing.JMenuItem editardh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelRFamiliar;
    private javax.swing.JRadioButton rbHombre1;
    private javax.swing.JRadioButton rbMujer1;
    private javax.swing.ButtonGroup sexodh;
    public javax.swing.JTable tbl_derechohabiente;
    private com.toedter.calendar.JDateChooser txtFechaNacDH;
    private com.swing.JCTextField txtnombre;
    // End of variables declaration//GEN-END:variables
int id_dh;
int id_emp;

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public int getId_dh() {
        return id_dh;
    }

    public void setId_dh(int id_dh) {
        this.id_dh = id_dh;
    }

}
