package gov.iti.controller.filters;

import java.io.IOException;

import gov.iti.model.User;
import gov.iti.presistance.UserImpl;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

public class ValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("ValidationFilter");
        if (!((String) request.getAttribute("ipAddress")).isEmpty()) {
            // Validate User
            String userName = request.getParameter("UserName");
            String password = request.getParameter("password");
            //remove att
            request.removeAttribute("UserName");
            request.removeAttribute("password");

            User user = null;
            if (userName != null && password != null && !userName.isEmpty() && !password.isEmpty()) {
                System.out.println("username is not null");
                user = UserImpl.getInstance().login(userName, password);
            }

            if (user != null) {
                request.setAttribute("userBean", user);
                chain.doFilter(request, response);
                System.out.println("ValidationFilter back");
            } else {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.sendRedirect("login");
            }
        }
    }
}
