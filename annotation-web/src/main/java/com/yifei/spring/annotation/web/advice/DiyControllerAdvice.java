package com.yifei.spring.annotation.web.advice;

import com.yifei.spring.annotation.web.constant.CmnConstant;
import com.yifei.spring.annotation.web.model.JsonResult;
import com.yifei.spring.annotation.web.util.RequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yifei
 * @date 2019/9/23
 */
@ControllerAdvice(value = "")
public class DiyControllerAdvice {

    private static final Logger logger = LoggerFactory.getLogger(DiyControllerAdvice.class);

    /**
     * 全局初始化绑定器
     *
     * @param webDataBinder 绑定器
     * @param request       请求
     */
    @InitBinder
    private void initBinder(WebDataBinder webDataBinder, HttpServletRequest request) {
        logger.info("*****轨迹号【{}】 ControllerAdvice:【{}】initBinder*****", RequestUtils.getAndIncreaseTrackNum(request), this.getClass().getTypeName());

        // 去除前后空格
        webDataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        // 将yyyy-MM-dd字符串转换成Date类型
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
        webDataBinder.registerCustomEditor(Date.class, editor);
    }

    /**
     * 全局设置Model
     *
     * @param request 请求
     * @param model   model
     */
    @ModelAttribute
    private void setModelAttribute(HttpServletRequest request, Model model) {
        logger.info("*****轨迹号【{}】 ControllerAdvice:【{}】setModelAttribute*****", RequestUtils.getAndIncreaseTrackNum(request), this.getClass().getTypeName());
        model.addAttribute("all_userName", "毅飞");
    }

    /**
     * 全局异常处理
     *
     * @param request  请求
     * @param response 响应
     * @return JsonResult
     */
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public JsonResult handleException(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
        logger.info("*****轨迹号【{}】 ControllerAdvice:【{}】handleException*****异常：", RequestUtils.getAndIncreaseTrackNum(request), this.getClass().getTypeName(), throwable);
        return new JsonResult<>(CmnConstant.FAIL_STATUS, "", "The system is out of order!");
    }
}
