package com.vista.edit;

import com.DAO.FormacionAcademicaDAO;
import com.classes.Validaciones;
import com.model.ModelFormacionAcademica;
import com.model.ModelPersonalN;
import javax.swing.JOptionPane;

public class editarFA extends javax.swing.JDialog {

    FormacionAcademicaDAO daofa = new FormacionAcademicaDAO();
    ModelFormacionAcademica modelfa = new ModelFormacionAcademica();

    public editarFA(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void showFA(ModelPersonalN modelp) {
        cmbNivelEstudios.setSelectedItem(modelp.getNivelEstudios());
        txtCarrera.setText(modelp.getCarreraProfesional());
        txtInstitucion.setText(modelp.getNombreInst());
        cmbEstados.setSelectedItem(modelp.getEntidadFed());
        txtAñoEgreso.setText("" + modelp.getAnio_egreso());

        if (modelp.getConTitulo().equals("1")) {
            cbTitulo.setSelected(true);
        } else {
            cbTitulo.setSelected(false);
        }
        if (modelp.getConPosgrado().equals("1")) {
            cbPosgrado.setSelected(true);
        } else {
            cbPosgrado.setSelected(false);
        }
        if (modelp.getConMaestria().equals("1")) {
            cbMaestria.setSelected(true);
        } else {
            cbMaestria.setSelected(false);
        }
        if (modelp.getConDoctorado().equals("1")) {
            cbDoctorado.setSelected(true);
        } else {
            cbDoctorado.setSelected(false);
        }

    }

    private void updateFA() {

        if (id > 0) {

            modelfa.setId(id);
            String nivel = (String) cmbNivelEstudios.getSelectedItem();
            modelfa.setNivelEstudios(nivel);
            modelfa.setCarreraProfesional(txtCarrera.getText());
            modelfa.setNombreInst(txtInstitucion.getText());
            String estado = (String) cmbEstados.getSelectedItem();
            modelfa.setEntidadFed(estado);
            modelfa.setAnioEgreso(txtAñoEgreso.getText());

            if (cbTitulo.isSelected()) {
                modelfa.setConTitulo("1");
            } else {
                modelfa.setConTitulo("0");
            }

            if (cbPosgrado.isSelected()) {
                modelfa.setConPosgrado("1");
            } else {
                modelfa.setConPosgrado("0");
            }
            if (cbMaestria.isSelected()) {
                modelfa.setConMaestria("1");
            } else {
                modelfa.setConMaestria("0");
            }
            if (cbDoctorado.isSelected()) {
                modelfa.setConDoctorado("1");
            } else {
                modelfa.setConDoctorado("0");
            }

            daofa.update(modelfa, id);

        } else {
            JOptionPane.showMessageDialog(null, "Nose puede registrar ID no registrado");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tp_FormaciónAcadémica = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cmbNivelEstudios = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cmbEstados = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbTitulo = new javax.swing.JCheckBox();
        txtInstitucion = new com.swing.JCTextField();
        txtCarrera = new com.swing.JCTextField();
        cbPosgrado = new javax.swing.JCheckBox();
        jLabel55 = new javax.swing.JLabel();
        cbDoctorado = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        cbMaestria = new javax.swing.JCheckBox();
        txtAñoEgreso = new com.swing.JCTextField();
        btnActualizarDL = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Formación Académica");
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel14.setText("Nivel de Estudios");

        cmbNivelEstudios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Sin estudios", "Primaria", "Secundaria", "Bachillerato preparatoria o equivalente", "Profesional Técnico", "Capacitación para el Trabajo", "Técnico Superior Universitario", "Licenciatura", "Especialización", "Maestría", "Posgrado", "Doctorado", "Otro" }));

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel16.setText("Nombre de la Institución ");

        jLabel17.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel17.setText("Carrera Profesional");

        jLabel18.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel18.setText("¿Tiene Maestría?");

        jLabel19.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel19.setText("Entidad Federativa");

        jLabel20.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel20.setText("Año de Egreso");

        jLabel21.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel21.setText("¿Cuenta conTitulo?");

        cbTitulo.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        cbTitulo.setText("Si");

        txtInstitucion.setPlaceholder("Nombre de la Institución");

        txtCarrera.setPlaceholder("Carrera");

        cbPosgrado.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        cbPosgrado.setText("Si");

        jLabel55.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel55.setText("¿Tiene doctorado?");

        cbDoctorado.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        cbDoctorado.setText("Si");

        jLabel11.setForeground(new java.awt.Color(51, 0, 204));
        jLabel11.setText("* Seleccionar la opción en caso de que sea verdadero");

        jLabel33.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        jLabel33.setText("¿Tiene Posgrado?");

        cbMaestria.setFont(new java.awt.Font("Poppins", 0, 15)); // NOI18N
        cbMaestria.setText("Si");

        txtAñoEgreso.setPlaceholder("Año de egreso");
        txtAñoEgreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAñoEgresoKeyTyped(evt);
            }
        });

