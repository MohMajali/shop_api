package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BigVariation {

    @SerializedName("color")
    private String color;

    @SerializedName("variations")
    private List<Vairation> variations;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Vairation> getVariations() {
        return variations;
    }

    public void setVariations(List<Vairation> variations) {
        this.variations = variations;
    }
}
