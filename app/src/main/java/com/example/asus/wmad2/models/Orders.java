package com.example.asus.wmad2.models;

import com.orm.SugarRecord;


public class Orders extends SugarRecord<Orders> {

    private Product product;
    private User user;
    private  String status = "cart";
   // private String total;

    public Orders(){}

    public Orders(Product product, User user) {
        this.product = product;
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //public String getTotal() {
      //  return total;
    //}

    //public void setTotal(String total) {
      //  this.total = total;
    //}
}
