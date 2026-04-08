package jdbc.CRUD;

import java.sql.*;

public class delRec {
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
        String sql = "delete from studentInfo where id = 102;";
        int n = statement.executeUpdate(sql);
//        process result
        if(n == 0) System.out.println("Failed to delete");
        else System.out.println("Deleted");
//        close the resources

        statement.close();
        connect.close();

    }
}
