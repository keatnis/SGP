/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.component;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

//
// Permite personalizar el encabezado de la tabla para definir el color que tendrá en las 
// columnas
// @author CHENAO
//
//
public class GestionEncabezadoTabla  implements TableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JComponent jcomponent = null;
        
        if( value instanceof String ) {
            jcomponent = new JLabel((String) value);
            ((JLabel)jcomponent).setHorizontalAlignment( SwingConstants.CENTER );
            ((JLabel)jcomponent).setSize( 30, jcomponent.getWidth() );   
            ((JLabel)jcomponent).setPreferredSize( new Dimension(20, jcomponent.getWidth())  );
        }         
   
        //jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(221, 211, 211)));
        jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));
        jcomponent.setOpaque(true);
        //jcomponent.setBackground( new Color(236,234,219) );
        jcomponent.setBackground( new Color(0, 51, 102) );
       // jcomponent.setToolTipText("Listado de Personal Activo");
        jcomponent.setForeground(Color.white);
        jcomponent.setFont(new Font("segoeui", 0, 14));
        
        
        return jcomponent;
    }
}