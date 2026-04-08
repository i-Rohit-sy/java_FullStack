package jdbc.CRUD;

import java.sql.*;

public class sameQueryforAll {
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
        boolean isDone = statement.execute(sql);
//        process result
        if(isDone){
           ResultSet rs = statement.getResultSet();
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+ rs.getString(2)+" "+ rs.getInt(3)+" "+rs.getString(4));
            }
        }
        else{
           int row = statement.getUpdateCount();
           if(row == 0) System.out.println("Operation failed");
           else System.out.println("operation successful");
        }
//        close the resources
        statement.close();
        connect.close();

    }
}
