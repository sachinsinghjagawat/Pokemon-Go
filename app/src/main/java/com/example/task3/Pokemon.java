package com.example.task3;

import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("name")
    private String name;


    public String getName() {
        return name;
    }

}
