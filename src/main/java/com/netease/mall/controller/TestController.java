package com.netease.mall.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class TestController {
    @RequestMapping("/mall")
//    @ResponseBody
    public String test() {
        return "index.html";
    }
}