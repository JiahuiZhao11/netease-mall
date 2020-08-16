package com.netease.mall.controller;

import com.netease.mall.Vo.CommodityInfo;
import com.netease.mall.Vo.CommodityVo;
import com.netease.mall.service.HomeService;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/getHomePage")
    public ResultData getHomePage(String userId, Integer userType) {
        ResultData result = new ResultData();

        Map<String, Object> condition = new HashMap<>();
        condition.put("userType", userType);
        condition.put("userId", userId);

        //查询全部商品
        ResultData response = homeService.fetchAllGoods(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            //买家首页，返回所有商品信息，及是否已购买
            if (userType == 1) {
                for (CommodityInfo commodityVo : (List<CommodityInfo>) response.getData()) {
                    //查询是否已购买
                    Map<String, Object> con = new HashMap<>();
                    con.put("userId", userId);
                    con.put("commodityId", commodityVo.getCommodityId());
                    float oldprice = homeService.fetchIsBought(con);
                    if (oldprice >= 0) commodityVo.setBought(true);
                    else commodityVo.setBought(false);
                }
                result.setResponseCode(ResponseCode.RESPONSE_OK);
                result.setDescription("Success!");
                result.setData(response.getData());
            }

            //卖家首页，返回所有商品信息，及每个商品出售数量
            else if (userType == 2) {
                for (CommodityInfo commodityVo : (List<CommodityInfo>) response.getData()) {
                    ResultData resultData = homeService.fetchSoldNum(commodityVo.getCommodityId());
                    if (resultData.getResponseCode() == ResponseCode.RESPONSE_OK) {
                        int num = Integer.parseInt(resultData.getData().toString());
                        commodityVo.setsoldnum(num);
                    } else {
                        result.setResponseCode(ResponseCode.RESPONSE_ERROR);
                        result.setDescription("Query the sold num failed.");
                    }
                    result.setResponseCode(ResponseCode.RESPONSE_OK);
                    result.setDescription("Success!");
                    result.setData(response.getData());
                }
            } else {
                result.setResponseCode(ResponseCode.RESPONSE_ERROR);
                result.setDescription("Please determine the user type.");
            }
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Query all commodity information failed.");
        }
        return result;

    }

    @GetMapping("/getGoodsDetail")
    public ResultData getGoodsDetail(String userId, String commodityId) {
        ResultData result = new ResultData();

        //查询商品详情
        ResultData response = homeService.fetchGoodDetail(commodityId);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            //查询是否购买过及购买时价格
            Map<String, Object> condition = new HashMap<>();
            condition.put("userId", userId);
            condition.put("commodity", commodityId);
            float oldprice = homeService.fetchIsBought(condition);
            if (oldprice >= 0) {
                CommodityVo commodityVo = (CommodityVo) response.getData();
                commodityVo.setPrice(oldprice);
                result.setData(commodityVo);
            } else result.setData(response.getData());
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setDescription("Success!");
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Query the commodity detail failed.");
        }
        return result;
    }
}
