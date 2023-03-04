package gov.iti.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;  // Import the File class

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("video/mp4");
        String fileDirectory = "D:\\textEditor\\";
        String fileName = "f.mp4";
        File file = new File(fileDirectory + fileName);
        response.setHeader("Content-Disposition", "attachment; filename=\"image.mp4\"");
        try (FileInputStream fileOutputStream = new FileInputStream(file)) {
            byte[] imageBytes = new byte[(int) file.length()];
            fileOutputStream.read(imageBytes);
            response.getOutputStream().write(imageBytes);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
