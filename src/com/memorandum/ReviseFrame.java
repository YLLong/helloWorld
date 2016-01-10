package com.memorandum;

import javax.swing.*;

/**
 * Created by YLL on 2015/10/7.
 */
public class ReviseFrame extends JFrame {
    ReviseJPanel reviseJPanel = new ReviseJPanel();
    public ReviseFrame() {
        super("修改备忘录");
        setBounds(300, 200, 600, 400);
        add(reviseJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
