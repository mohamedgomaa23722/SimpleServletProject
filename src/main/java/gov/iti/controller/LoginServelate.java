package gov.iti.controller;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServelate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login servlet");
        resp.setContentType("text/html");
        HttpSession session = req.getSession();
        session.setAttribute("userBean", req.getAttribute("userBean"));
        resp.sendRedirect("search");
    }
}
