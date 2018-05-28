package com.example.asus.wmad2.models;

import com.orm.SugarRecord;



public class User extends SugarRecord<User>{

    private String email;
    private String password;
    private String name;
    private String contactNo;

    public User (String email , String password , String name, String contactNo) {
        this.email = email;
        this.password = password;
        this.name= name;
        this.contactNo= contactNo;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public User(){

    }

}
