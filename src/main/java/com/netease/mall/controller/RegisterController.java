package com.netease.mall.controller;

import com.netease.mall.service.RegisterService;
import com.netease.mall.util.ResponseCode;
import com.netease.mall.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {


    @Autowired
    private RegisterService registerService;

    @GetMapping("/identification")
    public ResultData register(String userName, String password) {
        ResultData result = new ResultData();

//        String pw = convertMD5(convertMD5(password));
        Map<String, Object> condition = new HashMap<>();
        condition.put("userName", userName);
        condition.put("password", password);
        ResultData response = registerService.fetch(condition);

        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            result.setResponseCode(ResponseCode.RESPONSE_OK);
            result.setDescription("允许登录");
            result.setData(response.getData());
            return result;
        } else {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("登录失败");
            return result;
        }

    }

    public String convertMD5(String inStr){
        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

}
