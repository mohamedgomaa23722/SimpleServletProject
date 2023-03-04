package gov.iti.controller.filters;

import java.io.IOException;



import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class IpAddressFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("ip filter");
        String ipAddress = request.getLocalAddr();
        request.setAttribute("ipAddress", ipAddress);
        response.getWriter().println(ipAddress);
        chain.doFilter(request, response);
        System.out.println("ipAddress back");
    }

}
