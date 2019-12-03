package com.yifei.spring.annotation.web.controller;

import com.yifei.spring.annotation.web.model.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * value注解测试
 * <br/>拓展：
 * <ul>
 *     <li><a href="https://www.cnblogs.com/wangbin2188/p/9014837.html">#{}与${}注入的区别</a></li>
 * </ul>
 *
 * @author yifei
 * @date 2019/12/3
 */
@RequestMapping("/value")
@RestController
public class ValueController {
    private static final Logger logger = LoggerFactory.getLogger(ValueController.class);

    /**
     * 注入普通数值
     */
    @Value("#{1}")
    private int number;
    /**
     * 注入普通字符串
     */
    @Value("normal")
    private String normalStr;
    /**
     * 注入操作系统属性
     */
    @Value("#{systemProperties['os.name']}")
    private String sysPropertiesName;
    /**
     * 注入表达式结果
     */
    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double expressResult;
    /**
     * 注入其他Bean属性或方法
     */
    @Value("#{diyOneInterceptor.getInterceptorName()}")
    private String anotherBeanAttribute;
    /**
     * 注入文件资源
     */
    @Value("classpath:test.txt")
    private Resource fileResource;
    /**
     * 注入URL资源
     */
    @Value("https://www.baidu.com/img/superlogo_c4d7df0a003d3db9b65e9ef0fe6da1ec.png?where=super")
    private Resource urlResource;

    /**
     * 测试
     * <ul>
     *     <li><a href="http://localhost:8081/annotation-web/value/test">http://localhost:8081/annotation-web/value/test</a></li>
     * </ul>
     *
     * @return JsonResult
     */
    @RequestMapping("/test")
    public JsonResult test() throws IOException {
        logger.info("普通数值：【{}】", number);
        logger.info("普通字符串：【{}】", normalStr);
        logger.info("操作系统属性：【{}】", sysPropertiesName);
        logger.info("表达式结果：【{}】", expressResult);
        logger.info("其他Bean属性或方法：【{}】", anotherBeanAttribute);
        logger.info("文件资源：【{}】", fileResource.getDescription());
        logger.info("URL资源：【{}】", urlResource.contentLength());
        return new JsonResult<>("@value测试成功");
    }
}
