package com.example.asus.wmad2.models;

import android.widget.EditText;

import com.orm.SugarRecord;

import java.util.Date;


public class OrderItems extends SugarRecord<OrderItems> {

    Orders orders;
    User user;
    private String date;



    public OrderItems() {
    }


 public OrderItems(Orders orders, User user) {
        this.orders = orders;
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
