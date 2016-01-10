package com.memorandum;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by YLL on 2015/10/7.
 */
public class JdbcHelper {
    //数据库连接
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String DRIVER = "com.mysql.jdbc.Driver";
            String URL = "jdbc:mysql://localhost:3306/db_memomodule";
            String USERNAME = "root";
            String PASSWORD = "yll106";
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            return connection;
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //数据保存
    public static int save(MemoBean memo) {
        String sql = "insert into tb_memo (username, title, content, memotype, memotime) values (?, ?, ?, ?, ?);";
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, memo.getUsername());
            ps.setString(2, memo.getTitle());
            ps.setString(3, memo.getContent());
            ps.setString(4, memo.getMemotype());
            ps.setString(5, memo.getMemotime());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }

    //数据修改
    public static int update(MemoBean memo) {
        String sql = "update tb_memo set username = ?, title = ?, content = ?, memotype = ?, memotime = ? where id = ?;";
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, memo.getUsername());
            ps.setString(2, memo.getTitle());
            ps.setString(3, memo.getContent());
            ps.setString(4, memo.getMemotype());
            ps.setString(5, memo.getMemotime());
            ps.setInt(6, memo.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }
    //保存全部备忘录信息
    public static List<MemoBean> queryAll() {
        String sql = "select * from tb_memo;";
        List<MemoBean> results = new ArrayList<MemoBean>();
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet rs= null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while(rs.next()) {
                MemoBean memo = new MemoBean();
                memo.setId(rs.getInt("id"));
                memo.setUsername(rs.getString("username"));
                memo.setTitle(rs.getString("title"));
                memo.setMemotype(rs.getString("memotype"));
                memo.setMemotime(rs.getString("memotime"));
                memo.setContent(rs.getString("content"));
                results.add(memo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return results;
    }
    //查询备忘录
    public static List<MemoBean> query(MemoBean memo) {
        String username = memo.getUsername();
        String title = memo.getTitle();
        String memotype = memo.getMemotype();
        String memotime = memo.getMemotime();
        String content = memo.getContent();
        StringBuilder sql = new StringBuilder("select * from tb_memo where 1=1");
        if(!username.isEmpty()) {
            sql.append(" and username like '%" + username +"%' ");
        }
        if(!title.isEmpty()) {
            sql.append(" and title like '%" + title +"%' ");
        }
        if(!content.isEmpty()) {
            sql.append(" and content like '%" + content +"%' ");
        }
        if(!memotype.isEmpty()) {
            sql.append(" and memotype like '%" + memotype +"%' ");
        }
        if(!memotime.isEmpty()) {
            sql.append(" and memotime like '%" + memotime +"%' ");
        }
        sql.append(";");
        List<MemoBean> results = new ArrayList<MemoBean>();
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql.toString());
            while(rs.next()) {
                MemoBean tempmemo = new MemoBean();
                tempmemo.setId(rs.getInt("id"));
                tempmemo.setUsername(rs.getString("username"));
                tempmemo.setTitle(rs.getString("title"));
                tempmemo.setContent(rs.getString("content"));
                tempmemo.setMemotype(rs.getString("memotype"));
                tempmemo.setMemotime(rs.getString("memotime"));
//                System.out.println(tempmemo.getUsername());
                results.add(tempmemo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return results;
    }
    //正则表达式校对输入日期格式
    public static boolean dataTimeFormat(String memotime) {
        String regx = "([123]\\d{3}-(([0][1-9])|([1][0-2]))-(([0][1-9])|([12]\\d)|([3][01])))";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(memotime);
        if(!matcher.matches()) {
            return false;
        }else {
            String[] times = memotime.split("-");
            Integer year = Integer.parseInt(times[0]);
            Integer month = Integer.parseInt(times[1]);
            Integer day = Integer.parseInt(times[2]);
            GregorianCalendar calendar= new GregorianCalendar();
            if(calendar.isLeapYear(year) && (month==2) && (day > 29)) {
                return false;
            }else if(!calendar.isLeapYear(year) && (month==2) && (day > 28)) {
                return false;
            }else {
                switch (month) {
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if(day > 30) {
                            return false;
                        }else {
                            return true;
                        }
                    default:
                        return true;
                }
            }
        }
    }
    //删除备忘录
    public static int delete(MemoBean memo) {
        String sql = "delete from tb_memo where id = " + memo.getId();
        Connection conn = getConnection();
        Statement stat = null;
        try {
            stat = conn.createStatement();
            return stat.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {// 释放资源
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }
}
