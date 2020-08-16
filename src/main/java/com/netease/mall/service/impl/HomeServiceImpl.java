package com.netease.mall.service.impl;


import com.netease.mall.dao.HomeDao;
import com.netease.mall.service.HomeService;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDao homeDao;

    @Override
    public ResultData fetchAllGoods(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = homeDao.selectAllGoods(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("query all goods list is null.");
            return result;
        } else if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("query all goods list is error.");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;
    }

    @Override
    public ResultData fetchSoldNum(String commodityId) {
        ResultData result = new ResultData();
        ResultData response = homeDao.selectSoldNum(commodityId);
        if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Query the sold num failed.");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;
    }

    @Override
    public ResultData fetchGoodDetail(String commodityId) {
        ResultData result = new ResultData();
        ResultData response = homeDao.selectGoodDetail(commodityId);
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("Query the good detail is null");
            return result;
        } else if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Query the good detail is error");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;
    }

    @Override
    public float fetchIsBought(Map<String, Object> condition) {
        ResultData response = homeDao.selectIsBought(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK && response.getData() != null) {
            return (float) response.getData();
        } else return -1;
    }



//    @Override
//    public boolean fetchBought(String userId, String commodityId) {
//
//        return homeDao.selectBought(userId, commodityId);
//    }
}
