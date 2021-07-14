package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailedProduct {

    @SerializedName("result")
    private Result result;

    @SerializedName("data")
    private ProductInfo data;

    @SerializedName("related")
    private List<Related> related;

    @SerializedName("other")
    private  Other other;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ProductInfo getData() {
        return data;
    }

    public void setData(ProductInfo data) {
        this.data = data;
    }

    public List<Related> getRelated() {
        return related;
    }

    public void setRelated(List<Related> related) {
        this.related = related;
    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }
}
