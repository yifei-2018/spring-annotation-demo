package com.yifei.spring.annotation.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yifei
 * @date 2019/11/6
 */
@Component("diyOneInterceptor")
public class DiyOneInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(DiyOneInterceptor.class);
    /**
     * 拦截器名称
     */
    private String interceptorName;

    @PostConstruct
    private void init() {
        interceptorName = this.getClass().getAnnotation(Component.class).value();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("*****拦截器【{}】 preHandle*****", interceptorName);
        request.setAttribute("startTimeMillis", System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTimeMillis = (long) request.getAttribute("startTimeMillis");
        logger.info("*****拦截器【{}】 postHandle 【{}】耗时【{}】ms*****", interceptorName, request.getServletPath(), System.currentTimeMillis() - startTimeMillis);
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("*****拦截器【{}】 afterCompletion*****", interceptorName);
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("*****拦截器【{}】 afterConcurrentHandlingStarted*****", interceptorName);
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}