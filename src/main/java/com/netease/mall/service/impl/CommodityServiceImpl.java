package com.netease.mall.service.impl;

import com.netease.mall.dao.CommodityDao;
import com.netease.mall.service.CommodityService;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    @Override
    public ResultData deleteCommodity(String commodityId) {
        ResultData result = new ResultData();
        ResultData response = commodityDao.deleteCommodity(commodityId);
        if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("Delete the commodity is error");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;
    }

    @Override
    public ResultData add(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = commodityDao.add(condition);
        if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("Add the commodity is error");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;
    }


    @Override
    public ResultData update(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = commodityDao.update(condition);
        if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("Update the commodity is error");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;
    }
}
