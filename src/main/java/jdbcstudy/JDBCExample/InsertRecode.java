package jdbcstudy.JDBCExample;

import java.sql.*;

/**
 * @author zhuzhiqiang
 */
public class InsertRecode {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/STUDENT";

    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            //注册JDBC驱动
            Class.forName(JDBC_DRIVER);

            //建立连接
            System.out.println("Connect database.......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connect success........");

            //执行语句
            System.out.println("Insert record into the table.......");
            stmt = conn.createStatement();
            String SQL = "INSERT INTO registration VALUES (100,'A','B',30)";
            stmt.executeUpdate(SQL);

            System.out.println("Inserted success.......");
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
    }
}
