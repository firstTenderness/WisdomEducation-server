package com.dream.Interceptor;

import com.dream.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        //        判断是否是登录请求，如果是登录请求，则放行

        if (path.contains("/login")) {
            log.info("登录请求");
            return true;
        }
//        获取请求头中的token
        String token = request.getHeader("token");
        log.info("获取请求头中的token：{}", token);
        //        判断token是否存在，如果不存在，说明用户，则返回错误信息
        if (token == null || token.isEmpty()) {
            log.info("token不存在,用户未登录");
            response.setStatus(401);
            return false;
        }
//        tonken存在，则解析token，判断token是否正确，，如果错误，则返回错误信息
        log.info("token存在，开始解析token");
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            log.info("token解析失败");
            response.setStatus(401);
        }

//      如果正确，则放行
        log.info("token解析成功");
        return true;
    }
}