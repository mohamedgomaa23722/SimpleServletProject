package gov.iti.controller;

import java.io.FileInputStream;
import java.io.IOException;

import gov.iti.model.User;

import java.io.File; // Import the File class

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpg");
        String fileDirectory = "D:\\textEditor\\serverImages\\";
        User user = (User) request.getSession(false).getAttribute("userBean");
        String fileName = user.getUserName() + user.getBirthdate() + ".jpg";
        System.out.println(fileName);
        File file = new File(fileDirectory + fileName);
        response.setHeader("Content-Disposition", "attachment; filename=\"image.jpg\"");
        try (FileInputStream fileOutputStream = new FileInputStream(file)) {
            byte[] imageBytes = new byte[(int) file.length()];
            fileOutputStream.read(imageBytes);
            response.getOutputStream().write(imageBytes);
        } catch (Exception e) {
        }
    }
}
