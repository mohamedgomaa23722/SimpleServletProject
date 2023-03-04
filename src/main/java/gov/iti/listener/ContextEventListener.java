package gov.iti.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ContextEventListener implements ServletContextListener {
    private ServletContext servletContext = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context created");
        servletContext = sce.getServletContext();
        servletContext.setAttribute("online", 0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context Destroyed");
        servletContext.setAttribute("online", 0);
    }
}
