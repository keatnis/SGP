package com.component;

import com.DAO.ListadoDAO;
import com.DAO.PersonalNDAO;
import com.classes.ExportarExcel;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class FixedColumnExample extends JPanel {
     
    Object[][] data;

    Object[] column;

    JTable fixedTable, table;
    ListadoDAO dao = new ListadoDAO();

    public FixedColumnExample() {
        setLayout(new java.awt.CardLayout());
        int numReg = dao.listPersonalCompleto().size();

        DefaultTableModel modeloTabla = new DefaultTableModel();
         column = new Object[]{"Núm. Emp", "Nombre (s)", "A. Patermo", "A. Materno","Status","Sexo","Fecha Nacimiento","Teléfono","Correo Personal","Correo Institucional","CURP","RFC","IMSS","Estado Civil","Lengua Indígena","Dirección","Contacto de emergencia","Tipo de Sangre","Plantel"," N/H","Código","Fecha de Ingreso","Fecha Termino Contrato","Jefe Inmediato ","Puesto","Adscripción","Categoría","Horas Laborales","Tipo Plaza","Sindicateo","Horario ","Monto Mensual","Nivel Estudio","Carrera","Institución","Estado","Año Egreso","Título","Posgrado","Maestría","Doctorado"};
         data= new Object[numReg][41];
         for (int i = 0; i < numReg; i++) {
         data[i][0]=dao.listPersonalCompleto().get(i).getNumEmpleado();
         data[i][1]=dao.listPersonalCompleto().get(i).getNombres();
         data[i][2]=dao.listPersonalCompleto().get(i).getApellidoP();
         data[i][3]=dao.listPersonalCompleto().get(i).getApellidoM();
         data[i][4]=dao.listPersonalCompleto().get(i).getStatus();
         data[i][5]=dao.listPersonalCompleto().get(i).getSexo();
         data[i][6]=dao.listPersonalCompleto().get(i).getFechaNacimiento();
         data[i][7]=dao.listPersonalCompleto().get(i).getTelefono();
         data[i][8]=dao.listPersonalCompleto().get(i).getCorreoPersonal();
         data[i][9]=dao.listPersonalCompleto().get(i).getCorreoInst();
         data[i][10]=dao.listPersonalCompleto().get(i).getCURP();
         data[i][11]=dao.listPersonalCompleto().get(i).getRFC();
         data[i][12]=dao.listPersonalCompleto().get(i).getIMSS();
         data[i][13]=dao.listPersonalCompleto().get(i).getEstadoCivil();
         data[i][14]=dao.listPersonalCompleto().get(i).getLenguaIndigena();
         data[i][15]=dao.listPersonalCompleto().get(i).getDirección();
         data[i][16]=dao.listPersonalCompleto().get(i).getTelefonoCE();
         data[i][17]=dao.listPersonalCompleto().get(i).getTipoSangre();
         
         data[i][18]=dao.listPersonalCompleto().get(i).getPlantel();
         data[i][19]=dao.listPersonalCompleto().get(i).getTipoContratacion();
         data[i][20]=dao.listPersonalCompleto().get(i).getCodigo();
         data[i][21]=dao.listPersonalCompleto().get(i).getFechaIngreso();
         data[i][22]=dao.listPersonalCompleto().get(i).getFechaTerminoCont();
         data[i][23]=dao.listPersonalCompleto().get(i).getJefeInmediato();
         data[i][24]=dao.listPersonalCompleto().get(i).getPuesto();
         data[i][25]=dao.listPersonalCompleto().get(i).getAreaAdscripción();
         data[i][26]=dao.listPersonalCompleto().get(i).getCategoria();
         data[i][27]=dao.listPersonalCompleto().get(i).getHorasLaborales();
         data[i][28]=dao.listPersonalCompleto().get(i).getTipoPlaza();
         data[i][29]=dao.listPersonalCompleto().get(i).getSindicato();
         data[i][30]=dao.listPersonalCompleto().get(i).getHorarioTrabajo();
         data[i][31]=dao.listPersonalCompleto().get(i).getSueldo();
         data[i][32]=dao.listPersonalCompleto().get(i).getNivelEstudios();
         data[i][33]=dao.listPersonalCompleto().get(i).getCarreraProfesional();
         data[i][34]=dao.listPersonalCompleto().get(i).getNombreInst();
         data[i][35]=dao.listPersonalCompleto().get(i).getEstado();
         data[i][36]=dao.listPersonalCompleto().get(i).getAnioEgreso();
         data[i][37]=dao.listPersonalCompleto().get(i).getConTitulo();
         data[i][38]=dao.listPersonalCompleto().get(i).getConPosgrado();
         data[i][39]=dao.listPersonalCompleto().get(i).getConMaestria();
         data[i][40]=dao.listPersonalCompleto().get(i).getConDoctorado();
         }      
            modeloTabla.addRow(data);
        
   
        AbstractTableModel fixedModel = new AbstractTableModel() {
            @Override
            public int getColumnCount() {
                return 4;
            }

            @Override
            public int getRowCount() {
                return data.length;
            }

            @Override
            public String getColumnName(int col) {
                return (String) column[col];
            }

            @Override
            public Object getValueAt(int row, int col) {
                return data[row][col];
            }
        };
        AbstractTableModel model = new AbstractTableModel() {
            @Override
            public int getColumnCount() {
                return column.length - 4;
            }

            @Override
            public int getRowCount() {
                return data.length;
            }

            @Override
            public String getColumnName(int col) {
                return (String) column[col + 4];
            }

            @Override
            public Object getValueAt(int row, int col) {
                return data[row][col + 4];
            }

            @Override
            public void setValueAt(Object obj, int row, int col) {
                data[row][col + 4] = obj;
            }

            public boolean CellEditable(int row, int col) {
                return true;
            }
        };

        fixedTable = new JTable(fixedModel) {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                super.valueChanged(e);
                checkSelection(true);
            }
        };
        table = new JTable(model) {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                super.valueChanged(e);
                checkSelection(false);
            }
        };
        fixedTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        fixedTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        

        table.setAutoCreateRowSorter(true);
        fixedTable.setAutoCreateRowSorter(true);
        JScrollPane scroll = new JScrollPane(table);
        JViewport viewport = new JViewport();
        viewport.setView(fixedTable);
        viewport.setPreferredSize(fixedTable.getPreferredSize());
        scroll.setRowHeaderView(viewport);
        scroll.setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedTable
                .getTableHeader());
        this.add(scroll);
      //  Listado lis= new Listado();
       // add(scroll, BorderLayout.CENTER);
    }
