package com.test.serve;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/secondServlet")
public class secondServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("Control in second servlet");
        PrintWriter writer = res.getWriter();
        writer.println("<h1>Response From Servlet 2</h1>");
        writer.close();
    }
}
