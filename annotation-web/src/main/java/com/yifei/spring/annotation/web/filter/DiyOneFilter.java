package com.yifei.spring.annotation.web.filter;

import com.yifei.spring.annotation.web.util.RequestUtils;
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
@WebFilter(filterName = "diyOneFilter", urlPatterns = "/*")
@Configuration
@Order(1)
public class DiyOneFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(DiyOneFilter.class);
    /**
     * 过滤器配置
     */
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        logger.info("*****过滤器【{}】 init*****", this.filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("*****轨迹号【{}】 过滤器【{}】 doFilter 客户端向Servlet发送的请求被拦截*****", RequestUtils.getAndIncreaseTrackNum(servletRequest), filterConfig.getFilterName());
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("*****轨迹号【{}】 过滤器【{}】 doFilter Servlet向客户端发送的响应被拦截*****", RequestUtils.getAndIncreaseTrackNum(servletRequest), filterConfig.getFilterName());
    }

    @Override
    public void destroy() {
        logger.info("*****过滤器【{}】 destroy*****", filterConfig.getFilterName());
    }
}
