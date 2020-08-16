package com.netease.mall.Vo;

import java.util.List;

public class BoughtResult {

    private List<BoughtVo> boughtVoList;

    private float sum;

    public List<BoughtVo> getBoughtVoList() {
        return boughtVoList;
    }

    public void setBoughtVoList(List<BoughtVo> boughtVoList) {
        this.boughtVoList = boughtVoList;
    }

    public float getSum() {

        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
