package com.netease.mall.Vo;

public class CommodityVo extends Entity {

    private String commodityId;

    private String title;

    private String picture;

    private String summary;

    private String text;

    private Float price;

    public CommodityVo() {
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

//    public Boolean getBought() {
//        return bought;
//    }
//
//    public void setBought(Boolean bought) {
//        this.bought = bought;
//    }
//
//    public Integer getsoldnum() {
//        return soldNum;
//    }
//
//    public void setsoldnum(Integer soldnum) {
//        this.soldNum = soldnum;
//    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public CommodityVo(String commodityId, String title, String picture, String summary, String text,
                       Float price) {

        this();
        this.commodityId = commodityId;
        this.title = title;
        this.picture = picture;
        this.summary = summary;
        this.text = text;
//        this.bought = bought;
//        this.soldNum = soldnum;
        this.price = price;


    }
}
