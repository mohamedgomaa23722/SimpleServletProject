package gov.iti.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


import gov.iti.presistance.UserImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.Response;

public class ValidationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("into validation Servlet" + req.getParameter("state"));

        int validateStatus = Integer.parseInt(req.getParameter("state"));
        PrintWriter out = resp.getWriter();
        String message = null;

        if (validateStatus == 0) {
            // validate user name
            System.out.println("user name = " + req.getParameter("userName"));
            boolean isExist = UserImpl.getInstance().isExistUserName(req.getParameter("userName"));
            message = (isExist)? "User is user Before":"valid User";
            out.println(message);
        } else if (validateStatus == 1) {
            // validate Password
            System.out.println("user name = " + req.getParameter("password"));
            String password = req.getParameter("password");
            message = (password.length() > 8)? "strong password":"weak passwrod";
            out.println(message);
        } else if(validateStatus == 2){
            String password =  req.getParameter("password");
            String cPassword =  req.getParameter("cPassword");
            message = (password.equals(cPassword))? "valid confiramtion":"wrong confiramtion";
            out.println(message);
        }else {
            File file = new File("view/WEB_INF/Data.xml");
            
            out.println("WEB_INF/Data.xml");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println(req.getParameter("name"));
    }
}
