package com.netease.mall.service;

import com.netease.mall.util.ResultData;

import java.util.Map;

public interface HomeService {

    ResultData fetchAllGoods(Map<String, Object> condition);

//    boolean fetchBought(String userId, String commodityId);

    ResultData fetchSoldNum(String commodityId);

    ResultData fetchGoodDetail(String commodityId);

    float fetchIsBought(Map<String, Object> condition);


}
