package com.example.asus.wmad2.models;

import com.orm.SugarRecord;

/**
 * Created by Asus on 6/2/2018.
 */

public class Review extends SugarRecord<Review> {

    private String reviewid;
    private String message;
    private String date;

    public Review(String reviewid, String message) {
        this.reviewid = reviewid;
        this.message = message;
    }

    public Review() {
    }

    public String getReviewid() {
        return reviewid;
    }

    public void setReviewid(String reviewid) {
        this.reviewid = reviewid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
