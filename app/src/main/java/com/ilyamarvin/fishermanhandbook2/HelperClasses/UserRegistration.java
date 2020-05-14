package com.ilyamarvin.fishermanhandbook2.HelperClasses;

public class UserRegistration {

    String firstname, secondname, username, email, password;

    public UserRegistration() {

    }

    public UserRegistration(String firstname, String secondname, String username, String email, String password) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
