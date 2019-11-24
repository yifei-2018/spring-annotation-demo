package com.yifei.spring.annotation.web.controller;

import com.yifei.spring.annotation.web.constant.CmnConstant;
import com.yifei.spring.annotation.web.model.JsonResult;
import com.yifei.spring.annotation.web.util.RequestUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yifei
 * @date 2019/11/7
 */
@Controller
@RequestMapping("/initBinder")
public class InitBinderController {
    private static final Logger logger = LoggerFactory.getLogger(InitBinderController.class);
    /**
     * 局部异常
     */
    private static final String EXCEPTION_LOCAL = "IllegalArgumentException";
    /**
     * 全局异常
     */
    private static final String EXCEPTION_ALL = "NullPointerException";

    /**
     * 局部初始化绑定器
     *
     * @param dataBinder 绑定器
     * @param request    请求
     */
    @InitBinder("u1")
    private void initBinder1(WebDataBinder dataBinder, HttpServletRequest request) {
        logger.info("*****轨迹号【{}】 InitBinderController:【{}】initBinder1*****", RequestUtils.getAndIncreaseTrackNum(request), this.getClass().getTypeName());
        dataBinder.setFieldDefaultPrefix("u1.");
    }

    /**
     * 局部初始化绑定器
     *
     * @param dataBinder 绑定器
     * @param request    请求
     */
    @InitBinder("u2")
    private void initBinder2(WebDataBinder dataBinder, HttpServletRequest request) {
        logger.info("*****轨迹号【{}】 InitBinderController:【{}】initBinder2*****", RequestUtils.getAndIncreaseTrackNum(request), this.getClass().getTypeName());
        dataBinder.setFieldDefaultPrefix("u2.");
    }

    /**
     * 局部设置Model
     *
     * @param request 请求
     */
    @ModelAttribute("user")
    private User setModelAttribute(HttpServletRequest request) {
        logger.info("*****轨迹号【{}】 InitBinderController:【{}】setModelAttribute*****", RequestUtils.getAndIncreaseTrackNum(request), this.getClass().getTypeName());
        User user = new User();
        user.setName("毅飞");
        user.setAge(27);
        return user;
    }

    /**
     * 局部异常处理
     *
     * @param request   请求
     * @param response  响应
     * @param throwable 异常
     * @return JsonResult
     */
    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseBody
    public JsonResult handleException(HttpServletRequest request, HttpServletResponse response, Throwable throwable) {
        logger.info("*****轨迹号【{}】 InitBinderController:【{}】handleException*****异常：", RequestUtils.getAndIncreaseTrackNum(request), this.getClass().getTypeName(), throwable);
        return new JsonResult<>(CmnConstant.FAIL_STATUS, "", throwable.getMessage());
    }

    /**
     * 字符串测试
     *
     * @param str 字符串
     * @return JsonResult
     */
    @RequestMapping("/stringTest")
    @ResponseBody
    public JsonResult stringTest(String str) {
        return new JsonResult<>("时间串：" + str);
    }

    /**
     * 日期测试
     *
     * @param date 日期
     * @return JsonResult
     */
    @RequestMapping("/dateTest")
    @ResponseBody
    public JsonResult dateTest(Date date) {
        return new JsonResult<>("时间串：" + date);
    }

    /**
     * 对象测试
     *
     * @param u1 用户1
     * @param u2 用户2
     * @return JsonResult
     */
    @RequestMapping("/objTest")
    @ResponseBody
    public JsonResult objTest(@ModelAttribute("u1") User u1, @ModelAttribute("u2") User u2) {
        Map<String, User> dataMap = new HashMap<>(2);
        dataMap.put("u1", u1);
        dataMap.put("u2", u2);
        return new JsonResult<>(dataMap);
    }

    /**
     * ModelAttribute注解测试
     *
     * @param user        用户
     * @param allUserName 全局用户名称
     * @return JsonResult
     */
    @RequestMapping("/modelAttributeTest")
    @ResponseBody
    public JsonResult modelAttributeTest(@ModelAttribute("user") User user, @ModelAttribute("all_userName") String allUserName) {
        Map<String, Object> dataMap = new HashMap<>(2);
        dataMap.put("user", user);
        dataMap.put("all_userName", allUserName);
        return new JsonResult<>(dataMap);
    }

    /**
     * ExceptionHandler注解测试
     *
     * @return JsonResult
     */
    @RequestMapping("/exceptionHandlerTest")
    @ResponseBody
    public JsonResult exceptionHandlerTest(@RequestParam("exceptionClass") String exceptionClass) {
        if (EXCEPTION_LOCAL.equals(exceptionClass)) {
            throw new IllegalArgumentException("抛出局部异常！");
        }
        if (EXCEPTION_ALL.equals(exceptionClass)) {
            throw new NullPointerException("抛出全局异常！");
        }
        return new JsonResult<>("ExceptionHandler注解测试");
    }

    @Getter
    @Setter
    @ToString
    public static class User {
        private String name;
        private int age;
    }

}