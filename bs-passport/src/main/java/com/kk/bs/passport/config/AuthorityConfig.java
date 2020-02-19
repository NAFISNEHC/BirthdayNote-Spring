/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: AuthorityConfig
 * Author:   Zeling
 * Date:     2019/1/29 17:23
 * Description: 权限的配置
 */
package com.kk.bs.passport.config;

import com.kk.bs.plugins.Interceptor.AuthorityInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈权限的配置〉
 *
 * @author Zeling
 * @create 2019/1/29
 * @since 1.0.0
 */
@Configuration
public class AuthorityConfig implements WebMvcConfigurer {

    private final static Logger logger = LoggerFactory.getLogger(AuthorityConfig.class);

    // 拦截器需要进行bean化才能注入redis或者是其他的service
    @Bean
    public AuthorityInterceptor getAuthorityInterceptor(){
        return new AuthorityInterceptor();
    }

    /**
     * 重写添加拦截器方法并添加配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("注册拦截器");
        registry.addInterceptor(getAuthorityInterceptor())
                .addPathPatterns("/**")
                // 排除静态资源地址
                .excludePathPatterns("classpath:/static/");
    }
}
