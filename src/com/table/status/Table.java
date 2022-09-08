package com.table.status;

import com.component.TableHeader;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class Table extends JTable {

    private BufferedImage imageShadow;

    public Table() {
        // resizeColumnWidth(this);
        // setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader h = new TableHeader(o + "");
                if (i1 == 0 || i1 == 11) {
                    h.setHorizontalAlignment(JLabel.CENTER);
                    setHorizontalAlignment(SwingConstants.CENTER);

                }
                return h;
            }
        });

    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int space = 12;
        int margin = space / 2;
        for (int i = 0; i < getRowCount(); i++) {
            int row = i;
            Rectangle r = getCellRect(row, 0, true);
            if (isRowSelected(i)) {
                g2.setColor(new Color(17, 164, 232));
                g2.drawRect(margin, r.getLocation().y + margin, getWidth() - margin * 2, rowHeight - space);
            }
            //     g2.drawImage(imageShadow, 0, r.getLocation().y, null);
//            g2.setColor(new Color(0, 102, 204));
//            g2.fillRect(margin, r.getLocation().y + margin, 3, rowHeight - space);
        }
        g2.dispose();
    }

    @Override
    public Component prepareRenderer(TableCellRenderer tcr, int i, int i1) {

        if (i1 == 10) {
            TableCell_Status cell = new TableCell_Status(getValueAt(i, 10).toString());
            return cell;
        } else {
            String values = "";
            if (getValueAt(i, i1) != null) {
                values = getValueAt(i, i1).toString();
                // getColumnModel().getColumn(0).setCellRenderer(tcr);
            }
            TableCell cell = new TableCell(values);
            return cell;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setBorder(null);
        scroll.getViewport().setBackground(new Color(250, 250, 250));
        JScrollBar sb = new JScrollBar();
        sb.setBackground(new Color(250, 250, 250));
        scroll.setVerticalScrollBar(sb);
        JPanel p = new JPanel();
      //  p.setBackground(new Color(250, 250, 250));
           p.setBackground(getBackground());
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);

    }
}
