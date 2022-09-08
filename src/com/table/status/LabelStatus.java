package com.table.status;

import com.swing.*;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class LabelStatus extends JLabel {

    public LabelStatus() {
        setForeground(new Color(51,51,51));
       setBorder(new EmptyBorder(2, 10, 2, 10));
        setHorizontalAlignment(JLabel.CENTER);
       
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        if (getText().equals("1")) {
//            g2.setColor(new Color(253, 187, 65));
//        } 
       
if (getText().equals("Activo")) {
            g2.setColor(new Color(59, 211, 160));
        } else if(getText().equals("Inactivo")){
            g2.setColor(new Color(240, 81, 81));
        }
      
       g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2.fillOval(15, 15, 15,15);
      //  g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
        super.paintComponent(grphcs);
    }
}
