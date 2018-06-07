package com.example.asus.wmad2.models;

import com.orm.SugarRecord;

/**
 * Created by Asus on 6/2/2018.
 */

public class Favorite extends SugarRecord<Favorite> {

    private Product product;
    private User user;


    public Favorite(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    public Favorite() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



}
