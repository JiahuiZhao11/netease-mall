package com.netease.mall.Vo;

public class BoughtVo {

    private String title;

    private String picture;

    private String time;

    private float price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private int num;

    public BoughtVo() {
        super();
    }

    public BoughtVo(String title, String picture, Float price, int num, String time) {
        this();
        this.picture = picture;
        this.title = title;
        this.price = price;
        this.num = num;
        this.time = time;
    }
}
