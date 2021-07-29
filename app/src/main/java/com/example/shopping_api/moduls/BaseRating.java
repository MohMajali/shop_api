package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;

public class BaseRating {

    @SerializedName("result")
    private ResultRating resultRating;

    @SerializedName("other")
    private OtherRating otherRating;

    public ResultRating getResultRating() {
        return resultRating;
    }

    public void setResultRating(ResultRating resultRating) {
        this.resultRating = resultRating;
    }

    public OtherRating getOtherRating() {
        return otherRating;
    }

    public void setOtherRating(OtherRating otherRating) {
        this.otherRating = otherRating;
    }
}
