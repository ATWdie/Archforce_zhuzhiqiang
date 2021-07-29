package jdbcstudy;

import java.sql.*;

/**
 * @author zhuzhiqiang
 */
public class NavigateTest {
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    static final String USER = "root";
    static final String PASS = "root";

    static final String QUERY = "SELECT id, first, last, age FROM Employees";
    static final String UPDATE_QUERY = "UPDATE Employees set age=30 WHERE id=103";

    public static void main(String[] args){
        try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = stmt.executeQuery(QUERY);
            ){
            //移动光标到最后一行
            System.out.println("移动光标到最后一行");
            rs.last();

            //输出当前结果
            System.out.println("Displaying record...");
            //column name
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");

            //value
            System.out.print("ID: " + id);
            System.out.print(", AGE: " + age);
            System.out.print(", First: " + first);
            System.out.println(", last: " + last);

            //将光标移动到第一行
            System.out.println("将光标移动到第一行");
            rs.first();
            //输出当前结果
            System.out.println("Displaying record...");
            //column name
            id = rs.getInt("id");
            age = rs.getInt("age");
            first = rs.getString("first");
            last = rs.getString("last");

            //value
            System.out.print("ID: " + id);
            System.out.print(", AGE: " + age);
            System.out.print(", First: " + first);
            System.out.println(", last: " + last);

            //将光标移动到下一行
            System.out.println("将光标移动到下一行");
            rs.next();
            //输出当前结果
            System.out.println("Displaying record...");
            //column name
            id = rs.getInt("id");
            age = rs.getInt("age");
            first = rs.getString("first");
            last = rs.getString("last");

            //value
            System.out.print("ID: " + id);
            System.out.print(", AGE: " + age);
            System.out.print(", First: " + first);
            System.out.println(", last: " + last);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
