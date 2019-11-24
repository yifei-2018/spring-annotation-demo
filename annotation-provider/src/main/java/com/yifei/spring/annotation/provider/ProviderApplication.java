package com.yifei.spring.annotation.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author yifei
 * @date 2019/11/14
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:dubbo-provider.xml"})
public class ProviderApplication {

    private static final Logger logger = LoggerFactory.getLogger(ProviderApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProviderApplication.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        logger.info("【{}】服务启动成功！端口：【{}】", environment.getProperty("spring.application.name"), environment.getProperty("server.port"));
    }
}
