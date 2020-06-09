package com.example.task3.adapterBhaibandhu;

public class LocationItem {

    private String location ;
    private String region;
    private String areas;
    private boolean expanded;

    public String getLocation() {
        return location;
    }

    public String getRegion() {
        return region;
    }

    public String getAreas() {
        return areas;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public LocationItem(String location, String region, String areas) {
        this.location = location;
        this.region = region;
        this.areas = areas;
        expanded = false;
    }
}
