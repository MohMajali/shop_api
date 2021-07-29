package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;

public class OtherRating {

    @SerializedName("rating")
    private Rating rating;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
