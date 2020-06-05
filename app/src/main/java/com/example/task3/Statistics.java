package com.example.task3;

import com.google.gson.annotations.SerializedName;

public class Statistics {
    @SerializedName("base_stat")
    private int baseStat;

    @SerializedName("stat")
    private MoveName statName;

    public int getBaseStat() {
        return baseStat;
    }

    public MoveName getStatName() {
        return statName;
    }
}
