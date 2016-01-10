package com.maze;

import javax.swing.*;
import javax.swing.Box;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by YLL on 2015/9/20.
 */
public class Login extends JFrame {

    private Box box1 = Box.createHorizontalBox();
    private Box box2 = Box.createHorizontalBox();
    private Box box3 = Box.createHorizontalBox();
    private Box box4 = Box.createHorizontalBox();
    private Box box5 = Box.createVerticalBox();

    private Icon image = null;
    private JLabel top =  new JLabel();
    private JLabel user = new JLabel("用户名：");
    private JLabel paw = new JLabel("密   码：");
    private JTextField usename = new JTextField(25);
    private JPasswordField paskey = new JPasswordField(25);
    private JButton entry = new JButton("登陆");
    private JButton cancel = new JButton("取消");

    public Login() {
        super("MAZE_GAME");
        setSize(400, 300);
        setLocation(200, 200);

        init();

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usename.setText("");
                paskey.setText("");
            }
        });

        entry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usertext = usename.getText();
                String key = String.valueOf(paskey.getPassword());

                if (usename != null && paskey != null && "admin".equals(usertext) && "123".equals(key)) {
                    int result = JOptionPane.showConfirmDialog(null, "输入正确，是否进入游戏", "提示", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if (result == 0) {
                        //游戏界面
                        new GameForm();
                    } else {
                        usename.setText("");
                        paskey.setText("");
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "输入错误，请重新输入", "提示", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    usename.setText("");
                    paskey.setText("");
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void init() {
        image = new ImageIcon(this.getClass().getResource("/com/maze/Photo/top.JPG"));
        top.setSize(100, 250);
        top.setIcon(image);
        box1.add(top);
        box2.add(Box.createHorizontalStrut(50));
        box2.add(user);
        box2.add(usename);
        box2.add(Box.createHorizontalStrut(50));
        box3.add(Box.createHorizontalStrut(50));
        box3.add(paw);
        box3.add(paskey);
        box3.add(Box.createHorizontalStrut(50));
        box4.add(entry);
        box4.add(Box.createHorizontalStrut(50));
        box4.add(cancel);
        box5.add(box1);
        box5.add(Box.createVerticalStrut(40));
        box5.add(box2);
        box5.add(Box.createVerticalStrut(40));
        box5.add(box3);
        box5.add(Box.createVerticalStrut(40));
        box5.add(box4);
        box5.add(Box.createVerticalStrut(40));
        this.add(box5);
    }
    public static void main(String[] args) {
        new Login();
    }
}
