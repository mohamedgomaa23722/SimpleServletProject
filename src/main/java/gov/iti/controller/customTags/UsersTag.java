package gov.iti.controller.customTags;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.util.*;
import gov.iti.model.*;
import gov.iti.presistance.UserImpl;

public class UsersTag extends SimpleTagSupport {

    protected String searchValue = null;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println();
        List<User> users = UserImpl.getInstance().getUserByName(searchValue);
        System.out.println("users length : " + users.size() + " user search for : "+ searchValue);
        String table = "<table id = \"table\"> <tr> <th>id</th> <th>userName</th> <th>BithDate</th> </tr>";
        for (User user : users) {
            table += "<tr> <td>" + user.getId() + "</td> <td>" + user.getUserName() + "</td> <td>"
                    + user.getBirthdate()
                    + "</td></tr>";
        }
        table += "</table>";
        out.println(table);
    }

}
