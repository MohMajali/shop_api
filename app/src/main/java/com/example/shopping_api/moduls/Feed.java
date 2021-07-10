package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;


import java.util.List;

public class Feed {

    @SerializedName("color")
    private String color;

    @SerializedName("max_qty")
    private int max_qty;

    @SerializedName("cart_count")
    private int cart_count;

    @SerializedName("best_selling_title")
    private String best_selling_title;

    @SerializedName("new_arrival_title")
    private String new_arrival_title;

    @SerializedName("brand_title")
    private String brand_title;

    @SerializedName("deals_title")
    private String deals_title;

    @SerializedName("phone")
    private String phone;

    @SerializedName("email")
    private String email;

    @SerializedName("address")
    private String address;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lang")
    private String lang;

    @SerializedName("show_color")
    private boolean show_color;

    @SerializedName("show_size")
    private boolean show_size;

    @SerializedName("large_promotion")
    private List<LargePromotion> largePromotion;

    @SerializedName("first_slider")
    private List<FirstSlider> first_slider;

    @SerializedName("second_slider")
    private List<SecondSlider> second_slider;

    @SerializedName("third_slider")
    private List<ThirdSlider> third_slider;

    @SerializedName("small_category")
    private boolean small_category;

    @SerializedName("large_category")
    private boolean large_category;

    @SerializedName("category")
    private List<Category> category;

    @SerializedName("shop_by_brand")
    private List<ShopByBrand> shop_by_brand;

    @SerializedName("deals")
    private List<Deals> deals;

    @SerializedName("new_arrivals")
    private List<NewArrivals> new_arrivals;

    @SerializedName("best_selling")
    private List<BestSelling> best_selling;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMax_qty() {
        return max_qty;
    }

    public void setMax_qty(int max_qty) {
        this.max_qty = max_qty;
    }

    public int getCart_count() {
        return cart_count;
    }

    public void setCart_count(int cart_count) {
        this.cart_count = cart_count;
    }

    public String getBest_selling_title() {
        return best_selling_title;
    }

    public void setBest_selling_title(String best_selling_title) {
        this.best_selling_title = best_selling_title;
    }

    public String getNew_arrival_title() {
        return new_arrival_title;
    }

    public void setNew_arrival_title(String new_arrival_title) {
        this.new_arrival_title = new_arrival_title;
    }

    public String getBrand_title() {
        return brand_title;
    }

    public void setBrand_title(String brand_title) {
        this.brand_title = brand_title;
    }

    public String getDeals_title() {
        return deals_title;
    }

    public void setDeals_title(String deals_title) {
        this.deals_title = deals_title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isShow_color() {
        return show_color;
    }

    public void setShow_color(boolean show_color) {
        this.show_color = show_color;
    }

    public boolean isShow_size() {
        return show_size;
    }

    public void setShow_size(boolean show_size) {
        this.show_size = show_size;
    }

    public List<LargePromotion> getLargePromotion() {
        return largePromotion;
    }

    public void setLargePromotion(List<LargePromotion> largePromotion) {
        this.largePromotion = largePromotion;
    }

    public List<FirstSlider> getFirst_slider() {
        return first_slider;
    }

    public void setFirst_slider(List<FirstSlider> first_slider) {
        this.first_slider = first_slider;
    }

    public List<SecondSlider> getSecond_slider() {
        return second_slider;
    }

    public void setSecond_slider(List<SecondSlider> second_slider) {
        this.second_slider = second_slider;
    }

    public List<ThirdSlider> getThird_slider() {
        return third_slider;
    }

    public void setThird_slider(List<ThirdSlider> third_slider) {
        this.third_slider = third_slider;
    }

    public boolean isSmall_category() {
        return small_category;
    }

    public void setSmall_category(boolean small_category) {
        this.small_category = small_category;
    }

    public boolean isLarge_category() {
        return large_category;
    }

    public void setLarge_category(boolean large_category) {
        this.large_category = large_category;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public List<ShopByBrand> getShop_by_brand() {
        return shop_by_brand;
    }

    public void setShop_by_brand(List<ShopByBrand> shop_by_brand) {
        this.shop_by_brand = shop_by_brand;
    }

    public List<Deals> getDeals() {
        return deals;
    }

    public void setDeals(List<Deals> deals) {
        this.deals = deals;
    }

    public List<NewArrivals> getNew_arrivals() {
        return new_arrivals;
    }

    public void setNew_arrivals(List<NewArrivals> new_arrivals) {
        this.new_arrivals = new_arrivals;
    }

    public List<BestSelling> getBest_selling() {
        return best_selling;
    }

    public void setBest_selling(List<BestSelling> best_selling) {
        this.best_selling = best_selling;
    }
}
