/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: tesk
 * Author:   allahbin
 * Date:     2019/8/1 14:14
 * Description: 定时任务
 */
package com.kk.bs.web.tesks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈定时任务〉
 *
 * @author allahbin
 * @create 2019/8/1
 * @since 1.0.0
 */
@Component
@EnableScheduling
public class Tesks {

    private final static Logger logger = LoggerFactory.getLogger(Tesks.class);

    // 每月1号的23点执行
    @Scheduled(cron = "0 0 23 1 * ?")
    public void deleteLog(){
        System.out.println("1121");
    }

}
