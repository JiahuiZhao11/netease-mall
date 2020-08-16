package com.netease.mall.service;

import com.netease.mall.Vo.CartVo;
import com.netease.mall.util.ResultData;

import java.util.List;
import java.util.Map;

public interface FinanceService {

    ResultData fetchCartList(Map<String, Object> condition);

    ResultData addToCard(Map<String, Object> condition);

    ResultData deleteCart(String userId);

    ResultData addToBought(String userId, List<CartVo> cartVos);

    ResultData getAllBought(String userId);
}
