package com.netease.mall.dao.impl;

import com.netease.mall.Vo.UserVo;
import com.netease.mall.dao.BaseDao;
import com.netease.mall.dao.RegisterDao;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RegisterDaoImpl extends BaseDao implements RegisterDao{

    @Override
    public ResultData select(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            UserVo userVo  = sqlSession.selectOne("netease_mall.userinfo.select",condition);
            if (userVo == null) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            } else {
                result.setData(userVo);
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
        }

        return null;
    }
}
