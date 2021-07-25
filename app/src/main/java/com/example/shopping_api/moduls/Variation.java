package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Variation {

    @SerializedName("id")
    private String id;

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

    @SerializedName("color")
    private String color;

    @SerializedName("size")
    private String size;

    @SerializedName("always_in_stock")
    private boolean always_in_stock;

    @SerializedName("max_qty")
    private int max_qty;

    @SerializedName("images")
    private List<String> images;

    public String getOld_price() {
        return old_price;
    }

    public void setOld_price(String old_price) {
        this.old_price = old_price;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCurrenccy() {
        return currenccy;
    }

    public void setCurrenccy(String currenccy) {
        this.currenccy = currenccy;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isAlways_in_stock() {
        return always_in_stock;
    }

    public void setAlways_in_stock(boolean always_in_stock) {
        this.always_in_stock = always_in_stock;
    }

    public int getMax_qty() {
        return max_qty;
    }

    public void setMax_qty(int max_qty) {
        this.max_qty = max_qty;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
