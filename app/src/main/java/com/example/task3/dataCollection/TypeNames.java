package com.example.task3.dataCollection;

import com.example.task3.dataCollection.MoveName;
import com.google.gson.annotations.SerializedName;

public class TypeNames {
    @SerializedName("type")
    private MoveName type;

    public MoveName getType() {
        return type;
    }
}
