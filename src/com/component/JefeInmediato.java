/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.component;

import com.connection.Conexion;
import com.model.ModelEmpleado;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class JefeInmediato extends javax.swing.JDialog {

    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JefeInmediato(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new com.swing.JCTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmpleados = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNombre.setCaretColor(new java.awt.Color(51, 51, 51));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNombre.setPlaceholder("Buscar por nombre o por apellidos ...");
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N

        tableEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmpleados);

        btnAdd.setText("+");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            limpiarTabla();
            Llenar_tabla();
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        limpiarTabla();
        Llenar_tabla();
    }//GEN-LAST:event_txtNombreKeyTyped

    private void tableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpleadosMouseClicked
        int filaEditar = tableEmpleados.getSelectedRow();
        int numFS = tableEmpleados.getSelectedRowCount();

        if (filaEditar >= 0 && numFS == 1) {
            //String numEmp = String.valueOf(tableEmpleados.getValueAt(filaEditar, 1));
            String idd = String.valueOf(tableEmpleados.getValueAt(filaEditar, 0));
            if (evt.getClickCount() == 1) {
                this.setId(idd);
                // this.setNombre(nombre);
            }

        }
    }//GEN-LAST:event_tableEmpleadosMouseClicked

    private void limpiarTabla() {

        DefaultTableModel modelt = (DefaultTableModel) tableEmpleados.getModel();

        int filas = tableEmpleados.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelt.removeRow(0);
        }

    }

    void Llenar_tabla() {
        DefaultTableModel modelt = (DefaultTableModel) tableEmpleados.getModel();

        int numReg = this.Empleados().size();

        //numReg de solo UNA TABLA faltan las demas
        Object[] columna = new Object[3];

        for (int i = 0; i < numReg; i++) {
//            columna[0] = this.Empleados().get(i).getIcon();

            columna[0] = this.Empleados().get(i).getId();
            columna[1] = this.Empleados().get(i).getNombre();
        //    columna[2] = this.Empleados().get(i).getTipoContrato();
            //columna[4] = this.Empleados().get(i).getStatus();

            modelt.addRow(columna);
        }
    }

    public ArrayList<ModelJefe> Empleados() {
        Conexion con = new Conexion();
        PreparedStatement psql;
        ResultSet rs;
        Connection conn = con.getConnection();
        ArrayList listaPersonal = new ArrayList();
        ModelJefe personal;

        String SentenciaSQL = "SELECT id_jefeInmediato,concat(abrev,' ',nombre,' ',ape_paterno,' ',ape_materno)nombreJefe FROM db_rh.tbl_jefeinmediato";

        try {
            conn = con.getConnection();
            psql = conn.prepareStatement(SentenciaSQL);

            rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelJefe();

                personal.setId(rs.getString(1));
                personal.setNombre(rs.getString(2));
              //  personal.setTipoContrato(rs.getString(3));

                listaPersonal.add(personal);

            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(e);
        }

        return listaPersonal;

    }

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEmpleados;
    private com.swing.JCTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
