package com.memorandum;

import javax.swing.*;
import java.awt.*;

/**
 * Created by YLL on 2015/10/6.
 */
public class MainJPanel extends JPanel {
    public MainJPanel() {
        setBackground(Color.GRAY);
        setVisible(true);
//        Graphics g  = this.getGraphics();
//        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        String str = "备忘录模块";
        Font font = new Font("隶书", Font.BOLD | Font.ITALIC, 40);
        g2.setFont(font);
        for(int i = 0; i < str.length(); i++) {
            g2.setColor(Color.ORANGE);
            g2.drawString(str.charAt(i) + "", 100 + i * font.getSize(), 100 + i * font.getSize());
            g2.drawString(str.charAt(i) + "", 420 - i * font.getSize(), 100 + i * font.getSize());
        }
        for(int i = 0; i < str.length(); i++) {
            g2.setColor(Color.orange);
            g2.drawString(str.charAt(i) + "", 110 + i * font.getSize(), 110 + i * font.getSize());
            g2.drawString(str.charAt(i) + "", 430 - i * font.getSize(), 110 + i * font.getSize());
        }
    }
}
