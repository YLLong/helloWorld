package com.YLLong_2.frame;

import com.YLLong_2.bean.GradeBean;
import com.YLLong_2.dao.JdbcHelper;
import com.YLLong_2.util.ValidationUtil;
import com.YLLong_2.util.WindowUtil;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

/**
 * Created by YLL on 2015/11/2.
 */
public class QueryGradeBeanFrame extends JFrame{
    private JPanel contentPane;
    private JPanel studentInfoPanel;
    private JLabel stuName_label;
    private JTextField stuName_text;
    private JLabel stuClass_label;
    private JTextField stuClass_text;
    private JPanel gradeInfoPanel;
    private JLabel testSubject_label;
    private JTextField testSubject_text;
    private JLabel score_label;
    private JTextField score_text;
    private JLabel testTime_label;
    private JTextField testTime_text;
    private JPanel remarkPanel;
    private JLabel remark_label;
    private JTextArea remark_text;
    private JPanel buttonsPanel;
    private JButton queryButton;
    private JButton clearButton;
    private JButton returnButton;
    public QueryGradeBeanFrame() {
        super("查询成绩单");
        setLocation(WindowUtil.getLocation());
        setSize(WindowUtil.getsize());
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setLayout(null);
        add(contentPane);

        studentInfoPanel = new JPanel();
//        FlowLayout flowLayout = (FlowLayout)studentInfoPanel.getLayout();
//        flowLayout.setAlignment(FlowLayout.LEFT);
        studentInfoPanel.setBackground(Color.LIGHT_GRAY);
        studentInfoPanel.setBounds(0, 0, 484, 45);
        studentInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        contentPane.add(studentInfoPanel);

        stuName_label = new JLabel("学生姓名：");
        stuName_label.setFont(new Font("微软雅黑", Font.BOLD, 15));
        studentInfoPanel.add(stuName_label);
        stuName_text = new JTextField();
        stuName_text.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        studentInfoPanel.add(stuName_text);
        stuName_text.setColumns(10);
        stuClass_label = new JLabel("学生班级：");
        stuClass_label.setFont(new Font("微软雅黑", Font.BOLD, 15));
        studentInfoPanel.add(stuClass_label);
        stuClass_text = new JTextField();
        stuClass_text.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        studentInfoPanel.add(stuClass_text);
        stuClass_text.setColumns(10);

        gradeInfoPanel = new JPanel();
        gradeInfoPanel.setBackground(Color.LIGHT_GRAY);
        gradeInfoPanel.setBounds(0, 57, 484, 75);
        gradeInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        contentPane.add(gradeInfoPanel);

        testSubject_label = new JLabel("考试科目：");
        testSubject_label.setFont(new Font("微软雅黑", Font.BOLD, 15));
        gradeInfoPanel.add(testSubject_label);
        testSubject_text = new JTextField();
        testSubject_text.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        gradeInfoPanel.add(testSubject_text);
        testSubject_text.setColumns(10);
        score_label = new JLabel("考试成绩：");
        score_label.setFont(new Font("微软雅黑", Font.BOLD, 15));
        gradeInfoPanel.add(score_label);
        score_text = new JTextField();
        score_text.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        gradeInfoPanel.add(score_text);
        score_text.setColumns(10);
        testTime_label = new JLabel("考试时间：");
        testTime_label.setFont(new Font("微软雅黑", Font.BOLD, 15));
        gradeInfoPanel.add(testTime_label);
        testTime_text = new JTextField();
        testTime_text.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        gradeInfoPanel.add(testTime_text);
        testTime_text.setColumns(10);

        remarkPanel = new JPanel();
        remarkPanel.setBackground(Color.LIGHT_GRAY);
        remarkPanel.setBounds(0, 144, 484, 60);
        remarkPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        contentPane.add(remarkPanel);

        remark_label = new JLabel("备注：");
        remark_label.setFont(new Font("微软雅黑", Font.BOLD, 15));
        remarkPanel.add(remark_label);
        remark_text = new JTextArea();
        remark_text.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        remarkPanel.add(remark_text);
        remark_text.setColumns(20);
        remark_text.setRows(2);

        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.setBounds(0, 215, 484, 46);
        buttonsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        contentPane.add(buttonsPanel);

        queryButton = new JButton("查询");
        queryButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        buttonsPanel.add(queryButton);
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_queryButton_actionPerformed(e);
            }
        });
        clearButton = new JButton("清空");
        clearButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        buttonsPanel.add(clearButton);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_clearButton_actionPerformed(e);
            }
        });
        returnButton = new JButton("返回");
        returnButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        buttonsPanel.add(returnButton);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_returnButton_actionPerformed(e);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //处理查询按钮事件
    public void do_queryButton_actionPerformed(ActionEvent e) {
        String studentName = stuName_text.getText().trim();
        String studentClass = stuClass_text.getText().trim();
        String testSubject = testSubject_text.getText().trim();
        String score = score_text.getText().trim();
        String testTime = testTime_text.getText().trim();
        String remark = remark_text.getText().trim();
        if(studentName.isEmpty() && studentClass.isEmpty() && testSubject.isEmpty() && score.isEmpty() && testTime.isEmpty() && remark.isEmpty()) {
            JOptionPane.showConfirmDialog(this, "查询条件不能为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!studentClass.isEmpty() && !ValidationUtil.validationStuClassFormat(studentClass)) {
            JOptionPane.showConfirmDialog(this, "学生班级为0123样式！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!score.isEmpty() && !ValidationUtil.validationScoreFormat(score)) {
            JOptionPane.showConfirmDialog(this, "考试成绩为88样式！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(!testTime.isEmpty() && ValidationUtil.validationTestTimeFormat(testTime)) {
            JOptionPane.showConfirmDialog(this, "考试时间为2012-10-10样式！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        GradeBean grade = new GradeBean();
        grade.setStuName(studentName);
        grade.setStuClass(studentClass);
        grade.setTestSubject(testSubject);
        grade.setScore(score);
        grade.setTestTime(testTime);
        grade.setRemark(remark);
        final List<GradeBean> results = JdbcHelper.query(grade);
        if(results.size() > 0) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new DisplayGradeBeanFrame(results);
                }
            });
        }else {
            JOptionPane.showConfirmDialog(this, "无条件查询,不成功！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
    //处理清空按钮事件
    public void do_clearButton_actionPerformed(ActionEvent e) {
        stuName_text.setText("");
        stuClass_text.setText("");
        testSubject_text.setText("");
        score_text.setText("");
        testTime_text.setText("");
        remark_text.setText("");
    }
    //处理返回按钮事件
    public void do_returnButton_actionPerformed(ActionEvent e) {
        dispose();
    }
}
