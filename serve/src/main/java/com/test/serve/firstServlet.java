package com.test.serve;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/firstServlet")
public class firstServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Control in the First Servlet");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/secondServlet");
//        requestDispatcher.forward(req,res);
        requestDispatcher.include(req,res);

        PrintWriter writer =  res.getWriter();
        writer.println("<h1>Response from Servlet 1 </h1>");

        writer.close();
    }
}