public void exportarExcel(){
      ExportarExcel ex= new ExportarExcel();
        try {
            ex.exportarExcel(fixedTable);
            
        } catch (IOException ex1) {
            JOptionPane.showMessageDialog(null, ex1.getMessage());
        }
}
public void exportarPDF(){
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Calendar cal = Calendar.getInstance();
      //  System.out.println(dateFormat.format(cal.getTime()));
        String reporte = JOptionPane.showInputDialog(null, "Escriba el tìtulo de la hoja");

        try {
            MessageFormat headerFormat = new MessageFormat("Reportes de " + reporte);

            MessageFormat footerFormat = new MessageFormat(dateFormat.format(cal.getTime()));

            fixedTable.print(JTable.PrintMode.FIT_WIDTH, headerFormat, footerFormat);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
}
    private void checkSelection(boolean isFixedTable) {
        int fixedSelectedIndex = fixedTable.getSelectedRow();
        int selectedIndex = table.getSelectedRow();
        if (fixedSelectedIndex != selectedIndex) {
            if (isFixedTable) {
                table.setRowSelectionInterval(fixedSelectedIndex,
                        fixedSelectedIndex);
            } else {
                fixedTable
                        .setRowSelectionInterval(selectedIndex, selectedIndex);
            }
        }
    }
}
