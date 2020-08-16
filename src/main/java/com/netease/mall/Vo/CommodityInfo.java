package com.netease.mall.Vo;

public class CommodityInfo extends Entity {

    private String commodityId;

    private String title;

    private String picture;

    private Float price;

    private Boolean bought;

    private int soldNum;

    public CommodityInfo() {
        super();
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

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

    public Boolean getBought() {
        return bought;
    }

    public void setBought(Boolean bought) {
        this.bought = bought;
    }

    public Integer getsoldnum() {
        return soldNum;
    }

    public void setsoldnum(Integer soldnum) {
        this.soldNum = soldnum;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public CommodityInfo(String commodityId, String title, String picture, boolean bought, int soldNum,
                         Float price) {

        this();
        this.commodityId = commodityId;
        this.title = title;
        this.picture = picture;
        this.bought = bought;
        this.soldNum = soldNum;
        this.price = price;


    }
}

