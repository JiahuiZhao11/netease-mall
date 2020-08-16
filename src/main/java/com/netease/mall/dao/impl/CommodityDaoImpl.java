package com.netease.mall.dao.impl;

import com.netease.mall.dao.BaseDao;
import com.netease.mall.dao.CommodityDao;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CommodityDaoImpl extends BaseDao implements CommodityDao {

    @Override
    public ResultData deleteCommodity(String commodityId) {
        ResultData result = new ResultData();
        try {
            int response = sqlSession.update("netease_mall.commodity.delete", commodityId);
            result.setData(response);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return null;
    }

    @Override
    public ResultData add(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            int response = sqlSession.insert("netease_mall.commodity.add", condition);
            result.setData(response);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return null;
    }


    @Override
    public ResultData update(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            int response = sqlSession.update("netease_mall.commodity.update", condition);
            result.setData(response);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }
        return null;
    }
}
