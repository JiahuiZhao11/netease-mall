package com.netease.mall.Vo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.sql.Timestamp;

public abstract class Entity {
    protected boolean blockFlag;
    protected String createAt;

    public Entity() {
        this.blockFlag = true;
        this.createAt = createAt;
    }

    public boolean isBlockFlag() {
        return blockFlag;
    }

    public void setBlockFlag(boolean blockFlag) {
        this.blockFlag = blockFlag;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this,SerializerFeature.DisableCircularReferenceDetect);
    }
}
