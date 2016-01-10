package com.memorandum;

import javax.swing.*;
import java.util.List;

/**
 * Created by YLL on 2015/10/7.
 */
public class ResultFrame extends JFrame {
//    ResultJPanel resultJPanel ;
    public ResultFrame() {}
    public ResultFrame(List<MemoBean> results) {
        super("查询结果");
        ResultJPanel resultJPanel = new ResultJPanel(results);
//        System.out.println(results.size());
//       this.resultJPanel.results = results;
//        resultJPanel = new ResultJPanel();
        setBounds(300, 200, 600, 400);
        add(resultJPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
