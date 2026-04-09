package better.jdbc.code;

import util.jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class prepareState {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement pstmnt = null;
        try {
            connection = jdbcutil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = "INSERT INTO studentInfo(id, sname, sage, scity) VALUES (? , ?, ?, ?)";
        pstmnt = connection.prepareStatement(sql);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details you want to save");

        System.out.println("Enter your id");
        int id = sc.nextInt();

        System.out.println("Enter your name");
        String name = sc.next();

        System.out.println("Enter your age");
        int age = sc.nextInt();

        System.out.println("Enter your city");
        String city = sc.next();

        pstmnt.setInt(1, id);
        pstmnt.setString(2,name);
        pstmnt.setInt(3,age);
        pstmnt.setString(4,city);
        int n = pstmnt.executeUpdate();

        if(n == 0) System.out.println("Operation Failed");
        else System.out.println("Success");

        try {
            jdbcutil.closeConnection(connection,pstmnt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
