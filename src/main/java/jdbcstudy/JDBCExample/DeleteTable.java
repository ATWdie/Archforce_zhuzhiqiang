package jdbcstudy.JDBCExample;

import java.sql.*;

/**
 * @author zhuzhiqiang
 */
public class DeleteTable {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/STUDENT";

    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connect database......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connect success......");

            System.out.println("Delete table.....");
            stmt = conn.createStatement();
            String SQL = "DROP TABLE registration";
            stmt.executeUpdate(SQL);
            System.out.println("Delete success.....");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null) {
                    conn.close();
                }
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null) {
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("end.....");
    } //end main
}
