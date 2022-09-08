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

public class EmpleadoSinFoto extends javax.swing.JDialog {

    public EmpleadoSinFoto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    String nume,nombre;
    Conexion con = new Conexion();
    PreparedStatement psql;
    ResultSet rs;
    Connection conn = con.getConnection();
    ModelEmpleado model = new ModelEmpleado();
    //  MainSystem main= new MainSystem();

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
                "Nombre", "Num. Emp.", "Tipo"
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
        if (tableEmpleados.getColumnModel().getColumnCount() > 0) {
            tableEmpleados.getColumnModel().getColumn(1).setPreferredWidth(80);
        }

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/add_25px.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1))
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

    private void tableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpleadosMouseClicked
        int filaEditar = tableEmpleados.getSelectedRow();
        int numFS = tableEmpleados.getSelectedRowCount();

        if (filaEditar >= 0 && numFS == 1) {
            String numEmp = String.valueOf(tableEmpleados.getValueAt(filaEditar, 1));
            String nombre= String.valueOf(tableEmpleados.getValueAt(filaEditar, 0));
            if (evt.getClickCount() == 1) {
                this.setNume(numEmp);
                this.setNombre(nombre);
            }

        }
    }//GEN-LAST:event_tableEmpleadosMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        limpiarTabla();
        Llenar_tabla();
    }//GEN-LAST:event_txtNombreKeyTyped
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

            columna[0] = this.Empleados().get(i).getName();
            columna[1] = this.Empleados().get(i).getNumEmp();
            columna[2] = this.Empleados().get(i).getTipoContrato();
            //columna[4] = this.Empleados().get(i).getStatus();

            modelt.addRow(columna);
        }
    }

    public ArrayList<ModelEmpleado> Empleados() {
        ArrayList listaPersonal = new ArrayList();
        ModelEmpleado personal;

        String SentenciaSQL = "SELECT concat(abrev_nombre,' ',nombre,' ',ape_materno,' ',ape_paterno)nombreComp,num_empleado,tipo_contratacion\n"
                + "FROM tbl_empleado\n"
                + "INNER JOIN tbl_empleo\n"
                + "ON tbl_empleado.id_empleado=tbl_empleo.id_empleado where nombre LIKE '%" + txtNombre.getText() + "%' or ape_paterno LIKE '%" + txtNombre.getText() + "%' or ape_materno LIKE '%" + txtNombre.getText() + "%'";

        try {
            conn = con.getConnection();
            psql = conn.prepareStatement(SentenciaSQL);

            ResultSet rs = psql.executeQuery();
            while (rs.next()) {
                personal = new ModelEmpleado();

                personal.setName(rs.getString(1));
                personal.setNumEmp(rs.getString(2));
                personal.setTipoContrato(rs.getString(3));

                listaPersonal.add(personal);
               
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
//        finally {
//            try {
//                if (conn != null) {
//                    con.cerrar();
//                }
//            } catch (SQLException ex) {
//
//                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
//                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
//            }
//        } 
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
