package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcutil {
    static{
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/jdbclearning";
        String user = "root"; //sample user
        String password = "12345678"; //sample pass change as per your system
        return DriverManager.getConnection(url, user, password);
    }
    public static void closeConnection(Connection connect, Statement statement) throws SQLException {
        statement.close();
        connect.close();
    }
}
