/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: AuthorityInterceptor
 * Author:   唐斌
 * Date:     2019/1/29 17:02
 * Description: 权限拦截器
 */
package com.kk.bs.plugins.Interceptor;

import com.kk.bs.plugins.annotation.AuthorityActuator;
import com.kk.common.utils.JSONUtil;
import com.kk.common.utils.ZlStringUtil;
import com.kk.common.vo.LoginUser;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 〈一句话功能简述〉<br> 
 * 〈权限拦截器〉
 *
 * @author Zeling
 * @create 2019/1/29
 * @since 1.0.0
 */
public class AuthorityInterceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(AuthorityInterceptor.class);

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private Environment env;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进行权限验证");
        String active = env.getProperty("theling.permissions");
        // 检查是否开启权限验证
        if (!Objects.equals(active, "false")) {
            return true;
        }
        // 验证权限
        if (this.hasPermission(request,handler)) {
            return true;
        }
        // 如果没有权限 则抛403异常 springboot会处理，这里将会按照http状态码进行处理
        response.sendError(HttpStatus.FORBIDDEN.value(), "无权限");
        return false;
    }

    /**
     * 是否有权限
     *
     * @param handler
     * @return
     */
    private boolean hasPermission(HttpServletRequest request, Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 获取方法上的注解
            AuthorityActuator authorityActuator = handlerMethod.getMethod().getAnnotation(AuthorityActuator.class);
            // 如果方法上的注解为空 则获取类的注解
            if (authorityActuator == null) {
                authorityActuator = handlerMethod.getMethod().getDeclaringClass().getAnnotation(AuthorityActuator.class);
            }
            // 对注解进行判断
            if (authorityActuator != null && (StringUtils.isNotBlank(authorityActuator.value()) || authorityActuator.values().length > 0)) {
                // 从redis获取用户的信息
                String tokenUser = redisTemplate.opsForValue().get(request.getHeader("usertoken"));
                if(tokenUser == null) {
                    return false;
                }
                // TODO 是否有其他的方法进行转换？
                String newStr = ZlStringUtil.trimStringWith(StringEscapeUtils.unescapeJava(tokenUser), '"');
                LoginUser user = (LoginUser) JSONUtil.toBean(newStr, LoginUser.class);
                // 用户不存在
                if (StringUtils.isEmpty(user.getUsertype()) ){
                    return false;
                }
                // 判断权限是否符合，这里做了多角色的判断
                return (user.getUsertype().equals(authorityActuator.value()) || ArrayUtils.contains(authorityActuator.values(), user.getUsertype()));
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // TODO
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO
    }

}
