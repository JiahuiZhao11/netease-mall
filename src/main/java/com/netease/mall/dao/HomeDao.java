package com.netease.mall.dao;

import com.netease.mall.util.ResultData;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface HomeDao {

    ResultData selectAllGoods(Map<String, Object> condition);

    ResultData selectSoldNum(@Param("commodityId") String commodityId);

//    boolean selectBought(String userId, String commodityId);

    ResultData selectGoodDetail(String commodityId);

    ResultData selectIsBought(Map<String, Object> condition);


}
