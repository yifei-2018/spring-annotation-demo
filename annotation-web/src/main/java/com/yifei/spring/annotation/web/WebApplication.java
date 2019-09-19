package com.yifei.spring.annotation.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author yifei
 * @date 2019/9/19
 */
@SpringBootApplication
public class WebApplication {
    private static final Logger logger = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(WebApplication.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        logger.info("【{}】服务启动成功！端口：【{}】", environment.getProperty("spring.application.name"), environment.getProperty("server.port"));
    }
}
