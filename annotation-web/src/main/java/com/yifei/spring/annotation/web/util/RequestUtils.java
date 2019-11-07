package com.yifei.spring.annotation.web.util;

import com.yifei.spring.annotation.web.constant.CmnConstant;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @author yifei
 * @date 2019/11/7
 */
public class RequestUtils {
    private RequestUtils() {
    }

    /**
     * 获取servletPath
     *
     * @param request 请求
     */
    public static String getServletPath(HttpServletRequest request) {
        return request.getServletPath();
    }

    /**
     * 获取请求轨迹号
     *
     * @param request 请求
     * @return int
     */
    public static int getAndIncreaseTrackNum(ServletRequest request) {
        Object obj = request.getAttribute(CmnConstant.REQUEST_TRACK_KEY);
        int trackNum = obj == null ? 1 : (int) obj;
        request.setAttribute(CmnConstant.REQUEST_TRACK_KEY, trackNum + 1);
        return trackNum;
    }

    /**
     * 设置请求开始时间戳
     *
     * @param request 请求
     */
    public static void setStartTime(ServletRequest request) {
        request.setAttribute(CmnConstant.START_TIME_KEY, System.currentTimeMillis());
    }

    /**
     * 耗时
     *
     * @param request 请求
     * @return long
     */
    public static long takeUpTime(ServletRequest request) {
        Object obj = request.getAttribute(CmnConstant.START_TIME_KEY);
        long startTimeMillis = obj == null ? 1 : (long) obj;
        return System.currentTimeMillis() - startTimeMillis;
    }
}
