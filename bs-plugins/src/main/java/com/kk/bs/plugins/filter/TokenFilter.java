package com.kk.bs.plugins.filter;

import com.kk.bs.comm.constant.AuthorityConstants;
import com.kk.common.utils.JSONUtil;
import com.kk.common.utils.Result;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * 用户的令牌判断，对于一些API，获取资源的访问，我们需要对用户进行拦截
 */
public class TokenFilter implements Filter {

    private Environment env;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        RedisTemplate<String, String> redisTemplate = (RedisTemplate<String, String>) ctx.getBean("redisTemplate");
        env = (Environment) ctx.getBean("environment");
    }

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String token = request.getHeader(AuthorityConstants.TOKEN_STR);
        if ("OPTIONS".equals(request.getMethod())) {
            response.setHeader("Access-Control-Allow-Headers", "content-type, accept");
            response.setHeader("Access-Control-Allow-Methods", "POST");
            response.setStatus(200);
            response.setContentType("text/plain;charset=utf-8");
            req.setCharacterEncoding("utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(req, res);
        } else {
            String active = env.getProperty("kk.permissions");
            // 检查是否开启权限验证
            if (Objects.equals(active, "false")) {
                chain.doFilter(req, res);
            }else if(token != null){
                // 不对权限进行拦截
                chain.doFilter(req, res);
            }else{
                req.setCharacterEncoding("UTF-8");
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out = response.getWriter();
                String outstr = JSONUtil.toJson(Result.error("没有权限或token已过期，请重新登录"));
                out.write(outstr);
                out.flush();
                out.close();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
