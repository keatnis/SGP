package com.vista;

import com.DAO.PersonalNDAO;
import com.component.GestionEncabezadoTabla;
import com.component.PlantillaFiltros;
import com.swing.ScrollBar;
import com.tabla.StatusType;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public final class Personal extends javax.swing.JPanel {

    final static String ventana1 = "Ventana Reg";
    final static String RegistrarPN = "Card with JTextField";
    PersonalNDAO dao = new PersonalNDAO();
    RegistrarPN vPN = new RegistrarPN();

    public Personal() {
        initComponents();

   

   spTabla.setVerticalScrollBar(new ScrollBar());
        spTabla.getVerticalScrollBar().setBackground(Color.WHITE);
        spTabla.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTabla.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
LlenarTabla(jtbDatosGenerales);
    jtbDatosGenerales.setAutoResizeMode(0);
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        spTabla = new javax.swing.JScrollPane();
        jtbDatosGenerales = new javax.swing.JTable();
        totalR = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCTextField1 = new com.swing.JCTextField();

        setPreferredSize(new java.awt.Dimension(1000, 629));
        setLayout(new java.awt.GridBagLayout());

        spTabla.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/vista/Bundle"); // NOI18N
        spTabla.setToolTipText(bundle.getString("Personal.spTabla.toolTipText")); // NOI18N
        spTabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        spTabla.setViewportView(null);

        jtbDatosGenerales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtbDatosGenerales.setModel(new javax.swing.table.DefaultTableModel(
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
        spTabla.setViewportView(jtbDatosGenerales);

        totalR.setText(bundle.getString("Personal.totalR.text")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(totalR, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(242, 242, 242))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(spTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 1271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(totalR, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        spTabla.getAccessibleContext().setAccessibleParent(spTabla);

        jTabbedPane1.addTab(bundle.getString("Personal.jPanel4.TabConstraints.tabTitle"), jPanel4); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_30px.png"))); // NOI18N

        jCTextField1.setPlaceholder(bundle.getString("Personal.jCTextField1.placeholder")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(514, 514, 514)
                .addComponent(jCTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = -53;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 0, 124, 0);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
 public void LlenarTabla(JTable tablaD) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tablaD.setModel(modeloTabla);
        JTableHeader jtableHeader = tablaD.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        tablaD.setTableHeader(jtableHeader);
        tablaD.setRowHeight(20);
 
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("No. Empleado");
        modeloTabla.addColumn("Abrev.");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellidos Paterno");
        modeloTabla.addColumn("Apellido Materno");
        modeloTabla.addColumn("Sexo");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Correo Personal");
        modeloTabla.addColumn("Correo Institucional");
        modeloTabla.addColumn("CURP");
        modeloTabla.addColumn("RFC");
        modeloTabla.addColumn("IMSS");
        modeloTabla.addColumn("Estado Civil");
        modeloTabla.addColumn("Lengua Indígena");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Colonia");
        modeloTabla.addColumn("Localidad");
        modeloTabla.addColumn("Contacto de Emergencia");
        modeloTabla.addColumn("Parentesco");
        modeloTabla.addColumn("Tel. Contacto Emerg");
        modeloTabla.addColumn("Tipo de Sangre");

        TableColumnModel columnModel = tablaD.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);
        columnModel.getColumn(1).setPreferredWidth(50);
        columnModel.getColumn(2).setPreferredWidth(50);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(150);
        columnModel.getColumn(5).setPreferredWidth(150);
        columnModel.getColumn(6).setPreferredWidth(50);
        columnModel.getColumn(7).setPreferredWidth(200);
        columnModel.getColumn(8).setPreferredWidth(200);

        int numReg = dao.listPersonalR().size();
        //numReg de solo UNA TABLA faltan las demas
        Object[] columna = new Object[22];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.listPersonalR().get(i).getId();
            columna[1] = dao.listPersonalR().get(i).getNum_empleado();
            columna[2] = dao.listPersonalR().get(i).getAbrev();
            columna[3] = dao.listPersonalR().get(i).getNombres();
            columna[4] = dao.listPersonalR().get(i).getApellidoP();
            columna[5] = dao.listPersonalR().get(i).getApellidoM();
            columna[6] = dao.listPersonalR().get(i).getSexo();
            columna[7] = dao.listPersonalR().get(i).getTelefono();
            columna[8] = dao.listPersonalR().get(i).getCorreoPersonal();
            columna[9] = dao.listPersonalR().get(i).getCorreoInst();
            columna[10] = dao.listPersonalR().get(i).getCURP();
            columna[11] = dao.listPersonalR().get(i).getRFC();
            columna[12] = dao.listPersonalR().get(i).getIMSS();
            columna[13] = dao.listPersonalR().get(i).getEstadoCivil();
            columna[14] = dao.listPersonalR().get(i).getLenguaIndigena();
            columna[15] = dao.listPersonalR().get(i).getDirección();
            columna[16] = dao.listPersonalR().get(i).getColonia();
            columna[17] = dao.listPersonalR().get(i).getLocalidad();
            columna[18] = dao.listPersonalR().get(i).getNombreCEmerg();
            columna[19] = dao.listPersonalR().get(i).getParentestoCEmerg();
            columna[20] = dao.listPersonalR().get(i).getTelefonoCE();
            columna[21] = dao.listPersonalR().get(i).getTipoSangre();

            modeloTabla.addRow(columna);

            int total = tablaD.getRowCount();
            String totalLista = Integer.toString(total);
            totalR.setText(totalLista);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.JCTextField jCTextField1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtbDatosGenerales;
    private javax.swing.JScrollPane spTabla;
    private javax.swing.JLabel totalR;
    // End of variables declaration//GEN-END:variables
}
