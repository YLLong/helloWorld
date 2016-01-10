package com.memorandum;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by YLL on 2015/10/7.
 */
public class AllJPanel extends JPanel {
    public JTextField nameText;
    public JTextField typeText;
    public JTextField timeText;
    public JTextField titleText;
    public JTextArea contentText;
    public List<MemoBean> results;
    public int index = 0;
    public AllJPanel() {
//        setBounds(300, 200, 600, 400);

//        JPanel jp0 = new JPanel();//总面板（四个小面板容器）
//        add(jp0);
        this.setLayout(null);

        JPanel jp1 = new JPanel();
        jp1.setBounds(0, 0, 600, 50);
        jp1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));//设置面板边框
//        FlowLayout jp1_Layout = (FlowLayout)jp1.getLayout();//获得布局
//        jp1_Layout.setAlignment(FlowLayout.LEFT);//布局左对齐
        this.add(jp1);
        JLabel name_Label = new JLabel("姓名：");
        name_Label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jp1.add(name_Label);
        nameText = new JTextField();
        nameText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jp1.add(nameText);
        nameText.setColumns(6);
        JLabel type_Label = new JLabel("类型：");
        type_Label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jp1.add(type_Label);
        typeText = new JTextField();
        typeText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jp1.add(typeText);
        typeText.setColumns(6);
        JLabel time_Label = new JLabel("时间：");
        time_Label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jp1.add(time_Label);
        timeText = new JTextField();
        timeText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jp1.add(timeText);
        timeText.setColumns(6);

        JPanel jp2 = new JPanel();
        jp2.setBounds(0, 55, 600, 50);
        jp2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
//        FlowLayout jp2Layout = (FlowLayout)jp2.getLayout();
//        jp2Layout.setAlignment(FlowLayout.LEFT);
        this.add(jp2);
        JLabel title_Label = new JLabel("主题：");
        title_Label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jp2.add(title_Label);
        titleText = new JTextField();
        titleText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jp2.add(titleText);
        titleText.setColumns(28);

        JPanel jp3 = new JPanel();
        jp3.setBounds(0, 110, 600, 200);
        jp3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
//        FlowLayout jp3Layout = (FlowLayout)jp3.getLayout();
//        jp3Layout.setAlignment(FlowLayout.LEFT);
        this.add(jp3);
        JLabel content_Label = new JLabel("内容：");
        content_Label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jp3.add(content_Label);
        contentText = new JTextArea();
        contentText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        jp3.add(contentText);
        contentText.setColumns(30);
        contentText.setLineWrap(true);
        contentText.setRows(8);

        JScrollPane contentScrollpane = new JScrollPane(contentText);
        jp3.add(contentScrollpane);

//        JPanel jp4 = new JPanel();
//        jp4.setBounds(0, 315, 600, 50);
//        jp4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
//        this.add(jp4);
//        JButton saveButton = new JButton("保存");
//        saveButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
//        jp4.add(saveButton);
//        JButton clearButton = new JButton("清空");
//        clearButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
//        jp4.add(clearButton);
//        JButton returnButton = new JButton("返回");
//        returnButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
//        jp4.add(returnButton);


//        setVisible(true);
    }

}
