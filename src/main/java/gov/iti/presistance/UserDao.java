package gov.iti.presistance;

import java.util.*;

import gov.iti.model.User;

interface UserDao {
    public User login(String userName, String password);

    public boolean signUp(User user);

    public List<User> getUsers();

    public List<User> getUserByName(String name);

}
