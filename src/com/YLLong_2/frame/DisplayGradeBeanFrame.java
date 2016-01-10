package com.YLLong_2.frame;

import com.YLLong_2.bean.GradeBean;
import com.YLLong_2.dao.JdbcHelper;
import com.YLLong_2.util.WindowUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


/**
 * Created by YLL on 2015/11/2.
 */
public class DisplayGradeBeanFrame extends JFrame {
    private JTable studentGradeTable;
    private JPanel buttonsPanel;
    private JButton modifyButton;
    private JButton deletButton;
    private JButton returnButton;
    public DisplayGradeBeanFrame() {
        super("现有学生成绩单");
        setLocation(WindowUtil.getLocation());
        setSize(WindowUtil.getsize());
        JPanel contentPane = new JPanel();
        add(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        JScrollPane jScrollPane = new JScrollPane();
        contentPane.add(jScrollPane, BorderLayout.CENTER);
        studentGradeTable = new JTable();
        studentGradeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentGradeTable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        studentGradeTable.setRowHeight(30);
        JTableHeader header = studentGradeTable.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        header.setFont(new Font("微软雅黑", Font.BOLD, 15));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)header.getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableModel tableModel = (DefaultTableModel)studentGradeTable.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[]{"编号", "学生姓名", "学生班级", "考试科目", "考试成绩", "考试时间", "备注"});
        List<GradeBean> results = JdbcHelper.queryAll();
        for(GradeBean grade : results) {
            tableModel.addRow(new Object[]{grade.getId(), grade.getStuName(), grade.getStuClass(), grade.getTestSubject(), grade.getScore(), grade.getTestTime(), grade.getRemark()});
        }
        studentGradeTable.setModel(tableModel);
        jScrollPane.setViewportView(studentGradeTable);

        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        contentPane.add(buttonsPanel, BorderLayout.SOUTH);
        modifyButton = new JButton("修改");
        modifyButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        buttonsPanel.add(modifyButton);
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_modifyButton_actionPerformed(e);
            }
        });
        deletButton = new JButton("删除");
        deletButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        buttonsPanel.add(deletButton);
        deletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_deletButton_actionPerformed(e);
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

    public DisplayGradeBeanFrame(List<GradeBean> results) {
        super("查询结果");
        setLocation(WindowUtil.getLocation());
        setSize(WindowUtil.getsize());
        JPanel contentPane = new JPanel();
        add(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        JScrollPane jScrollPane = new JScrollPane();
        contentPane.add(jScrollPane, BorderLayout.CENTER);
        studentGradeTable = new JTable();
//        studentGradeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentGradeTable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        studentGradeTable.setRowHeight(30);
        JTableHeader header = studentGradeTable.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        header.setFont(new Font("微软雅黑", Font.BOLD, 15));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)header.getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableModel tableModel = (DefaultTableModel)studentGradeTable.getModel();
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[]{"编号", "学生姓名", "学生班级", "考试科目", "考试成绩", "考试时间", "备注"});
        for(GradeBean temgrade : results) {
            tableModel.addRow(new Object[]{temgrade.getId(), temgrade.getStuName(), temgrade.getStuClass(), temgrade.getTestSubject(), temgrade.getScore(), temgrade.getTestTime(), temgrade.getRemark()});
        }
        studentGradeTable.setModel(tableModel);
        jScrollPane.setViewportView(studentGradeTable);

        buttonsPanel = new JPanel();
        contentPane.add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        modifyButton = new JButton("修改");
        modifyButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        buttonsPanel.add(modifyButton);
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_modifyButton_actionPerformed(e);
            }
        });
        deletButton = new JButton("删除");
        deletButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        buttonsPanel.add(deletButton);
        deletButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_deletButton_actionPerformed(e);
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

    //处理修改按钮事件
    public void do_modifyButton_actionPerformed(ActionEvent e) {
        int selectRow = studentGradeTable.getSelectedRow();
        if(selectRow < 0) {
            JOptionPane.showConfirmDialog(this, "请选择需要修改的行！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            final GradeBean grade = new GradeBean();
            grade.setId((Integer)studentGradeTable.getValueAt(selectRow, 0));
            grade.setStuName((String) studentGradeTable.getValueAt(selectRow, 1));
            grade.setStuClass((String) studentGradeTable.getValueAt(selectRow, 2));
            grade.setTestSubject((String) studentGradeTable.getValueAt(selectRow, 3));
            grade.setScore((String) studentGradeTable.getValueAt(selectRow, 4));
            grade.setTestTime((String) studentGradeTable.getValueAt(selectRow, 5));
            grade.setRemark((String) studentGradeTable.getValueAt(selectRow, 6));
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ModifyGradeBeanFrame(studentGradeTable, grade);
                }
            });
        }
    }
    //处理删除按钮事件
    public void do_deletButton_actionPerformed(ActionEvent e) {
        int selectRow = studentGradeTable.getSelectedRow();
        if(selectRow < 0) {
            JOptionPane.showConfirmDialog(this, "请选择需要删除的行！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }else {
            GradeBean grade = new GradeBean();
            grade.setId((Integer) studentGradeTable.getValueAt(selectRow, 0));
            JdbcHelper.delet(grade);
            DefaultTableModel tableModel = (DefaultTableModel)studentGradeTable.getModel();
            tableModel.setRowCount(0);
            tableModel.setColumnIdentifiers(new Object[]{"编号", "学生姓名", "学生班级", "考试科目", "考试成绩", "考试时间", "备注"});
            List<GradeBean> results = JdbcHelper.queryAll();
            for(GradeBean temgrade : results) {
                tableModel.addRow(new Object[]{temgrade.getId(), temgrade.getStuName(), temgrade.getStuClass(), temgrade.getTestSubject(), temgrade.getScore(), temgrade.getTestTime(), temgrade.getRemark()});
            }
            studentGradeTable.setModel(tableModel);
        }
    }


    //处理返回按钮事件
    public void do_returnButton_actionPerformed(ActionEvent e) {
        dispose();
    }
}
