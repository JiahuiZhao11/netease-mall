package com.netease.mall.dao;

import com.netease.mall.util.ResultData;

import java.util.Map;

public interface CommodityDao {

    ResultData deleteCommodity(String commodityId);

    ResultData add(Map<String, Object> condition);

    ResultData update(Map<String, Object> condition);
}
