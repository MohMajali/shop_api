package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;

public class Other {

    @SerializedName("rating")
    private Rating rating;

    @SerializedName("is_rate")
    private boolean is_rate;

    @SerializedName("is_favorite")
    private boolean is_favorite;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public boolean isIs_rate() {
        return is_rate;
    }

    public void setIs_rate(boolean is_rate) {
        this.is_rate = is_rate;
    }

    public boolean isIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
    }
}
