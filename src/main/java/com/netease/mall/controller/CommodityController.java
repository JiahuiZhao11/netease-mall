package com.netease.mall.controller;

import com.netease.mall.service.CommodityService;
import com.netease.mall.service.HomeService;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private HomeService homeService;

    //删除未出售商品
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResultData deleteCommodity(@RequestBody Map<String, Object> condition) {
        ResultData result = new ResultData();

        String userId = condition.get("userId").toString();
        String commodityId = condition.get("commodityId").toString();

        //权限校验
        if (!userId.equals("2")) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Permission denied.");
            return result;
        }

        //查询是否未出售
        Map<String, Object> con = new HashMap<>();
        con.put("commodityId", commodityId);
        float isSold = homeService.fetchIsBought(con);
        if (isSold > 0) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("The product has been sold and cannot be deleted.");
            return result;
        }

        //删除商品
        ResultData re = commodityService.deleteCommodity(commodityId);
        if (re.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setDescription("Success!");
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Detail the commodity failed.");
        }
        return result;
    }


    //发布新商品
    @RequestMapping(value = "/release", method = RequestMethod.POST)
    public ResultData addCommodity(@RequestBody Map<String, Object> condition) {
        ResultData result = new ResultData();

        //权限校验
        String userId = condition.get("userId").toString();
        if (!userId.equals("2")) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Permission denied.");
            return result;
        }

        ResultData resultData = commodityService.add(condition);
        if (resultData.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setDescription("Success!");
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Release the commodity failed.");
        }
        return result;
    }


    //编辑商品
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public ResultData modifyCommodity(@RequestBody Map<String, Object> condition) {
        ResultData result = new ResultData();

        //权限校验
        String userId = condition.get("userId").toString();
        if (!userId.equals("2")) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Permission denied.");
            return result;
        }

        ResultData resultData = commodityService.update(condition);
        if (resultData.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setDescription("Success!");
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("Edit the commodity failed.");
        }
        return result;
    }
}
