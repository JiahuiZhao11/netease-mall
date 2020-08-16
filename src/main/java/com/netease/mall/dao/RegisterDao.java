package com.netease.mall.dao;

import com.netease.mall.util.ResultData;

import java.util.Map;

public interface RegisterDao {

    ResultData select(Map<String, Object> condition);

}
