package com.yifei.spring.annotation.web.advice;

import com.yifei.spring.annotation.web.constant.CmnConstant;
import com.yifei.spring.annotation.web.model.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yifei
 * @date 2019/9/23
 */
@ControllerAdvice
public class DiyControllerAdvice {

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public JsonResult handleException() {
        JsonResult<String> jsonResult = new JsonResult<>();
        jsonResult.setStatus(CmnConstant.FAIL_STATUS);
        jsonResult.setData("The system is out of order!");
        return jsonResult;
    }
}
