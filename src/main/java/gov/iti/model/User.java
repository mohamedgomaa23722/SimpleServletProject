package gov.iti.model;

public class User {
    private int id;
    private String userName;
    private String password;
    private String birthdate;

    
    public User() {
    }

    
    public User(String userName, String password, String birthdate) {
        this.userName = userName;
        this.password = password;
        this.birthdate = birthdate;
    }


    public User(int id, String userName, String birthdate) {
        this.id = id;
        this.userName = userName;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}