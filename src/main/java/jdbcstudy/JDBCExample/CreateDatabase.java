package jdbcstudy.JDBCExample;

import java.sql.*;

/**
 * @author zhuzhiqiang
 */
public class CreateDatabase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //注册JDBC驱动
            Class.forName(JDBC_DRIVER);

            //打开连接
            System.out.println("Connect database......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //执行命令
            System.out.println("Create database.....");
            stmt = conn.createStatement();

            String SQL = "CREATE DATABASE STUDENT";
            stmt.executeUpdate(SQL);
            System.out.println("Success!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(stmt != null){
                    stmt.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }//end try
        System.out.println("GoodBye!");
    }//end main
}
