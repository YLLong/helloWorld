package com.memorandum;


import javax.swing.*;
import javax.swing.text.AttributeSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by YLL on 2015/10/5.
 */
public class MainWnd extends JFrame{
    MainJPanel jPanel = new MainJPanel();
    public MainWnd() {
        this.setTitle("备忘录模块");
        this.setBounds(300, 200, 600, 400);
        this.add(jPanel);
        //菜单栏
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu memoManagementMenu = new JMenu("备忘录管理");
        memoManagementMenu.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        menuBar.add(memoManagementMenu);
        JMenu toolMenu =new JMenu("小工具");
        toolMenu.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        menuBar.add(toolMenu);
        //备忘录管理下的菜单栏
        JMenuItem addMemoMenuItem = new JMenuItem("添加备忘录");
        addMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        memoManagementMenu.add(addMemoMenuItem);
        addMemoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFrame addFrame=new AddFrame();
            }
        });
        JMenuItem modifyMemoMenuItem = new JMenuItem("修改备忘录");
        modifyMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        memoManagementMenu.add(modifyMemoMenuItem);
        modifyMemoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReviseFrame reviseFrame = new ReviseFrame();
            }
        });
        JMenuItem queryMemoMenuItem = new JMenuItem("查询备忘录");
        queryMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        memoManagementMenu.add(queryMemoMenuItem);
        queryMemoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QueryFrame queryFrame = new QueryFrame();
            }
        });
        JMenuItem deleteMemoMenuItem = new JMenuItem("删除备忘录");
        deleteMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        memoManagementMenu.add(deleteMemoMenuItem);
        deleteMemoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteFrame deleteFrame = new DeleteFrame();
            }
        });
        //小工具下的菜单栏
        JMenuItem notepadMenuItem = new JMenuItem("记事本");
        notepadMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        toolMenu.add(notepadMenuItem);
        notepadMenuItem.addActionListener(new ActionListener() {

            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
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
        JMenuItem calculatorMenuItem = new JMenuItem("计算器");
        calculatorMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        toolMenu.add(calculatorMenuItem);
        calculatorMenuItem.addActionListener(new ActionListener() {
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

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new MainWnd();
    }
}
