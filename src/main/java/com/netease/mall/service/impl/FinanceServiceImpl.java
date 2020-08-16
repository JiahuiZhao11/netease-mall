package com.netease.mall.service.impl;

import com.netease.mall.Vo.CartVo;
import com.netease.mall.dao.FinanceDao;
import com.netease.mall.service.FinanceService;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FinanceServiceImpl implements FinanceService {

    @Autowired
    private FinanceDao financeDao;

    @Override
    public ResultData fetchCartList(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = financeDao.selectCartList(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("Query cart commodity list is null.");
            return result;
        } else if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Query cart commodity list is error.");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;
    }

    @Override
    public ResultData addToCard(Map<String, Object> condition) {
        ResultData result = new ResultData();

        ResultData response = financeDao.addToCard(condition);
        if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Add the commodity to cart is error.");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;
    }

    @Override
    public ResultData deleteCart(String userId) {
        ResultData result = new ResultData();

        ResultData response = financeDao.deleteCart(userId);
        if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("delete cart is error.");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;
    }

    @Override
    public ResultData addToBought(String userId, List<CartVo> cartVos) {

        ResultData result = new ResultData();

        ResultData response = financeDao.addToBought(userId, cartVos);
        if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("add to bought table is error.");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;
    }


    @Override
    public ResultData getAllBought(String userId){
        ResultData result = new ResultData();
        ResultData response = financeDao.getAllBought(userId);
        if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("fetch all bought commodities is error.");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;

    }
}
