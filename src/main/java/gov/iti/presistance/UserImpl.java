package gov.iti.presistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gov.iti.model.User;

public class UserImpl implements UserDao {

    private final static UserImpl INSTANCE = new UserImpl();

    private UserImpl() {
    }

    public static UserImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public User login(String userName, String password) {
        User user = null;
        String query = "select * from user where user_name = ? AND password = ?";
        try (PreparedStatement statement = ConnectionManager.getInstance().connection.prepareStatement(query)) {
            statement.setString(1, userName);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean signUp(User user) {
        String query = "insert into user(user_name, password, birthdate) values(?, ?, ?)";
        if(user.getUserName() != null)
        try (PreparedStatement statement = ConnectionManager.getInstance().connection.prepareStatement(query)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getBirthdate());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        else
         System.out.println("userName is null");
        return false;
    }

    @Override
    public List<User> getUsers() {
        List<User> usersList = new ArrayList<>();
        String query = "select * from user";
        try (PreparedStatement statement = ConnectionManager.getInstance().connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                usersList.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    @Override
    public List<User> getUserByName(String name) {
        List<User> usersList = new ArrayList<>();
        String query = "select * from user where user_name like ?";
        try (PreparedStatement statement = ConnectionManager.getInstance().connection.prepareStatement(query)) {
            statement.setString(1, name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                usersList.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public List<User> writeQuery(String query) {
        List<User> usersList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getInstance().connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // usersList.add(new User(resultSet.getInt(1), resultSet.getString(2),
                // resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }
}