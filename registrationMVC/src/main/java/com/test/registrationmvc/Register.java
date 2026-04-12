package com.test.registrationmvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");

        Model model = new Model();
        model.setName(name);
        model.setEmail(email);
        model.setGender(gender);
        model.setPassword(password);

        int row = model.register();
        HttpSession session = req.getSession();
        session.setAttribute("name",name);
        if(row == 0) {
            res.sendRedirect(req.getContextPath() + "/failure.jsp");
        } else{
            res.sendRedirect(req.getContextPath() + "/success.jsp");
        }

    }
}
 