package com.test.loginformservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/register")
public class register extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Entered the Servlet Debugging Purposes");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");

//        load and Register the driver
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String URL = "jdbc:mariadb://127.0.0.1:3306/userInfo";
            String USER = "root";
            String PASSWORD = "12345678";
            Connection connect = DriverManager.getConnection(URL,USER,PASSWORD);

            PreparedStatement pstmnt = connect.prepareStatement("INSERT INTO users (name, email, password, gender) VALUES (?, ?, ?, ?)");

            pstmnt.setString(1,name);
            pstmnt.setString(2,email);
            pstmnt.setString(3,password);
            pstmnt.setString(4,gender);

            int flag = pstmnt.executeUpdate();
            PrintWriter pw = res.getWriter();

            if(flag != 0){
                pw.println("<h1>Registration Success!</h1>");
            }else{
                pw.println("<h1>Registration Failed!</h1>");
            }
            pstmnt.close();
            connect.close();
            pw.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
