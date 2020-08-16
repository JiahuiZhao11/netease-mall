package com.netease.mall.dao.impl;

import com.netease.mall.Vo.CommodityVo;
import com.netease.mall.dao.BaseDao;
import com.netease.mall.dao.HomeDao;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HomeDaoImpl extends BaseDao implements HomeDao {

    @Override
    public ResultData selectAllGoods(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<CommodityVo> commodityVos = sqlSession.selectList("netease_mall.home.selectAllGoods", condition);
            if (commodityVos == null) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            } else {
                result.setData(commodityVos);
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }

        return null;
    }

    @Override
    public ResultData selectSoldNum(String commodityId) {
        ResultData result = new ResultData();
        try {
            int soldNum = sqlSession.selectOne("netease_mall.home.selectSoldNum", commodityId);
            if (soldNum <= 0) {
                result.setData(0);
            } else {
                result.setData(soldNum);
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultData selectGoodDetail(String commodityId) {
        ResultData result = new ResultData();
        try {
            CommodityVo commodityVo = sqlSession.selectOne("netease_mall.home.selectGoodDetail", commodityId);
            if (commodityVo == null) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            } else {
                result.setData(commodityVo);
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }

        return null;
    }

    @Override
    public ResultData selectIsBought(Map<String, Object> condition) {

        ResultData result = new ResultData();
        try {
            Float payPrice = sqlSession.selectOne("netease_mall.home.selectIsBought", condition);
            result.setData(payPrice);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return null;
    }

//    @Override
//    public boolean selectBought(String userId, String commodityId) {
//        Map<String, Object> condition = new HashMap<>();
//        condition.put("userId", userId);
//        condition.put("commodityId", commodityId);
//        Integer boughtNum = sqlSession.selectOne("netease_mall.home.selectBought", condition);
//        if (boughtNum > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}
