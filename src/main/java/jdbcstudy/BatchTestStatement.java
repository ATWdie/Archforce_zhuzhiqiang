package jdbcstudy;

import java.sql.*;

/**
 * @author zhuzhiqiang
 */
public class BatchTestStatement {
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    static final String USER = "root";
    static final String PASS = "root";

    static final String QUERY = "SELECT id, first, last, age FROM Employees";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            //关闭自动提交
            conn.setAutoCommit(false);
            System.out.println("Batch---------------------------");
            String SQL = "INSERT INTO Employees  " +
                    "VALUES (106, 20, 'Rita', 'Tez')";
            stmt.addBatch(SQL);
            SQL = "INSERT INTO Employees  " +
                    "VALUES (107, 24, 'Rita', 'Tez')";
            stmt.addBatch(SQL);
            SQL = "INSERT INTO Employees  " +
                    "VALUES (108, 26, 'Rita', 'Tez')";
            stmt.addBatch(SQL);

            int[] count = stmt.executeBatch();
            // If there is no error.
            conn.commit();
            //Query
            System.out.println("Query-------------------------------");
            ResultSet rs = stmt.executeQuery(QUERY);
            while (rs.next()) {
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.println(", Last: " + rs.getString("last"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
