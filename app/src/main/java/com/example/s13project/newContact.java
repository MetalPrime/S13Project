package com.example.s13project;

public class newContact {
    private String id;
    private String userName;
    private String contactName;
    private String contactNumber;

    public  newContact(){

    }

    public newContact(String id, String userName, String contactName, String contactNumber) {
        this.id = id;
        this.userName = userName;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
