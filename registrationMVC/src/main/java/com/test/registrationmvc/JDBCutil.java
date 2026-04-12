package com.test.registrationmvc;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCutil {
    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Driver is registered");
    }

    public static Connection getDBConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/userInfo",
                "root",
                "12345678"
        );
    }

    public static void closeResource(Connection connect, Statement stmt) throws SQLException {
        if(connect != null) connect.close();
        if(stmt != null)  stmt.close();
    }

}
