package com.yifei.spring.annotation.api.model;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author yifei
 * @date 2019/11/13
 */
public class SerializableBase implements Serializable {
    private static final long serialVersionUID = -2249334523530023353L;

    /**
     * 转成json串
     *
     * @return String
     */
    public String toJsonString() {
        return JSON.toJSONString(this);
    }
}
