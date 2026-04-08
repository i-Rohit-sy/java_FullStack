package jdbc.CRUD;

import java.sql.*;

public class retreiveRec {
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
        String sql = "SELECT * from studentInfo";
        ResultSet n = statement.executeQuery(sql);
//        process result
        while(n.next()){
            System.out.println(n.getInt(1)+" "+ n.getString(2)+" "+ n.getInt(3)+" "+n.getString(4));
            System.out.println(n.getInt("id")+" "+ n.getString("sname")+" "+ n.getInt("sage")+" "+n.getString("scity"));
        }
//        close the resources
        n.close();
        statement.close();
        connect.close();

    }
}
