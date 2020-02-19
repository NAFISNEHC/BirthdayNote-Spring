package com.kk.bs.passport.config;

import com.kk.bs.plugins.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TokenConfig {
	
	@Bean
	public FilterRegistrationBean<TokenFilter> jwtFilterRegistrationBean(){
	    FilterRegistrationBean<TokenFilter> registrationBean = new FilterRegistrationBean<TokenFilter>();
	    registrationBean.setFilter(new TokenFilter());
	    List<String> urlPatterns = new ArrayList<String>(); 
	    urlPatterns.add("/*");
	    registrationBean.setUrlPatterns(urlPatterns); 
	    return registrationBean; 
	}
}
