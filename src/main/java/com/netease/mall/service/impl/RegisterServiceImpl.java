package com.netease.mall.service.impl;

import com.netease.mall.dao.RegisterDao;
import com.netease.mall.service.RegisterService;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;

    @Override
    public ResultData fetch(Map<String, Object> condition) {
        ResultData result = new ResultData();
        ResultData response = registerDao.select(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(ResponseCode.RESPONSE_NULL);
            result.setDescription("query is null");
            return result;
        } else if (response.getResponseCode() == ResponseCode.RESPONSE_ERROR) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("query is error");
            return result;
        }
        result.setResponseCode(ResponseCode.RESPONSE_OK);
        result.setData(response.getData());
        return result;
    }
}
