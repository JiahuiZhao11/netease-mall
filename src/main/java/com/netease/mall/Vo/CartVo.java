package com.netease.mall.Vo;

public class CartVo {

    private String commodityId;

    private String title;

    private String picture;

    private String summary;

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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    private Float price;

    private Integer num;

    public CartVo() {
        super();
    }

    public CartVo(String commodityId, String title, Float price, Integer num, String picture, String summary) {
        this();
        this.commodityId = commodityId;
        this.title = title;
        this.price = price;
        this.num = num;
        this.picture = picture;
        this.summary = summary;
    }
}
