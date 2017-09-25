package com.hnevc.choosefood;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2017/9/13.
 */

public class Food {
    private  String foodName;
    private  float foodPrice;
    private  boolean hot;
    private  boolean fish;
    private  boolean sour;
    private  String detail;
    private  Drawable pics;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Food(String foodName, float foodPrice, boolean hot, boolean fish, boolean sour, String detail, Drawable pics) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.hot = hot;
        this.fish = fish;
        this.sour = sour;
        this.detail = detail;
        this.pics = pics;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodName='" + foodName + '\'' +
                ", foodPrice=" + foodPrice +
                ", hot=" + hot +
                ", fish=" + fish +
                ", sour=" + sour +
                ", pics=" + pics +
                '}';
    }

    public Food() {
    }

    public Food(String foodName, float foodPrice, boolean hot, boolean fish, boolean sour, Drawable pics) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.hot = hot;
        this.fish = fish;
        this.sour = sour;
        this.pics = pics;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public float getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(float foodPrice) {
        this.foodPrice = foodPrice;
    }

    public boolean isHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean isFish() {
        return fish;
    }

    public void setFish(boolean fish) {
        this.fish = fish;
    }

    public boolean isSour() {
        return sour;
    }

    public void setSour(boolean sour) {
        this.sour = sour;
    }

    public Drawable getPics() {
        return pics;
    }

    public void setPics(Drawable pics) {
        this.pics = pics;
    }
}
