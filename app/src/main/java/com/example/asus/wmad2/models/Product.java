package com.example.asus.wmad2.models;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;



public class Product extends SugarRecord<Product> {
    @SerializedName("Id")
    private Long Id;
    @SerializedName("Name")
    private String Name;
    private String Product;
    @SerializedName("ShortDescription")
    private String ShortDescription;
    @SerializedName("LongDescription")
    private String LongDescription;
    @SerializedName("Catagory")
    private String Catagory;
    @SerializedName("Price")
    private String Price;
    @SerializedName("Quantity")
    private String Quantity;
    @SerializedName("Active")
    private String Active;
    @SerializedName("ScaledImage")
    private String ScaledImage;
    @SerializedName("FullImage")
    private String FullImage;

    public Product() {
    }

   /* public Product(Long Id , String product, String shortDescription, String longDescription, String catagory, String price, String quantity, String active, String scaledImage, String fullImage) {
        Product = product;
        ShortDescription = shortDescription;
        LongDescription = longDescription;
        Catagory = catagory;
        Price = price;
        Quantity = quantity;
        Active = active;
        ScaledImage = scaledImage;
        FullImage = fullImage;
    }
    @Override
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }



    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        ShortDescription = shortDescription;
    }

    public String getLongDescription() {
        return LongDescription;
    }

    public void setLongDescription(String longDescription) {
        LongDescription = longDescription;
    }

    public String getCatagory() {
        return Catagory;
    }

    public void setCatagory(String catagory) {
        Catagory = catagory;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String active) {
        Active = active;
    }

    public String getScaledImage() {
        return ScaledImage;
    }

    public void setScaledImage(String scaledImage) {
        ScaledImage = scaledImage;
    }

    public String getFullImage() {
        return FullImage;
    }

    public void setFullImage(String fullImage) {
        FullImage = fullImage;
    }
}

*/


    public Product(Long id, String name, String product, String shortDescription, String longDescription, String catagory, String price, String quantity, String active, String scaledImage, String fullImage) {
        Id = id;
        Name = name;
        Product = product;
        ShortDescription = shortDescription;
        LongDescription = longDescription;
        Catagory = catagory;
        Price = price;
        Quantity = quantity;
        Active = active;
        ScaledImage = scaledImage;
        FullImage = fullImage;
    }

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    public String getShortDescription() {
        return ShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        ShortDescription = shortDescription;
    }

    public String getLongDescription() {
        return LongDescription;
    }

    public void setLongDescription(String longDescription) {
        LongDescription = longDescription;
    }

    public String getCatagory() {
        return Catagory;
    }

    public void setCatagory(String catagory) {
        Catagory = catagory;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String active) {
        Active = active;
    }

    public String getScaledImage() {
        return ScaledImage;
    }

    public void setScaledImage(String scaledImage) {
        ScaledImage = scaledImage;
    }

    public String getFullImage() {
        return FullImage;
    }

    public void setFullImage(String fullImage) {
        FullImage = fullImage;
    }
}