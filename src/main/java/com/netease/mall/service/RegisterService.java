package com.netease.mall.service;

import com.netease.mall.util.ResultData;

import java.util.Map;

public interface RegisterService {

    ResultData fetch(Map<String,Object> condition);

}
