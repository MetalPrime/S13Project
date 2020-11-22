package com.example.s13project;

public class newContact {
    private String id;
    private String name;
    private String phone;
    private String uid;

    public  newContact(){

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public newContact(String id, String name, String phone, String uid) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.uid = uid;
    }


}
