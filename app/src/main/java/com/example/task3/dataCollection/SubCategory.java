package com.example.task3.dataCollection;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubCategory {
    @SerializedName("no_damage_to")
    private List<Sub2Category> noDamageTo;

    @SerializedName("half_damage_to")
    private List<Sub2Category> halfDamageTo;

    @SerializedName("double_damage_to")
    private List<Sub2Category> doubleDamageTo;

    @SerializedName("no_damage_from")
    private List<Sub2Category> noDamageFrom;

    @SerializedName("half_damage_from")
    private List<Sub2Category> halfDamageFrom;

    @SerializedName("double_damage_from")
    private List<Sub2Category> doubleDamageFrom;

    @SerializedName("name")
    private String name;

    @SerializedName("pokemon")
    private Sub2Category pokemon;

    @SerializedName("effect")
    private String  effect;

    @SerializedName("short_effect")
    private String  shortEffect;

    public List<Sub2Category> getNoDamageTo() {
        return noDamageTo;
    }

    public List<Sub2Category> getHalfDamageTo() {
        return halfDamageTo;
    }

    public List<Sub2Category> getDoubleDamageTo() {
        return doubleDamageTo;
    }

    public List<Sub2Category> getNoDamageFrom() {
        return noDamageFrom;
    }

    public List<Sub2Category> getHalfDamageFrom() {
        return halfDamageFrom;
    }

    public List<Sub2Category> getDoubleDamageFrom() {
        return doubleDamageFrom;
    }

    public String getName() {
        return name;
    }

    public Sub2Category getPokemon() {
        return pokemon;
    }

    public String getEffect() {
        return effect;
    }

    public String getShortEffect() {
        return shortEffect;
    }
}
