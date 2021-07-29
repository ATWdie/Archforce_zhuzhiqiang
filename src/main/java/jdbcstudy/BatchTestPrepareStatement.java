package jdbcstudy;

import java.sql.*;

/**
 * @author zhuzhiqiang
 */
public class BatchTestPrepareStatement {
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    static final String USER = "root";
    static final String PASS = "root";

    static final String QUERY = "SELECT id, first, last, age FROM Employees";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {
            System.out.println("PrepareStatement Batch---------------------------");
            String SQL = "INSERT INTO Employees (id,first,last,age)" +
                        "VALUES(?,?,?,?)";
            //create PrepareStatement object
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            //关闭自动提交
            conn.setAutoCommit(false);

            //set variables
            pstmt.setInt(1, 110);
            pstmt.setString(2, "aah");
            pstmt.setString(3, "bobby");
            pstmt.setInt(4, 87);
            //add in the batch
            pstmt.addBatch();

            //Create an int[] to hold returned values
            int[] count = pstmt.executeBatch();
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
