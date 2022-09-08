/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.classes;
import com.component.Action;
import com.model.ModelPaseSalida;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer {

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
        
        if (value instanceof ModelPaseSalida) {
            ModelPaseSalida data = (ModelPaseSalida) value;
            Action cell = new Action(data);
            if (isSelected) {
                cell.setBackground(new Color(239, 244, 255));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
        //  else {
        //   Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
//                    setBorder(noFocusBorder);
//                    Component.setForeground(new Color(51, 51, 51));
//                    if (isSelected) {
//                       Component.setBackground(new Color(239, 244, 255));
//                    } else {
//                        Component.setBackground(Color.WHITE);
//                    }
//                    return Component;
//                }

        if (value instanceof JCheckBox) {
            JCheckBox ch = (JCheckBox) value;
            return ch;
        }

        return super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }

}
