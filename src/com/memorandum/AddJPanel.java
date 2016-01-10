package com.memorandum;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by YLL on 2015/10/7.
 */
public class AddJPanel extends AllJPanel {
    public AddJPanel() {
        JPanel addjp = new JPanel();
        addjp.setBounds(0, 315, 600, 50);
        addjp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        this.add(addjp);
        JButton saveButton = new JButton("保存");
        saveButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        addjp.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_savaButton_actionPerformed(e);
            }
        });
        JButton clearButton = new JButton("清空");
        clearButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        addjp.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_clearButton_actionPerformed(e);
            }
        });
        JButton returnButton = new JButton("返回");
        returnButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        addjp.add(returnButton);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JFrame)(getRootPane().getParent())).dispose();
            }
        });
    }
    //保存备忘录信息
    public void do_savaButton_actionPerformed(ActionEvent e) {
        String username =nameText.getText().trim();
        if(username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "姓名不能为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String title = titleText.getText().trim();
        if(title.isEmpty()) {
            JOptionPane.showMessageDialog(this, "主题不能为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String content = contentText.getText().trim();
        if(content.isEmpty()) {
            JOptionPane.showMessageDialog(this, "内容不能为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String type = typeText.getText().trim();
        if(type.isEmpty()) {
            JOptionPane.showMessageDialog(this, "类型不能为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String time = timeText.getText().trim();
        if(time.isEmpty()) {
            JOptionPane.showMessageDialog(this, "时间不能为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!JdbcHelper.dataTimeFormat(time)) {
            JOptionPane.showConfirmDialog(this, "日期格式为：2002-10-12样式！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MemoBean memo = new MemoBean();
        memo.setUsername(username);
        memo.setMemotype(type);
        memo.setMemotime(time);
        memo.setTitle(title);
        memo.setContent(content);
        int result = JdbcHelper.save(memo);
        if(result >= 0) {
            JOptionPane.showConfirmDialog(this, "备忘录添加成功！");
            return;
        }else {
            JOptionPane.showConfirmDialog(this, "备忘录添加失败！");
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