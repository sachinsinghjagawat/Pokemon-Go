package com.example.task3.adapterBhaibandhu;

public class RegionItem {

    private String region;
    private String location;
    private String pokedoxes;
    private boolean expanded;

    public String getRegion() {
        return region;
    }

    public String getLocation() {
        return location;
    }

    public String getPokedoes() {
        return pokedoxes;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public RegionItem(String region, String location, String pokedoxes) {
        this.region = region;
        this.location = location;
        this.pokedoxes = pokedoxes;
        expanded = false;
    }
}
