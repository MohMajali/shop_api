package com.example.shopping_api.moduls;

import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("avg")
    private String avg;

    @SerializedName("avg1")
    private int avg1;

    @SerializedName("avg2")
    private int avg2;

    @SerializedName("avg3")
    private int avg3;

    @SerializedName("avg4")
    private int avg4;

    @SerializedName("avg5")
    private int avg5;

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public int getAvg1() {
        return avg1;
    }

    public void setAvg1(int avg1) {
        this.avg1 = avg1;
    }

    public int getAvg2() {
        return avg2;
    }

    public void setAvg2(int avg2) {
        this.avg2 = avg2;
    }

    public int getAvg3() {
        return avg3;
    }

    public void setAvg3(int avg3) {
        this.avg3 = avg3;
    }

    public int getAvg4() {
        return avg4;
    }

    public void setAvg4(int avg4) {
        this.avg4 = avg4;
    }

    public int getAvg5() {
        return avg5;
    }

    public void setAvg5(int avg5) {
        this.avg5 = avg5;
    }
}
