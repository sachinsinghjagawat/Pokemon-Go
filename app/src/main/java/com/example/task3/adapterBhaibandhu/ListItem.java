package com.example.task3.adapterBhaibandhu;

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

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }


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
