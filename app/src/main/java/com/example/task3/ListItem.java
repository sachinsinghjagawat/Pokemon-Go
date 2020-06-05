package com.example.task3;

import android.media.Image;
import android.widget.ProgressBar;

public class ListItem {

    private String heading;
    private  String description;
    private String image ;
    private String move;
    private String statistics;
    private String types;
    public boolean expandable;

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

    public String getMove() {
        return move;
    }

    public String getStatistics() {
        return statistics;
    }

    public String getTypes() {
        return types;
    }

    public boolean isExpandable() {
        return expandable;
    }
//
//    public void setMove(String move) {
//        this.move = move;
//    }
//
//    public void setStatistics(String statistics) {
//        this.statistics = statistics;
//    }
//
//    public void setTypes(String types) {
//        this.types = types;
//    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }
//
//    public void setHeading(String heading) {
//        this.heading = heading;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    /*public ListItem(String heading, String description, String image) {
        this.heading = heading;
        this.description = description;
        this.image = image;
        expandable = false;
    }
     */

    public ListItem(String heading, String description, String image, String move, String statistics, String types) {
        this.heading = heading;
        this.description = description;
        this.image = image;
        this.move = move;
        this.statistics = statistics;
        this.types = types;
        expandable = false;
    }
}
