package com.vista;

import com.DAO.PersonalNDAO;
import com.component.GestionEncabezadoTabla;
import com.component.PlantillaFiltros;
import com.model.ModelPersonalN;
import com.swing.ScrollBar;
import com.tabla.StatusType;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public final class Personal extends javax.swing.JPanel {

    final static String ventana1 = "Ventana Reg";

    PersonalNDAO dao = new PersonalNDAO();
    RegistrarPN vPN = new RegistrarPN();
    ModelPersonalN model = new ModelPersonalN();

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

        editar = new javax.swing.JPopupMenu();
        Mneditar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        spTabla = new javax.swing.JScrollPane();
        jtbDatosGenerales = new javax.swing.JTable();
        totalR = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jCTextField1 = new com.swing.JCTextField();

        Mneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/edit.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/vista/Bundle"); // NOI18N
        Mneditar.setText(bundle.getString("Personal.Mneditar.text")); // NOI18N
        Mneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MneditarActionPerformed(evt);
            }
        });
        editar.add(Mneditar);

        setPreferredSize(new java.awt.Dimension(1000, 629));
        setLayout(new java.awt.CardLayout());

        spTabla.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        spTabla.setToolTipText(bundle.getString("Personal.spTabla.toolTipText")); // NOI18N
        spTabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
        jtbDatosGenerales.setComponentPopupMenu(editar);
        jtbDatosGenerales.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jCTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void MneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MneditarActionPerformed

        int filaEditar = jtbDatosGenerales.getSelectedRow();
        int numFS = jtbDatosGenerales.getSelectedRowCount();

        if (filaEditar >= 0 && numFS == 1) {

            String numEmp = String.valueOf(jtbDatosGenerales.getValueAt(filaEditar, 2));

            dao.listPersonalPerfil(numEmp);
            System.out.println("num emp" + numEmp);
            PerfilPersonal perfil = new PerfilPersonal();
            this.add(perfil, ventana1);
            CardLayout cl = (CardLayout) (this.getLayout());
            cl.show(this, ventana1);

        }
    }//GEN-LAST:event_MneditarActionPerformed
    private void resizeColumnWidth(JTable table) {
        //Se obtiene el modelo de la columna
        TableColumnModel columnModel = table.getColumnModel();
        //Se obtiene el total de las columnas
        for (int column = 0; column < table.getColumnCount(); column++) {
            //Establecemos un valor minimo para el ancho de la columna
            int width = 50; //Min Width
            //Obtenemos el numero de filas de la tabla
            for (int row = 0; row < table.getRowCount(); row++) {
                //Obtenemos el renderizador de la tabla
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                //Creamos un objeto para preparar el renderer
                Component comp = table.prepareRenderer(renderer, row, column);
                //Establecemos el width segun el valor maximo del ancho de la columna
                width = Math.max(comp.getPreferredSize().width + 5, width);

            }
            //Se establece una condicion para no sobrepasar el valor de 300
            //Esto es Opcional
            if (width > 300) {
                width = 300;
            }
            //Se establece el ancho de la columna
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

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
        modeloTabla.addColumn("Estado");
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

        modeloTabla.addColumn("Fecha de Ingreso");
        modeloTabla.addColumn("Area");
        modeloTabla.addColumn("Jefe Inmediato");
//        TableColumnModel columnModel = tablaD.getColumnModel();

        int numReg = dao.listPersonalR().size();
//        for (int i = 0; i < numReg; i++) {
//           
//        }

        //numReg de solo UNA TABLA faltan las demas
        Object[] columna = new Object[26];

        for (int i = 0; i < numReg; i++) {
            columna[0] = dao.listPersonalR().get(i).getId();

            columna[1] = dao.listPersonalR().get(i).getNum_empleado();
            columna[2] = dao.listPersonalR().get(i).getAbrev();
            columna[3] = dao.listPersonalR().get(i).getNombres();
            columna[4] = dao.listPersonalR().get(i).getApellidoP();
            columna[5] = dao.listPersonalR().get(i).getApellidoM();
            //       columna[6] = dao.listPersonalR().get(i).getApellidoM();
            columna[6] = dao.listPersonalR().get(i).getEstadoi();
            columna[7] = dao.listPersonalR().get(i).getSexo();
            columna[8] = dao.listPersonalR().get(i).getTelefono();
            columna[9] = dao.listPersonalR().get(i).getCorreoPersonal();
            columna[10] = dao.listPersonalR().get(i).getCorreoInst();
            columna[11] = dao.listPersonalR().get(i).getCURP();
            columna[12] = dao.listPersonalR().get(i).getRFC();
            columna[13] = dao.listPersonalR().get(i).getIMSS();
            columna[14] = dao.listPersonalR().get(i).getEstadoCivil();
            columna[15] = dao.listPersonalR().get(i).getLenguaIndigena();
            columna[16] = dao.listPersonalR().get(i).getDirección();
            columna[17] = dao.listPersonalR().get(i).getColonia();
            columna[18] = dao.listPersonalR().get(i).getLocalidad();
            columna[19] = dao.listPersonalR().get(i).getNombreCEmerg();
            columna[20] = dao.listPersonalR().get(i).getParentestoCEmerg();
            columna[21] = dao.listPersonalR().get(i).getTelefonoCE();
            columna[22] = dao.listPersonalR().get(i).getTipoSangre();
            columna[23] = dao.listPersonalR().get(i).getFechaIngreso();
            columna[24] = dao.listPersonalR().get(i).getAreaAdscripción();
            columna[25] = dao.listPersonalR().get(i).getJefeInmediato();
            modeloTabla.addRow(columna);

            //     Ajustar celdas
            resizeColumnWidth(tablaD);
            tablaD.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
 DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            tablaD.getColumnModel().getColumn(i).setCellRenderer(tcr);
            int total = tablaD.getRowCount();
            String totalLista = Integer.toString(total);
            totalR.setText(totalLista);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Mneditar;
    private javax.swing.JPopupMenu editar;
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
