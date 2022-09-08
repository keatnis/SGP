package com.table.status;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class Tabla2 extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        if (value instanceof JButton) {
            JButton btn = (JButton) value;
            if (isSelected) {
                btn.setForeground(table.getSelectionForeground());
                btn.setBackground(table.getSelectionBackground());
            } else {
                btn.setForeground(table.getForeground());
                btn.setBackground(UIManager.getColor("Button.background"));
            }
            return btn;
        }
           
        if (value instanceof JLabel) {
            JLabel btn = (JLabel) value;
            if(value.equals("CVencido")){
                setBackground(new Color(243, 135, 21));
                setForeground(Color.WHITE);
            }
            if (isSelected) {
                btn.setForeground(table.getSelectionForeground());
                btn.setBackground(table.getSelectionBackground());
            } else {
                btn.setForeground(table.getForeground());
                btn.setBackground(UIManager.getColor("Button.background"));
            }
            return btn;
        }
//       String numero = (String) table.getValueAt(row, 7);
//         if (numero.equals("CVencido")){
//             this.setBackground(new Color(243, 135, 21));
//             setForeground(Color.WHITE);
//        }
//        if (table.getValueAt(row, 10).equals("CVencido")) {
//            this.setBackground(new Color(243, 135, 21));
//            setForeground(Color.WHITE);
//
//        }

        if (column == 10) {
            TableCell_Status cell = new TableCell_Status(table.getValueAt(row, 10).toString());
            return cell;
        }

        return super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.

    }
}
