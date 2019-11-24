package com.yifei.spring.annotation.web.model;

import com.yifei.spring.annotation.web.constant.CmnConstant;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author yifei
 * @date 2019/9/19
 */
@Data
@ToString
@NoArgsConstructor
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

    public JsonResult(T data) {
        this.status = CmnConstant.SUCCESS_STATUS;
        this.data = data;
    }

    public JsonResult(String status, String errorCode, String errorMsg) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
