package com.example.task3.adapterBhaibandhu;

public class ItemsItem {

    private String item;
    private String flingPower;
    private String category;
    private String heldByPokemon;
    private String effectEntries;
    public boolean expanded;

    public String getItem() {
        return item;
    }

    public String getFlingPower() {
        return flingPower;
    }

    public String getCategory() {
        return category;
    }

    public String getHeldByPokemon() {
        return heldByPokemon;
    }

    public String getEffectEntries() {
        return effectEntries;
    }
    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public ItemsItem(String item, String flingPower, String category, String heldByPokemon, String effectEntries) {
        this.item = item;
        this.flingPower = flingPower;
        this.category = category;
        this.heldByPokemon = heldByPokemon;
        this.effectEntries = effectEntries;
        expanded = false ;
    }
}
