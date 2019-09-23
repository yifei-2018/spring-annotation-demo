package com.yifei.spring.annotation.web.controller;

import com.yifei.spring.annotation.web.constant.CmnConstant;
import com.yifei.spring.annotation.web.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yifei
 * @date 2019/9/19
 */
@RequestMapping("/study")
@RestController
public class StudyController {
    private static final Logger logger = LoggerFactory.getLogger(StudyController.class);

    @RequestMapping(value = "/show/{data}", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult show(@PathVariable String data) {
        JsonResult<String> jsonResult = new JsonResult<>();
        jsonResult.setStatus(CmnConstant.SUCCESS_STATUS);
        jsonResult.setData(data);
        return jsonResult;
    }
}
