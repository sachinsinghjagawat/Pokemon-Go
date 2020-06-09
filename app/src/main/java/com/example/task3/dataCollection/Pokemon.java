package com.example.task3.dataCollection;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {

    @SerializedName("name")
    private String name;

    @SerializedName("base_experience")
    private String experience;

    @SerializedName("moves")
    private List<MoveNames> moves;

    @SerializedName("stats")
    private List<Statistics> statistics;

    @SerializedName("types")
    private List<TypeNames> typeNames;


    public List<TypeNames> getTypeNames() {
        return typeNames;
    }

    public List<Statistics> getStatistics() {
        return statistics;
    }

    public List<MoveNames> getMoves() {
        return moves;
    }

    public String getName() {
        return name;
    }

    public String getExperience() {
        return experience;
    }
}
