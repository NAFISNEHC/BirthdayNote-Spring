/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: RestTemplate
 * Author:   allahbin
 * Date:     2019/8/6 13:10
 * Description:
 */
package com.kk.bs.plugins;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author allahbin
 * @create 2019/8/6
 * @since 1.0.0
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

}