        btnActualizarDL.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        btnActualizarDL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/icon/icons8-aprobar-y-actualizar-48.png"))); // NOI18N
        btnActualizarDL.setText("Actualizar datos");
        btnActualizarDL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tp_FormaciónAcadémicaLayout = new javax.swing.GroupLayout(tp_FormaciónAcadémica);
        tp_FormaciónAcadémica.setLayout(tp_FormaciónAcadémicaLayout);
        tp_FormaciónAcadémicaLayout.setHorizontalGroup(
            tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                        .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel55)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbNivelEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAñoEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMaestria)
                            .addComponent(cbPosgrado)
                            .addComponent(cbTitulo)
                            .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                                .addComponent(cbDoctorado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                .addComponent(btnActualizarDL, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        tp_FormaciónAcadémicaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbEstados, cmbNivelEstudios, txtAñoEgreso, txtCarrera, txtInstitucion});

        tp_FormaciónAcadémicaLayout.setVerticalGroup(
            tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbNivelEstudios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(20, 20, 20)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(21, 21, 21)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20)
                    .addComponent(txtAñoEgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel33)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel18))
                    .addGroup(tp_FormaciónAcadémicaLayout.createSequentialGroup()
                        .addComponent(cbTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbPosgrado)
                        .addGap(13, 13, 13)
                        .addComponent(cbMaestria)))
                .addGap(7, 7, 7)
                .addGroup(tp_FormaciónAcadémicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel55)
                    .addComponent(cbDoctorado)
                    .addComponent(btnActualizarDL, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        tp_FormaciónAcadémicaLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbEstados, cmbNivelEstudios, txtAñoEgreso, txtCarrera, txtInstitucion});

        getContentPane().add(tp_FormaciónAcadémica, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtAñoEgresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAñoEgresoKeyTyped
        Validaciones.esNumeroEntero(evt);
        Validaciones.revisarLongitud(evt, txtAñoEgreso, 4);
    }//GEN-LAST:event_txtAñoEgresoKeyTyped

    private void btnActualizarDLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDLActionPerformed
        updateFA();
    }//GEN-LAST:event_btnActualizarDLActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarDL;
    private javax.swing.JCheckBox cbDoctorado;
    private javax.swing.JCheckBox cbMaestria;
    private javax.swing.JCheckBox cbPosgrado;
    private javax.swing.JCheckBox cbTitulo;
    public javax.swing.JComboBox<String> cmbEstados;
    private javax.swing.JComboBox<String> cmbNivelEstudios;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel tp_FormaciónAcadémica;
    private com.swing.JCTextField txtAñoEgreso;
    private com.swing.JCTextField txtCarrera;
    private com.swing.JCTextField txtInstitucion;
    // End of variables declaration//GEN-END:variables
 private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
