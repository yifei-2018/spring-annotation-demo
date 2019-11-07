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
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
     * @param model   model
     */
    @ModelAttribute("user")
    private User setModelAttribute(HttpServletRequest request, Model model) {
        logger.info("*****轨迹号【{}】 InitBinderController:【{}】setModelAttribute*****", RequestUtils.getAndIncreaseTrackNum(request), this.getClass().getTypeName());
        User user = new User();
        user.setName("毅飞");
        user.setAge(27);
        return user;
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
        JsonResult<String> jsonResult = new JsonResult<>();
        jsonResult.setStatus(CmnConstant.SUCCESS_STATUS);
        jsonResult.setData("时间串：" + str);
        return jsonResult;
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
        JsonResult<String> jsonResult = new JsonResult<>();
        jsonResult.setStatus(CmnConstant.SUCCESS_STATUS);
        jsonResult.setData("时间串：" + date);
        return jsonResult;
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

        JsonResult<Map> jsonResult = new JsonResult<>();
        jsonResult.setStatus(CmnConstant.SUCCESS_STATUS);
        jsonResult.setData(dataMap);
        return jsonResult;
    }

    /**
     * ModelAttribute注解测试
     *
     * @param user 用户
     * @return JsonResult
     */
    @RequestMapping("/modelAttributeTest")
    @ResponseBody
    public JsonResult modelAttributeTest(@ModelAttribute("user") User user) {
        Map<String, User> dataMap = new HashMap<>(2);
        dataMap.put("user", user);

        JsonResult<Map> jsonResult = new JsonResult<>();
        jsonResult.setStatus(CmnConstant.SUCCESS_STATUS);
        jsonResult.setData(dataMap);
        return jsonResult;
    }

    @Getter
    @Setter
    @ToString
    public static class User {
        private String name;
        private int age;
    }

}