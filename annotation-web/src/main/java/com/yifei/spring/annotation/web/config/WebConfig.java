package com.yifei.spring.annotation.web.config;

import com.yifei.spring.annotation.web.interceptor.DiyOneInterceptor;
import com.yifei.spring.annotation.web.interceptor.DiyTwoInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * 拦截器配置类
 *
 * @author yifei
 * @date 2019/11/7
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

    @Resource
    private DiyOneInterceptor diyOneInterceptor;
    @Resource
    private DiyTwoInterceptor diyTwoInterceptor;

    /**
     * 添加拦截器
     *
     * @param registry 拦截器注册
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(diyOneInterceptor).addPathPatterns("/**").order(1);
        registry.addInterceptor(diyTwoInterceptor).addPathPatterns("/**").order(2);
        super.addInterceptors(registry);
        logger.info("拦截器注册：【{},{}】", diyOneInterceptor.getClass().getName(), diyTwoInterceptor.getClass().getName());
    }
}
