package jdbcstudy.JDBCExample;

import java.sql.*;

/**
 * @author zhuzhiqiang
 */
public class QueryRecode {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/STUDENT";

    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connect database.......");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connect success.......");

            System.out.println("Query record........");
            stmt = conn.createStatement();
            String SQL = "SELECT * FROM registration";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                int id = rs.getInt("id");
                int age = rs.getInt("age");
                String first = rs.getString("first");
                String last = rs.getString("last");

                System.out.print("ID: " + id);
                System.out.print(", Age: " + age);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
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
