package com.example.task3;

import android.media.Image;

public class ListItem {

    private String heading;
    private  String description;
    private String image ;

//    public ListItem(String heading, String description, String image) {
//        this.heading = heading;
//        this.description = description;
//        this.image = image;
//    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return image;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ListItem(String heading, String description, String image) {
        this.heading = heading;
        this.description = description;
        this.image = image;
    }
}
