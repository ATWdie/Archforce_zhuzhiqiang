package jdbcstudy;

import java.sql.*;
import java.math.*;

/**
 * @author zhuzhiqiang
 */
public class ConnectMysql {
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    static final String USER = "root";
    static final String PASS = "root";

    static final String QUERY = "SELECT id, first, last, age FROM Employees";
    static final String UPDATE_QUERY = "UPDATE Employees set age=30 WHERE id=103";

    public static void main(String[] args) throws SQLException {
        // 建立连接
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            //判断是否可以检索
            Boolean ret = stmt.execute(UPDATE_QUERY);
            System.out.println("Return value is : " + ret.toString());

            //返回受影响的行或数目
            int rows = stmt.executeUpdate(UPDATE_QUERY);
            System.out.println("Rows impacted : " + rows);

            //返回查询结果
            ResultSet rs = stmt.executeQuery(QUERY);

            //展示查询结果
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.println(", Last: " + rs.getString("last"));
            }
            try{
                //关闭自动提交
                conn.setAutoCommit(false);
                System.out.println("Insert--------------------------------");
                String SQL = "INSERT INTO Employees  " +
                        "VALUES (106, 20, 'Rita', 'Tez')";
                stmt.executeUpdate(SQL);
                //返回新的查询结果
                System.out.println("Query");
                rs = stmt.executeQuery(QUERY);
                while (rs.next()) {
                    System.out.print("ID: " + rs.getInt("id"));
                    System.out.print(", Age: " + rs.getInt("age"));
                    System.out.print(", First: " + rs.getString("first"));
                    System.out.println(", Last: " + rs.getString("last"));
                }
                //Submit a malformed SQL statement that breaks
                SQL = "INSERTED IN Employees  " +
                        "VALUES (107, 22, 'Sita', 'Singh')";
                stmt.executeUpdate(SQL);
                // If there is no error.
                conn.commit();
            }catch(SQLException se){
                // If there is any error.
                conn.rollback();
                //返回新的查询结果
                System.out.println("RollBack");
                rs = stmt.executeQuery(QUERY);
                while (rs.next()) {
                    System.out.print("ID: " + rs.getInt("id"));
                    System.out.print(", Age: " + rs.getInt("age"));
                    System.out.print(", First: " + rs.getString("first"));
                    System.out.println(", Last: " + rs.getString("last"));
                }
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
