package com.example.s13project;

public class User {

    private String email;
    private String id;
    private String name;
    private String number;
    private String password;

    public User(String email, String id, String name, String number, String password) {
        this.email = email;
        this.id = id;
        this.name = name;
        this.number = number;
        this.password = password;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
