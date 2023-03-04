package gov.iti.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import gov.iti.model.User;
import gov.iti.presistance.UserImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String date = request.getParameter("date");
        Part file = request.getPart("file");

        User user = new User(userName, password, date);

        String fileName = user.getUserName() + user.getBirthdate();

        try {
            file.write("D:\\textEditor\\serverImages\\" + fileName + ".jpg");
        } catch (IOException fne) {
            response.sendRedirect("signUp");
            return;
        }

        boolean isRegister = UserImpl.getInstance().signUp(user);
        if (isRegister) {
            // redirect to Home Page
            System.out.println("go to home");
            response.sendRedirect("login");
        } else {
            // stay in SignUp
            response.sendRedirect("signUp");
        }
        System.out.println("I am inside the service method");
    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
