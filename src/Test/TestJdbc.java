package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by YLL on 2015/10/10.
 */
public class TestJdbc {
    public void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载失败！");
        }
        String url = "jdbc:mysql://localhost:3306/databasename=test2";
        String user = "root";
        String password = "yll106";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "insert into tb_users(username, password, sex, age) values('张三', '1111', '男', '20')";
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        TestJdbc testJdbc = new TestJdbc();
            testJdbc.getConnection();

    }
}
