package com.example.asus.wmad2.models;


import com.orm.SugarRecord;

public class tags extends SugarRecord<tags> {

    private String TagID;
    private String TagName;

public tags(){}


    public tags(String tagID, String tagName) {
        TagID = tagID;
        TagName = tagName;
    }

    public String getTagID() {
        return TagID;
    }

    public void setTagID(String tagID) {
        TagID = tagID;
    }

    public String getTagName() {
        return TagName;
    }

    public void setTagName(String tagName) {
        TagName = tagName;
    }
}
