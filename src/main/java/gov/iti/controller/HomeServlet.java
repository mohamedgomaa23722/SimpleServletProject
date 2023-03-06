package gov.iti.controller;

import java.io.IOException;

import gov.iti.presistance.UserImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import com.google.gson.Gson;
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String searchParameter = req.getParameter("search");
        String userJson = new Gson().toJson(UserImpl.getInstance().getUserByName(searchParameter));
        System.out.println(userJson);
        resp.getWriter().println(userJson);
    }

    /*private String createStandardJSON(String value) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        List<User> users = UserImpl.getInstance().getUserByName(value);
        for (User user : users) {
            arrayBuilder.add(getObject(user));
        }

        JsonObject obj = Json.createObjectBuilder()
                .add("conversion", arrayBuilder.build()).build();
        return (obj.toString());
    }

    private JsonObject getObject(User user){
        return Json.createObjectBuilder().add("id", user.getId()).add("name", user.getUserName()).add("date", user.getBirthdate()).build();
    }*/
}
