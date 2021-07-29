package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;

public class FavoriteData {


    @SerializedName("result")
    private boolean re;


    @SerializedName("is_favorite")
    private boolean is_favorite;

    public boolean isIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
    }
}
