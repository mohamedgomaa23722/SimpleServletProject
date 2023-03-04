package gov.iti.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionEventListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session created" + se.getSession().getId());
        ServletContext servletContext = se.getSession().getServletContext();
        int onlineUsersCounter = (int) servletContext.getAttribute("online");
        servletContext.setAttribute("online", ++onlineUsersCounter);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session Destroyed" + se.getSession().getId());
        ServletContext servletContext = se.getSession().getServletContext();
        int onlineUsersCounter = (int) servletContext.getAttribute("online");
        servletContext.setAttribute("online", --onlineUsersCounter);
    }
}
