package jdbc.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class cutomQuery {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//        Load and register Driver
        Class.forName("org.mariadb.jdbc.Driver");

//         connecting to the Class
//        Establish the Connection
        String url = "jdbc:mariadb://localhost:3306/jdbclearning";
        String user = "root"; //sample user
        String password ="12345678"; //sample pass change as per your system
        Connection connect = DriverManager.getConnection(url, user, password);

//        creating a new Statement
        Statement statement = connect.createStatement();

//         execute Query
        String sql = "UPDATE studentInfo set sage = 26 where id = 102;";
        int n = statement.executeUpdate(sql);
        if(n == 0) System.out.println("Failed");
        else System.out.println("Successret");
//        process result

//        close the resources
        statement.close();
        connect.close();

    }

}
