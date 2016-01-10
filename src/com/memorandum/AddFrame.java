package com.memorandum;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.Font;

/**
 * Created by YLL on 2015/10/6.
 */
public class AddFrame extends JFrame{
    AddJPanel addJPanel = new AddJPanel();
    public AddFrame() {
        super("增加备忘录");
        setBounds(300, 200, 600, 400);

        add(addJPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
