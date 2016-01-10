package com.YLLong_2.dao;

import com.YLLong_2.bean.GradeBean;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YLL on 2015/10/31.
 */
public class JdbcHelper implements JdbcConfig{
    //链接数据库
    public static Connection getconnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //显示所有学生成绩单
    public static List<GradeBean> queryAll() {
        String sql = "SELECT * from tb_transcript";
        List<GradeBean> results = new ArrayList<GradeBean>();
        Connection connection = getconnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                GradeBean gradeBean = new GradeBean();
                gradeBean.setId(resultSet.getInt("id"));
                gradeBean.setStuName(resultSet.getString("studentName"));
                gradeBean.setStuClass(resultSet.getString("studentClass"));
                gradeBean.setTestSubject(resultSet.getString("testSubject"));
                gradeBean.setScore(resultSet.getString("score"));
                gradeBean.setTestTime(resultSet.getString("testTime"));
                gradeBean.setRemark(resultSet.getString("remark"));
                results.add(gradeBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return results;
    }
    //查询显示结果 满足条件查询
    public static List<GradeBean> query(GradeBean grade) {
        String studentName = grade.getStuName();
        String studentClass = grade.getStuClass();
        String testSubject = grade.getTestSubject();
        String score = grade.getScore();
        String testTime = grade.getTestTime();
        String remark = grade.getRemark();
        StringBuilder sql = new StringBuilder("select * from tb_transcript where 1=1");
        if(!studentName.isEmpty()) {
            sql.append(" and studentName like '%"+ studentName + "%'");
        }
        if(!studentClass.isEmpty()) {
            sql.append(" and studentClass like '%"+ studentClass + "%'");
        }
        if(!testSubject.isEmpty()) {
            sql.append(" and testSubject like '%"+ testSubject + "%'");
        }
        if(!score.isEmpty()) {
            sql.append(" and score like '%"+ score + "%'");
        }
        if(!testTime.isEmpty()) {
            sql.append(" and testTime like '%"+ testTime + "%'");
        }
        if(!remark.isEmpty()) {
            sql.append(" and remark like '%"+ remark + "%'");
        }
        sql.append(";");
        List<GradeBean> results = new ArrayList<GradeBean>();
        Connection connection = getconnection();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement=connection.createStatement();
            resultSet = statement.executeQuery(sql.toString());
            while(resultSet.next()) {
                GradeBean gradeBean = new GradeBean();
                gradeBean.setId(resultSet.getInt("id"));
                gradeBean.setStuName(resultSet.getString("studentName"));
                gradeBean.setStuClass(resultSet.getString("studentClass"));
                gradeBean.setTestSubject(resultSet.getString("testSubject"));
                gradeBean.setScore(resultSet.getString("score"));
                gradeBean.setTestTime(resultSet.getString("testTime"));
                gradeBean.setRemark(resultSet.getString("remark"));
                results.add(gradeBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return results;
    }
    //保存学生成绩
    public static int save(GradeBean grade) {
        String sql = "insert into tb_transcript (studentName, " +
                "studentClass, testSubject, score, testTime, remark) values (?,?,?,?,?,?);";
        Connection connection= getconnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, grade.getStuName());
            preparedStatement.setString(2, grade.getStuClass());
            preparedStatement.setString(3, grade.getTestSubject());
            preparedStatement.setString(4, grade.getScore());
            preparedStatement.setString(5, grade.getTestTime());
            preparedStatement.setString(6, grade.getRemark());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }
    //修改学生成绩单信息
    public static int update(GradeBean grade) {
        String sql = "update tb_transcript set studentName = ?," +
                " studentClass = ?, testSubject = ?, score = ?, testTime = ?, remark = ?;";
        Connection connection = getconnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, grade.getStuName());
            preparedStatement.setString(2, grade.getStuClass());
            preparedStatement.setString(3, grade.getTestSubject());
            preparedStatement.setString(4, grade.getScore());
            preparedStatement.setString(5, grade.getTestTime());
            preparedStatement.setString(6, grade.getRemark());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(preparedStatement != null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }
    //删除选择中的成绩单
    public static int delet(GradeBean grade) {
        String sql = "delete from tb_transcript where id = " + grade.getId();
        Connection connection = getconnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }
}
