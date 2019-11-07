package com.yifei.spring.annotation.web.constant;

/**
 * 常量类
 *
 * @author yifei
 * @date 2019/9/20
 */
public class CmnConstant {
    private CmnConstant() {
    }

    /**
     * 成功状态码
     */
    public static final String SUCCESS_STATUS = "10000";
    /**
     * 失败状态码
     */
    public static final String FAIL_STATUS = "55555";
    /**
     * 请求轨迹key
     */
    public static final String REQUEST_TRACK_KEY = "trackNum";
    /**
     * 请求开始时间戳key
     */
    public static final String START_TIME_KEY = "startTimeMillis";
}
