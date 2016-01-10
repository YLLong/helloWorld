package com.memorandum;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by YLL on 2015/10/7.
 */
public class QueryJPanel extends AllJPanel {
    public QueryJPanel() {
        JPanel queryjp = new JPanel();
        queryjp.setBounds(0, 315, 600, 50);
        queryjp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        this.add(queryjp);
        JButton queryButton = new JButton("查询");
        queryButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        queryjp.add(queryButton);
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_queryButton_actionPerformed(e);
            }
        });
        JButton clearButton = new JButton("清空");
        clearButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        queryjp.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_clearButton_actionPerformed(e);
            }
        });
        JButton returnButton = new JButton("返回");
        returnButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        queryjp.add(returnButton);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JFrame) (getRootPane().getParent())).dispose();
            }
        });
    }

    //查询备忘录信息
    protected void do_queryButton_actionPerformed(ActionEvent e) {
        String name = nameText.getText().trim();
        String type = typeText.getText().trim();
        String time = timeText.getText().trim();
        String title = titleText.getText().trim();
        String content = contentText.getText().trim();
        if(name.isEmpty() && type.isEmpty() && time.isEmpty() && title.isEmpty() && content.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "查询条件不为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!time.isEmpty() && (!JdbcHelper.dataTimeFormat(time))) {
            JOptionPane.showConfirmDialog(this, "日期格式为2002-12-12样式！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MemoBean memo = new MemoBean();
        memo.setUsername(name);
        memo.setMemotype(type);
        memo.setMemotime(time);
        memo.setTitle(title);
        memo.setContent(content);
        results = JdbcHelper.query(memo);
        if(results.size() > 0) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    ResultFrame resultFrame = new ResultFrame(results);
                    resultFrame.setVisible(true);
                }
            });
            ((JFrame)(getRootPane().getParent())).dispose();
        }else {
            JOptionPane.showConfirmDialog(this, "没有符合条件的记录！");
            return;
        }
    }

    //清空备忘录
    public void do_clearButton_actionPerformed(ActionEvent e) {
        nameText.setText("");
        typeText.setText("");
        timeText.setText("");
        contentText.setText("");
        titleText.setText("");
    }
}