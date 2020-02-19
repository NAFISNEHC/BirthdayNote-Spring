/**
 * Copyright (C), 2015-2018, 知融科技服务有限公司
 * FileName: AnalysisActuator
 * Author:   56969
 * Date:     2018/8/28 23:57
 * Description: 统计方法执行时间的注解
 */
package com.kk.bs.plugins.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 〈一句话功能简述〉<br>
 * 〈统计方法执行时间的注解〉
 *
 * @author 唐斌
 * @create 2018/8/28
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventActuator {

    /**
     * 说明，也就是执行某个方法的说明
     * @return
     */
    String explain() default "";

    /**
     * 操作类型
     * @return
     */
    String operation() default "";

    /**
     * 操作的字段
     */
    String column() default "";
}