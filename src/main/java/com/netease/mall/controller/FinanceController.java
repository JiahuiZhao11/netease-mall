package com.netease.mall.controller;

import com.netease.mall.Vo.BoughtResult;
import com.netease.mall.Vo.BoughtVo;
import com.netease.mall.Vo.CartVo;
import com.netease.mall.Vo.CommodityVo;
import com.netease.mall.service.FinanceService;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    //查看购物车
    @GetMapping("/getCartList")
    public ResultData getCartList(String userId) {
        ResultData result = new ResultData();

        Map<String, Object> condition = new HashMap<>();
        condition.put("userId", userId);

        ResultData response = financeService.fetchCartList(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setDescription("Success!");
            result.setData(response.getData());

        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Query shopping cart commodities list failed.");
        }
        return result;
    }


    //将商品加入购物车
    @GetMapping("/addToCart")
    public ResultData addToCard(String userId, String commodityId) {
        ResultData result = new ResultData();
        Map<String, Object> condition = new HashMap<>();
        condition.put("userId", userId);
        condition.put("commodityId", commodityId);

        ResultData response = financeService.addToCard(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setDescription("Success!");
            result.setData(response.getData());

        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Add the commodity into shopping cart failed.");
        }
        return result;
    }

    //结算购物车
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public ResultData buy(@RequestBody Map<String, Object> condition) {
        ResultData result = new ResultData();
        String userId = condition.get("userId").toString();
        List<CartVo> cartVos = (List<CartVo>) condition.get("cartVos");

        //购物车表该用户数据软删除
        ResultData response = financeService.deleteCart(userId);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {

            //将商品列表添加到bought表
            ResultData re = financeService.addToBought(userId, cartVos);
            if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
                result.setResponseCode(ResponseCode.RESPONSE_OK);
                result.setDescription("Success!");
                result.setData(response.getData());
            } else {
                result.setResponseCode(ResponseCode.RESPONSE_ERROR);
                result.setDescription("Add the commodities to bought failed.");
            }

        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Delete shopping cart failed.");
        }
        return result;
    }

    //查看已买所有商品
    @GetMapping("/bought")
    public ResultData getAllBought(String userId) {

        ResultData result = new ResultData();

        ResultData response = financeService.getAllBought(userId);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            float sum = 0;
            BoughtResult boughtResult = new BoughtResult();
            List<BoughtVo> boughtVos = (List<BoughtVo>) response.getData();
            for (int i = 0; i < boughtVos.size(); i++) {
                sum = sum + boughtVos.get(i).getNum() * boughtVos.get(i).getPrice();
            }
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            boughtResult.setBoughtVoList(boughtVos);
            boughtResult.setSum(sum);
            result.setData(boughtResult);
            result.setDescription("Success!");
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Edit the commodity failed.");
        }
        return result;
    }
}