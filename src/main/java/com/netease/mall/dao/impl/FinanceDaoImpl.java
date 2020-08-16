package com.netease.mall.dao.impl;

import com.netease.mall.Vo.BoughtVo;
import com.netease.mall.Vo.CartVo;
import com.netease.mall.Vo.CommodityVo;
import com.netease.mall.dao.BaseDao;
import com.netease.mall.dao.FinanceDao;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FinanceDaoImpl extends BaseDao implements FinanceDao {

    @Override
    public ResultData selectCartList(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<CartVo> cartVos = sqlSession.selectList("netease_mall.finance.selectCartList", condition);
            if (cartVos == null) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            } else {
                result.setData(cartVos);
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
    public ResultData addToCard(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            int re = sqlSession.insert("netease_mall.finance.addToCard", condition);
            if (re < 1) {
                result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            } else {
                result.setData(re);
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
    public ResultData deleteCart(String userId) {
        ResultData result = new ResultData();
        try {
            int re = sqlSession.update("netease_mall.finance.deleteCart", userId);
            if (re < 1) {
                result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            } else {
                result.setData(re);
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
    public ResultData addToBought(String userId, List<CartVo> cartVos) {
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("userId", userId);
        condition.put("cartVos", cartVos);

        try {
            int re = sqlSession.insert("netease_mall.finance.addToBought", condition);
            if (re < 1) {
                result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            } else {
                result.setData(re);
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
    public ResultData getAllBought(String userId) {
        ResultData result = new ResultData();
        try {
            List<BoughtVo> boughtVos = sqlSession.selectList("netease_mall.finance.getAllBought", userId);
            if (boughtVos.size() < 1) {
                result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            } else {
                result.setData(boughtVos);
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
