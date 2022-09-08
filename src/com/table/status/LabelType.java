package com.table.status;


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class LabelType extends JLabel {

    public LabelType() {
        setForeground(Color.WHITE);
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
       if (getText().equals("Nómina")) {
            g2.setColor(new Color( 30, 132, 73 ));
        } else {
            g2.setColor(new Color(241, 196, 15));
        }
        int x[] = {5, getWidth(), getWidth() - 5, 0};
        int y[] = {0, 0, getHeight(), getHeight()};
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
        g2.fillPolygon(x, y, x.length);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        super.paintComponent(grphcs);
    }
}
