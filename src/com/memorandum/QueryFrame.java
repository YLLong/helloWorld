package com.memorandum;

import javax.swing.*;

/**
 * Created by YLL on 2015/10/7.
 */
public class QueryFrame extends JFrame {
    QueryJPanel queryJPanel = new QueryJPanel();
    public QueryFrame() {
        super("查询备忘录");
        setBounds(300, 200, 600, 400);
        add(queryJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
