package com.memorandum;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by YLL on 2015/10/7.
 */
public class ReviseJPanel extends AllJPanel {
    private int index;
    public ReviseJPanel() {
        JPanel revisejp = new JPanel();
        revisejp.setBounds(0, 315, 600, 50);
        revisejp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        this.add(revisejp);
        JButton headButton = new JButton("上一条");
        headButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        revisejp.add(headButton);
        headButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_headButton_actionPerformed(e);
            }
        });
        JButton nextButton = new JButton("下一条");
        nextButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        revisejp.add(nextButton);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_nextButton_actionPerformed(e);
            }
        });
        JButton reviseButton = new JButton("修改");
        reviseButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        revisejp.add(reviseButton);
        reviseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_reviseButton_Performed(e);
            }
        });
        JButton clearButton = new JButton("清空");
        clearButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        revisejp.add(clearButton);
        JButton returnButton = new JButton("返回");
        returnButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        revisejp.add(returnButton);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JFrame) (getRootPane().getParent())).dispose();
            }
        });
        results = JdbcHelper.queryAll();
        updateContent(index);
    }


    //修改（index）


    protected void do_headButton_actionPerformed(ActionEvent e) {
        if (index <= 0) {
            JOptionPane.showConfirmDialog(this, "已经是第一条记录！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        updateContent(--index);
    }

    protected void do_nextButton_actionPerformed(ActionEvent e) {
        if (index >= (JdbcHelper.queryAll().size() - 1)) {
            JOptionPane.showConfirmDialog(this, "已经是最后一条记录！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        updateContent(++index);
    }

    //修改备忘录
    protected void do_reviseButton_Performed(ActionEvent e) {
        String username = nameText.getText().trim();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "姓名不能为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String title = titleText.getText().trim();
        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(this, "主题不能为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String content = contentText.getText().trim();
        if (content.isEmpty()) {
            JOptionPane.showMessageDialog(this, "内容不能为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String type = typeText.getText().trim();
        if (type.isEmpty()) {
            JOptionPane.showMessageDialog(this, "类型不能为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String time = timeText.getText().trim();
        if (time.isEmpty()) {
            JOptionPane.showMessageDialog(this, "时间不能为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!JdbcHelper.dataTimeFormat(time)) {
            JOptionPane.showConfirmDialog(this, "日期格式为：2002-10-12样式！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MemoBean memo = results.get(index);
        memo.setUsername(username);
        memo.setMemotype(type);
        memo.setMemotime(time);
        memo.setTitle(title);
        memo.setContent(content);
        int result = JdbcHelper.update(memo);
//        System.out.println(result);
        if (result >= 0) {
            JOptionPane.showConfirmDialog(this, "备忘录修改成功！");
            return;
        } else {
            JOptionPane.showConfirmDialog(this, "备忘录修改失败！");
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