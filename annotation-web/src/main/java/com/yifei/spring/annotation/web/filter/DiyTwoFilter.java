package com.yifei.spring.annotation.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author yifei
 * @date 2019/11/4
 */
@WebFilter(filterName = "diyTwoFilter", urlPatterns = "/*")
@Configuration
@Order(2)
public class DiyTwoFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(DiyTwoFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("*****【{}】 init*****", this.getClass().getSimpleName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("*****【{}】 doFilter*****", this.getClass().getSimpleName());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("*****【{}】 destroy*****", this.getClass().getSimpleName());
    }
}
