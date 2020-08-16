package com.netease.mall.service;

import com.netease.mall.util.ResultData;

import java.util.Map;

public interface CommodityService {

    ResultData deleteCommodity(String commodityId);

    ResultData add(Map<String, Object> condition);

    ResultData update(Map<String, Object> condition);
}
