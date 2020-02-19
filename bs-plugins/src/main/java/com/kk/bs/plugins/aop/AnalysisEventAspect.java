/**
 * Copyright (C), 2015-2018, 知融科技服务有限公司
 * FileName: AnalysisActuatorAspect
 * Author:   56969
 * Date:     2018/8/28 23:58
 * Description: AnalysisActuator的切面
 */
package com.kk.bs.plugins.aop;

import com.kk.bs.plugins.annotation.EventActuator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br>
 * 〈AnalysisActuator的切面，这个切面，只对credit和dolog的表进行记录，记录事件的不同的状态〉
 *
 * @author 唐斌
 * @create 2018/8/28
 * @since 1.0.0
 */
@Aspect
@Component
public class AnalysisEventAspect {

    private final static Logger log = LoggerFactory.getLogger(AnalysisEventAspect.class);

    private ThreadLocal<Long> beginTime = new ThreadLocal<>();

    @Pointcut("@annotation(eventActuator)")
    public void serviceStatistics(EventActuator eventActuator) {
    }

    @Before(value = "serviceStatistics(eventActuator)", argNames = "joinPoint,eventActuator")
    public void doBefore(JoinPoint joinPoint, EventActuator eventActuator) {
        // 记录请求到达时间
        beginTime.set(System.currentTimeMillis());
        // 方法的说明
        log.info("说明:{}", eventActuator.explain());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
    }

    @After("serviceStatistics(eventActuator)")
    public void doAfter(EventActuator eventActuator) {
        log.info("调用该方法使用的时间:{}, 调用说明:{}", System.currentTimeMillis() - beginTime.get(), eventActuator.explain());
    }

}