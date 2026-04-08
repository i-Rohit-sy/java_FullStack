package better.jdbc.code;

import util.jdbcutil;

import java.sql.*;

public class exceptionHandle {
    public static void main(String[] args) {

        Statement statement = null;
        Connection connect = null;
        try {
//        Load and register Driver
            Class.forName("org.mariadb.jdbc.Driver");

//         connecting to the Class
//        Establish the Connection
            String url = "jdbc:mariadb://localhost:3306/jdbclearning";
            String user = "root"; //sample user
            String password = "12345678"; //sample pass change as per your system
            connect = DriverManager.getConnection(url, user, password);

//        creating a new Statement
            statement = connect.createStatement();

//         execute Query
            String sql = "SELECT * from studentInfo";
            boolean isDone = statement.execute(sql);
//        process result
            if (isDone) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
                }
            } else {
                int row = statement.getUpdateCount();
                if (row == 0) System.out.println("Operation failed");
                else System.out.println("operation successful");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                jdbcutil.closeConnection(connect,statement);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
//        close the resources
    }
}
