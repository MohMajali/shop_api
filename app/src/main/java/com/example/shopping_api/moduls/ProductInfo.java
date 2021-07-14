package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductInfo {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("short_description")
    private String shortDesc;

    @SerializedName("details")
    private String details;

    @SerializedName("max_qty")
    private int max_qty;

    @SerializedName("variations")
    private List<BigVariation> bigVariation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getMax_qty() {
        return max_qty;
    }

    public void setMax_qty(int max_qty) {
        this.max_qty = max_qty;
    }

    public List<BigVariation> getBigVariation() {
        return bigVariation;
    }

    public void setBigVariation(List<BigVariation> bigVariation) {
        this.bigVariation = bigVariation;
    }

    public List<BigVariation> bigVariation() {
        return bigVariation;
    }

    public void bigVariation(List<BigVariation> bigVariation) {
        this.bigVariation = bigVariation;
    }
}
