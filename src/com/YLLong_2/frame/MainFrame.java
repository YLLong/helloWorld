package com.YLLong_2.frame;

import com.YLLong_2.util.WindowUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by YLL on 2015/11/2.
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        super("学生成绩管理系统");
        setLocation(WindowUtil.getLocation());
        setSize(WindowUtil.getsize());
        JPanel jPanel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                setBackground(Color.LIGHT_GRAY);
                Graphics2D g2 = (Graphics2D) g;
                g2.setFont(new Font("华文行楷", Font.HANGING_BASELINE, 56));
                g2.shear(0.1 , -0.4);
                g2.drawString("学生成绩管理模块", -15, 230);
            }
        };

        JMenuBar jmenuBar = new JMenuBar();
        setJMenuBar(jmenuBar);
        JMenu grade_manage = new JMenu("成绩单管理");
        grade_manage.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jmenuBar.add(grade_manage);
        JMenuItem add_menu = new JMenuItem("添加成绩单");
        add_menu.setFont(new Font("微软雅黑", Font.BOLD, 15));
        grade_manage.add(add_menu);
        add_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new AddGradeBeanFrame();
                    }
                });
            }
        });
        JMenuItem display_menu = new JMenuItem("显示成绩单");
        display_menu.setFont(new Font("微软雅黑", Font.BOLD, 15));
        grade_manage.add(display_menu);
        display_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new DisplayGradeBeanFrame();
                    }
                });
            }
        });
        JMenuItem delete_menu = new JMenuItem("查询成绩单");
        delete_menu.setFont(new Font("微软雅黑", Font.BOLD, 15));
        grade_manage.add(delete_menu);
        delete_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new QueryGradeBeanFrame();
                    }
                });
            }
        });

        JMenu tool_menu = new JMenu("小工具");
        tool_menu.setFont(new Font("微软雅黑", Font.BOLD, 15));
        jmenuBar.add(tool_menu);
        JMenuItem notepad_menu = new JMenuItem("记事本");
        notepad_menu.setFont(new Font("微软雅黑", Font.BOLD, 15));
        tool_menu.add(notepad_menu);
        notepad_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec("notepad");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JMenuItem calculator_menu = new JMenuItem("计算器");
        calculator_menu.setFont(new Font("微软雅黑", Font.BOLD, 15));
        tool_menu.add(calculator_menu);
        calculator_menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec("calc");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        add(jPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MainFrame();
    }
}
