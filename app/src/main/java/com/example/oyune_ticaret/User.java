package com.example.oyune_ticaret;

import java.util.ArrayList;

public class User {
    private String userName;
    private String password;

    User() {
        this.userName = "";
        this.password = "";
    }
    User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
    // Static method to generate fake users for testing
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("kasim", "kasim"));
        users.add(new User("admin", "admin"));
        return users;
    }
}
