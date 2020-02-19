/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: CommTime
 * Author:   allahbin
 * Date:     2019/9/20 17:47
 * Description: 常用的时间
 */
package com.kk.bs.passport.constant;

/**
 * 〈一句话功能简述〉<br> 
 * 〈常用的时间〉
 *
 * @author allahbin
 * @create 2019/9/20
 * @since 1.0.0
 */
public enum CommTime{
    MON(24 * 3600 * 30, "一个月"),
    WED(24 + 3600 * 7, "一周"),
    DAY(24 * 3600, "一天"),
    HOUR(3600, "一个小时");

    /**
     * 时间
     */
    private long time;
    /**
     * 描述
     */
    private String desc;

    CommTime(long i, String desc) {
        this.time = i;
        this.desc = desc;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}