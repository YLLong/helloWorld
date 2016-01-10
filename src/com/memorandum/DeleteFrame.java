package com.memorandum;

import javax.swing.*;

/**
 * Created by YLL on 2015/10/7.
 */
public class DeleteFrame extends JFrame {
    DeleteJPanel deleteJPanel = new DeleteJPanel();
    public DeleteFrame() {
        super("删除备忘录");
        setBounds(300, 200, 600, 400);
        add(deleteJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
