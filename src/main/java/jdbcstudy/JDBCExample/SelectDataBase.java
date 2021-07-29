package jdbcstudy.JDBCExample;

import java.sql.*;

/**
 * @author zhuzhiqiang
 */
public class SelectDataBase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connect database......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connect success.......");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sx) {
                sx.printStackTrace();
            }
        } //end finally try
        System.out.println("GoodBye!");
    } //end main
}
