package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;

public class Deals {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("sku")
    private String sku;

    @SerializedName("price")
    private String price;

    @SerializedName("is_old")
    private boolean is_old;

    @SerializedName("old_price")
    private String old_price;

    @SerializedName("currenccy")
    private String currenccy;

    @SerializedName("attribute")
    private String attribute;

    @SerializedName("image")
    private String image;

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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isIs_old() {
        return is_old;
    }

    public void setIs_old(boolean is_old) {
        this.is_old = is_old;
    }

    public String getOld_price() {
        return old_price;
    }

    public void setOld_price(String old_price) {
        this.old_price = old_price;
    }

    public String getCurrenccy() {
        return currenccy;
    }

    public void setCurrenccy(String currenccy) {
        this.currenccy = currenccy;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
