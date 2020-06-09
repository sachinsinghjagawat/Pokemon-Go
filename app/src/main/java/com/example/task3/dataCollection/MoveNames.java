package com.example.task3.dataCollection;

import com.google.gson.annotations.SerializedName;

public class MoveNames {
    @SerializedName("move")
    private MoveName moveNames;

    public MoveName getMoveNames() {
        return moveNames;
    }
}
