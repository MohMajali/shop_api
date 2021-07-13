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

    @SerializedName("max_qty")
    private int maxQty;

    @SerializedName("variations")
    private List<variation> bigBariation;




}
