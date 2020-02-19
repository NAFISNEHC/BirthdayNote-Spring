package com.kk.bs.plugins.annotation;

import java.lang.annotation.*;

/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: Authority
 * Author:   唐斌
 * Date:     2019/1/29 17:00
 * Description: 用于进行方法的权限控制
 * History:
 * <author>          <time>          <version>          <desc>
 * 唐斌           2019/1/29 17:00          版本号              用于进行方法的权限控制
 */
@Target({ElementType.TYPE, ElementType.METHOD}) // ElementType.TYPE，ElementType.METHOD表示注解可以标记类和方法
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AuthorityActuator {

    /**
     * 单个权限使用这个
     */
    String value() default "";

    /**
     * 配置多个权限使用这个
     */
    String[] values() default {};
}