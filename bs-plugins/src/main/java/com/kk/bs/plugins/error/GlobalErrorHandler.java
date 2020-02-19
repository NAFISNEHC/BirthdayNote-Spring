package com.kk.bs.plugins.error;

import com.kk.common.vo.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 主要用途：统一处理错误/异常(针对控制层)
 * 使用说明:
 * {@link ControllerAdvice 默认扫描路径：例如com.hehe.controller}
 * {@link ExceptionHandler 指定捕捉异常}
 * {@link ModelAndView 返回异常信息页(View)}
 * {@link ResponseBody 返回异常信息(JSON)}
 * <p>
 * 使用@ExceptionHandler时候需注意如下几点：
 * 1.获取异常：直接在方法参数注入
 * 2.常见缺点：无法捕捉404类异常
 * 3.替代方案：实现ErrorController
 *
 * @author yizhiwazi
 */

@ControllerAdvice("com.kk.bs")
public class GlobalErrorHandler {

    @Value("${spring.profiles.active}")
    private String environment;

    private final static Logger logger = LoggerFactory.getLogger(GlobalErrorHandler.class);

    /**
     * 错误信息页
     */
    private final static String DEFAULT_ERROR_VIEW = "error/500";

    /**
     * 错误信息构建器
     */
    @Resource
    private ErrorInfoBuilder errorInfoBuilder;

    /**
     * 根据业务规则,统一处理异常。
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(HttpServletRequest request, Throwable error, HttpServletResponse response) {
        ErrorInfo errorInfo = errorInfoBuilder.getErrorInfo(request, error);
        logger.error(errorInfo.getError(), error);
        // 如果是开发模式
        if("prod".equals(environment)){
            response.setStatus(500);
            Map<String,Object> map = new HashMap<>();
            map.put("code",500);
            map.put("msg", "系统错误，请联系管理员");
            return map;
        }else{
            //1.其余请求,则返回指定的异常信息页(View).
            if (isBrowserRequest(request)) {
                return new ModelAndView(DEFAULT_ERROR_VIEW, "errorInfo", errorInfo);
            }
            //2.若为AJAX请求,则返回异常信息(JSON)
            response.setStatus(500);
            return errorInfo;
        }
    }

    private boolean isBrowserRequest(HttpServletRequest request) {

        return request.getHeader("User-Agent").startsWith("Mozilla");
    }

}