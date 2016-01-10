package com.memorandum;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by YLL on 2015/10/7.
 */
public class DeleteJPanel extends AllJPanel {
    public DeleteJPanel() {
        JPanel deletejp = new JPanel();
        deletejp.setBounds(0, 315, 600, 50);
        deletejp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        this.add(deletejp);
        JButton headButton = new JButton("上一条");
        headButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        deletejp.add(headButton);
        headButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_headButton_actionPerformed(e);
            }
        });
        JButton nextButton = new JButton("下一条");
        nextButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        deletejp.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_nextButton_actionPerformed(e);
            }
        });
        JButton deleteButton = new JButton("删除");
        deleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        deletejp.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_deleteButton_actionPerformed(e);
            }
        });
        JButton returnButton = new JButton("返回");
        returnButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        deletejp.add(returnButton);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JFrame) (getRootPane().getParent())).dispose();
            }
        });
        results = JdbcHelper.queryAll();
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
    //删除事件
    protected void do_deleteButton_actionPerformed(ActionEvent e) {
        JdbcHelper.delete(results.get(index));
        results.remove(index);
        if(index != 0) {
            index--;
        }if(results.size() == 0) {
            nameText.setText("");
            typeText.setText("");
            timeText.setText("");
            titleText.setText("");
            contentText.setText("");
            JOptionPane.showConfirmDialog(this, "备忘录为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            updateContent(index);
            JOptionPane.showConfirmDialog(this, "删除成功！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
    //填充备忘录信息
    public void updateContent(int index) {
        MemoBean memo = results.get(index);
        nameText.setText(memo.getUsername());
        typeText.setText(memo.getMemotype());
        timeText.setText(memo.getMemotime());
        titleText.setText(memo.getTitle());
        contentText.setText(memo.getContent());
    }
}
