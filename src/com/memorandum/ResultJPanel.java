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
public class ResultJPanel extends AllJPanel {
    public ResultJPanel(List<MemoBean> results) {
        this.results = results;
//        System.out.println(results.size());
        JPanel resultjp = new JPanel();
        resultjp.setBounds(0, 315, 600, 50);
        resultjp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        this.add(resultjp);
        JButton headButton = new JButton("上一条");
        headButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        resultjp.add(headButton);
        headButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_headButton_actionPerformed(e);
            }
        });
        JButton nextButton = new JButton("下一条");
        nextButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        resultjp.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_nextButton_actionPerformed(e);
            }
        });
        JButton returnButton = new JButton("返回");
        returnButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        resultjp.add(returnButton);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JFrame) (getRootPane().getParent())).dispose();
            }
        });
        updateContent(index);
    }
    protected void do_headButton_actionPerformed(ActionEvent e) {
        if (index <= 0) {
            JOptionPane.showConfirmDialog(this, "已经是第一条记录！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        updateContent(--index);
    }

    protected void do_nextButton_actionPerformed(ActionEvent e) {
        if (index >= (results.size() - 1)) {
            JOptionPane.showConfirmDialog(this, "已经是最后一条记录！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        updateContent(++index);
    }
    //填充备忘录信息
    public void updateContent(int index) {
//        System.out.println(index);
        MemoBean memo = results.get(index);
        nameText.setText(memo.getUsername());
        typeText.setText(memo.getMemotype());
        timeText.setText(memo.getMemotime());
        titleText.setText(memo.getTitle());
        contentText.setText(memo.getContent());
    }
}
