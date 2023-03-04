package gov.iti.utils;

import java.io.IOException;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Cookies {
    
    public static boolean isExist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // check if it exist or no
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if(cookie.getName().equals("UserName")){
                    return true;
                }
            }
        }
        return false;
    }

    public static void createCookie(HttpServletRequest request, HttpServletResponse response){
        Cookie c1 = new Cookie("UserName", request.getParameter("UserName"));
        response.addCookie(c1);
    }
}
