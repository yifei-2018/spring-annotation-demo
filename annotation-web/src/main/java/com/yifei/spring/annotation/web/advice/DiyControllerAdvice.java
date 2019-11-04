package com.yifei.spring.annotation.web.advice;

import com.yifei.spring.annotation.web.constant.CmnConstant;
import com.yifei.spring.annotation.web.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yifei
 * @date 2019/9/23
 */
@ControllerAdvice
public class DiyControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(DiyControllerAdvice.class);

    /**
     * 全局异常处理
     */
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public JsonResult handleException() {
        logger.info("*****ControllerAdvice:【{}】handleException*****", this.getClass().getSimpleName());
        JsonResult<String> jsonResult = new JsonResult<>();
        jsonResult.setStatus(CmnConstant.FAIL_STATUS);
        jsonResult.setData("The system is out of order!");
        return jsonResult;
    }
}
