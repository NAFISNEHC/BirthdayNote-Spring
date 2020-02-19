/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: BaseController
 * Author:   allahbin
 * Date:     2019/9/23 10:27
 * Description: 基础的Controller方法
 */
package com.kk.bs.comm.utils;

import com.kk.common.utils.JSONUtil;
import com.kk.common.vo.LoginUser;
import com.kk.common.vo.TokenUser;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈基础的Controller方法〉
 *
 * @author allahbin
 * @create 2019/9/23
 * @since 1.0.0
 */
public class BaseController {

    @Resource
    RedisTemplate<String, String> redisTemplate;

    protected TokenUser getUserInfo(HttpServletRequest request){
        String userJson = redisTemplate.opsForValue().get(request.getHeader("userToken"));
        return (TokenUser) JSONUtil.toBean(userJson, TokenUser.class);
    }
}
