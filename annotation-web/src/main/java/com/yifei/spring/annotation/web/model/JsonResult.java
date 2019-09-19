package com.yifei.spring.annotation.web.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author yifei
 * @date 2019/9/19
 */
@Data
@ToString
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 919091344202179450L;
    /**
     * 状态码
     */
    private String status;
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     * 数据
     */
    private T data;
}
