package com.example.task3.dataCollection;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {
    @SerializedName("name")
    private String name;

    @SerializedName("damage_relations")
    private SubCategory damageRelation;

    @SerializedName("move_damage_class")
    private SubCategory moveDamageClass;

    @SerializedName("fling_power")
    private int flingPower;

    @SerializedName("category")
    private SubCategory category;

    @SerializedName("held_by_pokemon")
    private List<SubCategory> heldByPokemon;

    @SerializedName("effect_entries")
    private List<SubCategory> effectEntries;

    @SerializedName("region")
    private SubCategory region;

    @SerializedName("areas")
    private List<SubCategory> areas;

    @SerializedName("locations")
    private List<SubCategory> locations;

    @SerializedName("pokedexes")
    private List<SubCategory> pokedexes;

    public String getName() {
        return name;
    }

    public SubCategory getDamageRelation() {
        return damageRelation;
    }

    public SubCategory getMoveDamageClass() {
        return moveDamageClass;
    }

    public int getFlingPower() {
        return flingPower;
    }

    public SubCategory getCategory() {
        return category;
    }

    public List<SubCategory> getHeldByPokemon() {
        return heldByPokemon;
    }

    public List<SubCategory> getEffectEntries() {
        return effectEntries;
    }

    public SubCategory getRegion() {
        return region;
    }

    public List<SubCategory> getAreas() {
        return areas;
    }

    public List<SubCategory> getLocations() {
        return locations;
    }

    public List<SubCategory> getPokedexes() {
        return pokedexes;
    }
}
