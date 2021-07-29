package jdbcstudy.JDBCExample;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

/**
 * @author zhuzhiqiang
 */
public class DeleteDatabase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/";

    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connect database......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connect success.......");

            System.out.println("Delete Database.......");
            stmt = conn.createStatement();

            String SQL = "DROP DATABASE STUDENT1";
            stmt.executeUpdate(SQL);
            System.out.println("Delete success.......");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }finally {
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } //end finally
        System.out.println("END.....");
    } //end main
}
