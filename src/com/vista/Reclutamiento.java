package com.vista;

import com.DAO.ConvocatoriasDAO;
import com.classes.Validaciones;
import com.model.ModelConvocatorias;
//import static com.oracle.jrockit.jfr.ContentType.Bytes;
import com.table.status.RenderTabla;
import java.awt.Button;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Reclutamiento extends javax.swing.JPanel {

    ModelConvocatorias model;
    String rutaArchivo;
    File ruta;
    ConvocatoriasDAO dao = new ConvocatoriasDAO();
    private int idd;
    byte archivo[];

    public Reclutamiento() {
        initComponents();
        bloquear();
        visualizar_PdfVO(tbl_convocatorias);
    }

// public void llenarTabla(JTable tabla){
//     RenderTabla miRender = new RenderTabla();
//
//tabla.setDefaultRenderer (Object.class, (TableCellRenderer) miRender);
//
//
// }
    public void save() throws IOException {

        model = new ModelConvocatorias();
        model.setNoconvocatoria(txtNumConvocatoria.getText());
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechainicio = (formatofecha.format(fechaInicio.getDate()));
        String fechafinv = (formatofecha.format(fechaFin.getDate()));
        String fechapublic = (formatofecha.format(fechaPublicacion.getDate()));
        model.setFechaInicio(fechainicio);
        model.setFechaFinalizacion(fechafinv);
        model.setNoVacante((int) noVacante.getValue());
        model.setFechaPublicación(fechapublic);
        model.setLinkFacebook(txtLinkFacebook.getText());
        model.setLinkPW(linkPW.getText());
        model.setPeriodo(txtPeriodo.getText());
        String estatus = (String) cmbEstatus.getSelectedItem();
        model.setEstatus(estatus);
        if (ruta != null) {
            try {
                byte[] pdf = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(pdf);
                model.setArchivo(pdf);
                dao.registrar(model);

            } catch (IOException ex) {
                //   model.setArchivo(null);
                JOptionPane.showMessageDialog(null, "Error al agregar archivo pdf " + ex.getMessage());
            }
        } else {
            int opcion = JOptionPane.showConfirmDialog(null, "No se ha agregado ningún archivo aún, desea agregarlo? ");
            if (opcion == 0) {
                agregar_comprobante();
            } else {
                model.setArchivo(null);
                try {
                    dao.registrar(model);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }

    }

    public void update() throws IOException {
        if (dao.numEmpExiste(idd) == 1) {
            model = new ModelConvocatorias();

            model.setNoconvocatoria(txtNumConvocatoria.getText());
            SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechainicio = (formatofecha.format(fechaInicio.getDate()));
            String fechafinv = (formatofecha.format(fechaFin.getDate()));
            String fechapublic = (formatofecha.format(fechaPublicacion.getDate()));
            model.setFechaInicio(fechainicio);
            model.setFechaFinalizacion(fechafinv);
            model.setNoVacante((int) noVacante.getValue());
            model.setFechaPublicación(fechapublic);
            model.setLinkFacebook(txtLinkFacebook.getText());
            model.setLinkPW(linkPW.getText());
            model.setPeriodo(txtPeriodo.getText());
            String estatus = (String) cmbEstatus.getSelectedItem();
            model.setEstatus(estatus);
            try {
                 
                ConvocatoriasDAO pd = new ConvocatoriasDAO();
                pd.ejecutar_archivoPDF(idd);
              
                if (pd.getB() != null) {
//               InputStream input = new FileInputStream();
//                    input.read(archivo);
                    model.setArchivo(this.getArchivo());
                    dao.update(model, idd);

                } else if (pd.getB() == null) {
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Desea agregar un archivo? ");
                    if (opcion == 0) {
                        agregar_comprobante();
                        dao.update(model, idd);
                    }
                } else {
                    if (ruta != null) {
                        try {
                            byte[] pdf = new byte[(int) ruta.length()];
                            InputStream input = new FileInputStream(ruta);
                            input.read(pdf);
                            model.setArchivo(pdf);
                            dao.update(model, idd);

                        } catch (IOException ex) {
                            //   model.setArchivo(null);
                            JOptionPane.showMessageDialog(null, "Error al agregar archivo pdf " + ex.getMessage());
                        }
                    }
                }
            } catch (HeadlessException | IOException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Este registro ya existe, si lo que quiere es actualizar pulse el botón actualizar");
        }

    }
//max_allowed_packet=5M

    private void agregar_comprobante() throws FileNotFoundException, IOException {
        // Inicia el JFileChooser
        JFileChooser fc = new JFileChooser();
        // Se crea un filtro de extensiones para que solamente pueda seleccionar archivos PDF
        FileFilter ff = new FileNameExtensionFilter("pdf", "png", "jpg");
        // Se asigna el filtro al objeto JFileChooser
        fc.setFileFilter(ff);
        // Se muestra la ventana de JFilChooser

        int opcionav = fc.showOpenDialog(this);
        if (opcionav == JFileChooser.APPROVE_OPTION) {
            // Se asigna el archivo seleccionado a un objeto tipo File
            File archivoPDF = fc.getSelectedFile();
            rutaArchivo = archivoPDF.getAbsolutePath();
            ruta = new File(rutaArchivo);
            if (rutaArchivo.trim().length() != 0) {
//                byte[] pdf = new byte[(int) rutaArchivo.length()];
//                InputStream input = new FileInputStream(rutaArchivo);
//                input.read(pdf);
//                model.setArchivo(pdf);

//  guardarStatus(ruta);
                lbIconCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("src/com/icon/check_circle_20px.png")));
            } else {
                lbIconCheck.setIcon(null);
                lbIconCheck.repaint();
            } //  model.setArchivo(null);

            // Se sustituye la ruta por la ruta absoluta obtenida del objeto File
            int opcionpdf = JOptionPane.showConfirmDialog(null, "¿Quiere ver el archivo agregado?", "Archivo", JOptionPane.YES_NO_OPTION);
            if (opcionpdf == 0) {
                try {
                    Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,"
                            + "ShellExec_RunDLL " + rutaArchivo);
                } catch (Exception evvv) {
                    JOptionPane.showMessageDialog(null, "No se puede abrir el archivo de ayuda,"
                            + " probablemente fue borrado", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            lbIconCheck.setIcon(null);
            lbIconCheck.repaint();
            model.setArchivo(null);
        }

    }
    //Permite mostrar PDF contenido en la base de datos

    public void visualizar_PdfVO(JTable tabla) {
        // tabla.setDefaultRenderer(Object.class, new imgTabla());

        RenderTabla miRender = new RenderTabla();
        tabla.setDefaultRenderer(Object.class, miRender);
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("ID");
        dt.addColumn("PERIODO");
        dt.addColumn("NO. CONV.");
        dt.addColumn("FECHA INICIO");
        dt.addColumn("FECHA FIN");
        dt.addColumn("NO. VACANTE");
        dt.addColumn("FECHA PUBLICACIÓN");
        dt.addColumn("LINK-FACEBOOK");
        dt.addColumn("LINK WEB");
        dt.addColumn("ARCHIVO");
        dt.addColumn("ESTATUS");

        ImageIcon icono = null;
        if (get_Image("/com/icon/pdf30.png") != null) {
            icono = new ImageIcon(get_Image("/com/icon/pdf30.png"));
        }

        dao = new ConvocatoriasDAO();
        ModelConvocatorias vo = new ModelConvocatorias();
        ArrayList<ModelConvocatorias> list = dao.Listar_convocatorias();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[11];
                vo = list.get(i);
                fila[0] = vo.getId();
                fila[1] = vo.getPeriodo();
                fila[2] = vo.getNoconvocatoria();
                fila[3] = vo.getFechaInicio();
                fila[4] = vo.getFechaFinalizacion();
                fila[5] = vo.getNoVacante();
                fila[6] = vo.getFechaPublicación();
                fila[7] = vo.getLinkFacebook();
                fila[8] = vo.getLinkPW();

                if (vo.getArchivo() != null) {
                    fila[9] = new JButton(icono);

                } else {
                    fila[9] = new JButton("Vacio");
                }

                fila[10] = vo.getEstatus();
//               
                dt.addRow(fila);
            }
            tabla.setModel(dt);

            tabla.setRowHeight(32);

            int[] anchos = {50, 100, 100, 100, 100, 100, 100, 150, 100, 50, 100};
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                //    table_data.set
                tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabla.doLayout();
        }
    }

    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }

    private void validar() {
        Validaciones.esCajaVacia(txtNumConvocatoria, "No de Convocatoria vaciía");
        if (fechaInicio.getDate() == null) {
            JOptionPane.showMessageDialog(null, "La fecha de inicio de convocatoria está vacía", "AVISO", JOptionPane.ERROR_MESSAGE);
        }
        if (fechaFin.getDate() == null) {
            JOptionPane.showMessageDialog(null, "La fecha de finalización de convocatoria está vacía", "AVISO", JOptionPane.ERROR_MESSAGE);
        }

        if ((int) noVacante.getValue() == 0) {
            JOptionPane.showMessageDialog(null, "No de Vacantes es '0'", "AVISO", JOptionPane.ERROR_MESSAGE);
        }
        Validaciones.esCajaVacia(txtPeriodo, "El periodo ede vacante está vacio");
        if (fechaPublicacion.getDate() == null) {
            JOptionPane.showMessageDialog(null, "La fecha de finalización de convocatoria está vacía", "AVISO", JOptionPane.ERROR_MESSAGE);
        }
        Validaciones.esCajaVacia(txtLinkFacebook, "Link de facebook está vacio");
        // Validaciones.esCajaVacia(linkPW, "El periodo ede vacante está vacío");
    }

    private void bloquear() {
        txtNumConvocatoria.setEnabled(false);
        fechaInicio.setEnabled(false);
        fechaFin.setEnabled(false);
        noVacante.setEnabled(false);
        fechaPublicacion.setEnabled(false);
        txtPeriodo.setEnabled(false);
        txtLinkFacebook.setEnabled(false);
        linkPW.setEnabled(false);
        btnAgregar.setEnabled(false);
        cmbEstatus.setEnabled(false);
    }

    private void desbloquear() {
        txtNumConvocatoria.setEnabled(true);
        fechaInicio.setEnabled(true);
        fechaFin.setEnabled(true);
        noVacante.setEnabled(true);
        fechaPublicacion.setEnabled(true);
        txtPeriodo.setEnabled(true);
        txtLinkFacebook.setEnabled(true);
        linkPW.setEnabled(true);
        btnAgregar.setEnabled(true);
        cmbEstatus.setEnabled(true);
    }

    private void limpiar() {
        txtNumConvocatoria.setText("");
        fechaInicio.setDate(null);;
        fechaFin.setDate(null);;
        noVacante.setValue(0);
        fechaPublicacion.setDate(null);;
        txtPeriodo.setText("");
        txtLinkFacebook.setText("");
        linkPW.setText("");

        //  rutaArchivo = "";
    }

    public void eliminar(JTable tabla) {
        DefaultTableModel tb = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        visualizar_PdfVO(tabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtNumConvocatoria = new com.swing.JCTextField();
        txtLinkFacebook = new com.swing.JCTextField();
        fechaPublicacion = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        linkPW = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        fechaFin = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        noVacante = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        lbIconCheck = new javax.swing.JLabel();
        txtPeriodo = new com.swing.JCTextField();
        jLabel6 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbEstatus = new javax.swing.JComboBox<>();
        lbeye = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_convocatorias = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        Editar.setText("editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(Editar);

        setOpaque(false);
        setLayout(new java.awt.GridBagLayout());

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la convocatoria laboral", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 0, 12))); // NOI18N
        jPanel1.setToolTipText("");

        txtNumConvocatoria.setPlaceholder("No. de Convocatoria");

        fechaPublicacion.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel2.setText("Fecha de publicación de la convocatoria");

        jLabel3.setText("No. de Convocatoria");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-facebook-35.png"))); // NOI18N
        jLabel4.setText("Link de la convocatoria en Facebook");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/search_2.png"))); // NOI18N
        jLabel5.setText("Comprobante (PDF,foto,etc) ");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-internet-35.png"))); // NOI18N
        jLabel7.setText("Link en Página Web u otro");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vigencia", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Poppins", 1, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel2.setToolTipText("");

        jLabel8.setText("Fecha inicio");

        fechaInicio.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel9.setText("Fecha de finalización");

        fechaFin.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(17, 17, 17))
                    .addComponent(fechaInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel10.setText("Número de Vacante");

        noVacante.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N

        jLabel1.setText("Periodo de contratación");

        txtPeriodo.setPlaceholder("ejemp. ENE-2020/JUN-2020");

        jLabel6.setText("ID:");

        id.setEnabled(false);

        jLabel11.setText("Estatus:");

        cmbEstatus.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cmbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Vigente", "Finalizado" }));

        lbeye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/eye.png"))); // NOI18N
        lbeye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbeyeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addComponent(txtNumConvocatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noVacante, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(161, 161, 161)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLinkFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linkPW, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(lbeye)))
                .addGap(91, 91, 91))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {fechaPublicacion, linkPW, txtLinkFacebook, txtNumConvocatoria});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fechaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtLinkFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(linkPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumConvocatoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(noVacante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbIconCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbeye))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))))
                        .addContainerGap(26, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAgregar, fechaPublicacion, linkPW, txtLinkFacebook, txtNumConvocatoria});

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbl_convocatorias.setAutoCreateRowSorter(true);
        tbl_convocatorias.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tbl_convocatorias.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_convocatorias.setComponentPopupMenu(jPopupMenu1);
        tbl_convocatorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_convocatoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_convocatorias);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 386, 893, 297));

        jToolBar1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);

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

        jPanel3.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(909, 406, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.ipady = 25;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        desbloquear();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        validar();
        try {
            save();
        } catch (IOException ex) {
            Logger.getLogger(Reclutamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaInicio = tbl_convocatorias.getSelectedRow();
        int numFS = tbl_convocatorias.getSelectedRowCount();
        ArrayList<String> listId = new ArrayList();
        String id = "";
        String nombre = "";
        if (filaInicio >= 0) {
            for (int i = 0; i < numFS; i++) {
                id = String.valueOf(tbl_convocatorias.getValueAt(i + filaInicio, 0));
                nombre = String.valueOf(tbl_convocatorias.getValueAt(i + filaInicio, 1));
                listId.add(id);
            }

            for (int i = 0; i < numFS; i++) {
                int rptaUsuario = JOptionPane.showConfirmDialog(null, "¿Quiere eliminar el registro de la convocatoria con No.:" + nombre + " ?");
                if (rptaUsuario == 0) {
                    dao.eliminarRConv(Integer.parseInt(id));
                }
            }
            eliminar(tbl_convocatorias);
        } else {
            JOptionPane.showMessageDialog(null, "debes seleccionar solo una fila");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (id.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Primero seleccione la opción 'Editar' (Click derecho) de la fila que desea modificar");
        } else {
            try {

                update();
            } catch (IOException ex) {
                Logger.getLogger(Reclutamiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            agregar_comprobante();
        } catch (IOException ex) {
            Logger.getLogger(Reclutamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tbl_convocatoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_convocatoriasMouseClicked

        int column = tbl_convocatorias.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tbl_convocatorias.getRowHeight();
        //  activa_boton(false, true, true);
        //    txtname.setEnabled(true);
        if (row < tbl_convocatorias.getRowCount() && row >= 0 && column < tbl_convocatorias.getColumnCount() && column >= 0) {

            switch (column) {
                case 9:
                    int id = (int) tbl_convocatorias.getValueAt(row, 0);
                    Object value = tbl_convocatorias.getValueAt(row, 9);
                    if (value instanceof JButton) {
                        ((JButton) value).doClick();
                        JButton boton = (JButton) value;

                        if (boton.getText().equals("Vacio")) {
                            JOptionPane.showMessageDialog(null, "No hay archivo");
                        } else {
                            ConvocatoriasDAO pd = new ConvocatoriasDAO();

                            pd.ejecutar_archivoPDF(id);
                            try {
                                Desktop.getDesktop().open(new File("new.pdf"));
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage());
                            }
                        }

                    }
                    break;
                case 8: {
                    Object link = tbl_convocatorias.getValueAt(row, 8);
                    try {
                        Desktop.getDesktop().browse(new URI((String) link));
                    } catch (URISyntaxException | IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    break;
                }
                case 7: {
                    Object linkf = tbl_convocatorias.getValueAt(row, 7);
                    try {
                        Desktop.getDesktop().browse(new URI((String) (linkf)));
                    } catch (URISyntaxException | IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    break;
                }
                default:
                    break;
            }
        }
    }//GEN-LAST:event_tbl_convocatoriasMouseClicked

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        btnGuardar.setEnabled(false);
        desbloquear();
        int row = tbl_convocatorias.getSelectedRow();
        int numFS = tbl_convocatorias.getSelectedRowCount();
        if (row >= 0 && numFS == 1) {

            idd = (int) tbl_convocatorias.getValueAt(row, 0);
            Object periodo = tbl_convocatorias.getValueAt(row, 1);
            Object noConv = tbl_convocatorias.getValueAt(row, 2);
            Object fechaIni = tbl_convocatorias.getValueAt(row, 3);
            Object fechafin = tbl_convocatorias.getValueAt(row, 4);
            Object novac = tbl_convocatorias.getValueAt(row, 5);
            Object fechapublic = tbl_convocatorias.getValueAt(row, 6);
            Object linkf = tbl_convocatorias.getValueAt(row, 7);
            Object linkpw = tbl_convocatorias.getValueAt(row, 8);

            Date date = null, date2 = null, datepub = null;
            try {
                date = new com.ibm.icu.text.SimpleDateFormat("yyy-MM-dd").parse((String) fechaIni);
                date2 = new com.ibm.icu.text.SimpleDateFormat("yyy-MM-dd").parse((String) fechafin);
                datepub = new com.ibm.icu.text.SimpleDateFormat("yyy-MM-dd").parse((String) fechapublic);

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

            Object value = tbl_convocatorias.getValueAt(row, 9);
//            archivo = (byte[]) tbl_convocatorias.getValueAt(row, 9);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getText().equals("Vacio")) {
                    JOptionPane.showMessageDialog(null, "No hay archivo");
                } else {
//                    InputStream bos = new ByteArrayInputStream(archivo);
//
//                    int tamanoInput;
//                    try {
//                        tamanoInput = bos.available();
//                        byte[] datosPDF = new byte[tamanoInput];
//                        bos.read(datosPDF, 0, tamanoInput);
//                    } catch (IOException ex) {
//                        Logger.getLogger(Reclutamiento.class.getName()).log(Level.SEVERE, null, ex);
//                    }

                    lbIconCheck.setIcon(new javax.swing.ImageIcon(getClass().getResource("src/com/icon/check_circle_20px.png")));
                    lbIconCheck.repaint();
                    lbeye.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            lbeyeMouseClicked(evt);

                            ConvocatoriasDAO pd = new ConvocatoriasDAO();

                            pd.ejecutar_archivoPDF(idd);
                            try {
                                Desktop.getDesktop().open(new File("new.pdf"));
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage());
                            }
                        }
                    });

                }
                id.setText("" + idd);
                txtNumConvocatoria.setText((String) noConv);
                fechaInicio.setDate(date);;
                fechaFin.setDate(date2);;
                noVacante.setValue(novac);
                fechaPublicacion.setDate(datepub);;
                txtPeriodo.setText((String) periodo);
                txtLinkFacebook.setText((String) linkf);
                linkPW.setText((String) linkpw);
            }
        }

    }//GEN-LAST:event_EditarActionPerformed

    private void lbeyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbeyeMouseClicked

    }//GEN-LAST:event_lbeyeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cmbEstatus;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private com.toedter.calendar.JDateChooser fechaPublicacion;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lbIconCheck;
    private javax.swing.JLabel lbeye;
    private javax.swing.JTextField linkPW;
    private javax.swing.JSpinner noVacante;
    private javax.swing.JTable tbl_convocatorias;
    private com.swing.JCTextField txtLinkFacebook;
    private com.swing.JCTextField txtNumConvocatoria;
    private com.swing.JCTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

}
