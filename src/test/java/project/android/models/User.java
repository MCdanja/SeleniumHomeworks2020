package project.android.models;

import project.functions.CommonFunctions;

public class User {

    private String email;
    private String userName;
    private String password;

    public User() {
        email = CommonFunctions.getRandomMail(5);
        userName = CommonFunctions.getRandomString(5);
        password = CommonFunctions.getRandomString(8);
    }

    public User(String email, String userName, String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
