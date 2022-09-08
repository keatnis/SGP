package com.swing;

import com.DAO.BajaPersonalDAO;
import com.component.GestionEncabezadoTabla;
import com.model.ModelBajaPersonal;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.table.JTableHeader;

public class Tabla_pdf_Baja {

    BajaPersonalDAO dao = null;

    public void visualizar_PdfVO(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());

        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("ID");
        dt.addColumn("Num. Emp");
        dt.addColumn("Nombre Completo");
        dt.addColumn("Motivo de Salida");
        dt.addColumn("Fecha de Baja");
        dt.addColumn("Notas");
        dt.addColumn("Archivo");
   

        ImageIcon icono = null;
        if (get_Image("/com/icon/pdf30.png") != null) {
            icono = new ImageIcon(get_Image("/com/icon/pdf30.png"));
        }

        dao = new BajaPersonalDAO();
        ModelBajaPersonal vo = new ModelBajaPersonal();
        ArrayList<ModelBajaPersonal> list = dao.Listar_PdfVO();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[7];
                vo = list.get(i);
                fila[0] = vo.getIdBaja();
                fila[1] = vo.getNumEmp();
                fila[2] = vo.getNombreEmp();
                fila[3] = vo.getMotivoSalida();
                fila[4] = vo.getFecha();
                fila[5] = vo.getNotas();

                if (vo.getArchivo() != null) {
                    fila[6] = new JButton(icono);
                } else {
                    fila[6] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(32);
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
}
