package com.GUI.yll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * Created by YLL on 2015/9/9.
 */
public class GUI1 extends Frame {
    private BorderLayout borderLayout1 = new BorderLayout();
    private JPanel jPanel1 = new JPanel();
    private JLabel jLabel1 = new JLabel();
    private JTextField jTextField1 = new JTextField();
    private JLabel jLabel2 = new JLabel();
    private JTextField jTextField2 = new JTextField();
    private JButton jButton1 = new JButton();
    private JButton jButton2 = new JButton();
    private FlowLayout flowLayout1 = new FlowLayout();
    public GUI1() {
        try {
            Init();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    private void Init() throws Exception {
        JFrame jFrame = new JFrame();
        jFrame.getContentPane().setLayout(borderLayout1);
        jLabel2.setToolTipText("");
        jLabel2.setText("保存文件");
        jButton1.setText("....");
        jButton2.setToolTipText("");
        jButton2.setText("....");
        jTextField1.setPreferredSize(new Dimension(204,22));
        jTextField1.setToolTipText("");
        jTextField2.setPreferredSize(new Dimension(204,22));
        jLabel1.setToolTipText("");
        this.setTitle("文件选择器（JFileChooser）");
        jPanel1.setPreferredSize(new Dimension(339,138));
        jFrame.getContentPane().add(jPanel1, BorderLayout.CENTER);
        jPanel1.add(jLabel1,null);
        jPanel1.add(jTextField1,null);
        jPanel1.add(jButton1,null);
        jPanel1.add(jLabel2,null);
        jPanel1.add(jTextField2,null);
        jPanel1.add(jButton2,null);
        jLabel1.setText("打开文件");
        jPanel1.setLayout(flowLayout1);
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openfile();
            }
        });
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                savefile();
            }
        });
    }
    void openfile() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("选择文件演示");
        fc.setDialogType(JFileChooser.CUSTOM_DIALOG);
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.jTextField1.setText(fc.getSelectedFile().toString());
            this.jTextField2.setText(fc.getSelectedFile().toString());
        }
    }
    void savefile() {
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("保存文件演示");
        fc.setDialogType(JFileChooser.SAVE_DIALOG);
        File fl = new File(jTextField1.getText());
        fc.setCurrentDirectory(fl);
        fc.setControlButtonsAreShown(true);
        fc.setSelectedFile(fl);
        if(fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        }
    }
    public static void main(String[] args) {
        GUI1 frame = new GUI1();
        frame.pack();
        frame.setVisible(true);
        System.out.print("1223");
    }
}
