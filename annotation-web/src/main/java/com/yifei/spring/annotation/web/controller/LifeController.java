package com.yifei.spring.annotation.web.controller;

import com.yifei.spring.annotation.web.model.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * GetMapping、PostMapping注解测试
 *
 * @author yifei
 * @date 2019/9/23
 */
@RequestMapping("/life")
@Controller
public class LifeController {

    /**
     * GetMapping注解测试
     * <ul>
     *     <li><a href="http://localhost:8081/annotation-web/life/get">http://localhost:8081/annotation-web/life/get</a></li>
     * </ul>
     *
     * @return JsonResult
     */
    @GetMapping("/get")
    @ResponseBody
    public JsonResult get() {
        return new JsonResult<>("All life is an experiment．The more experiments you make the better．");
    }

    /**
     * PostMapping注解测试
     * <ul>
     *     <li><a href="http://localhost:8081/annotation-web/life/post">http://localhost:8081/annotation-web/life/post</a></li>
     * </ul>
     *
     * @return JsonResult
     */
    @PostMapping("/post")
    @ResponseBody
    public JsonResult post() {
        return new JsonResult<>("We do not live an equal life，but one of contrasts and patchwork；now a little joy，then a sorrow，now a sin，then a generous or brave action．");
    }

}
