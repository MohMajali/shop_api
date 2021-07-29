package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;

public class BaseFavorite {

    @SerializedName("result")
    private FavoriteResult result;

    @SerializedName("data")
    private FavoriteData data;

    public FavoriteResult getResult() {
        return result;
    }

    public void setResult(FavoriteResult result) {
        this.result = result;
    }

    public FavoriteData getData() {
        return data;
    }

    public void setData(FavoriteData data) {
        this.data = data;
    }
}
