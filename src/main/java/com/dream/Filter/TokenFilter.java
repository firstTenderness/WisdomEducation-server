package com.dream.Filter;

import com.dream.utils.CurrentHolder;
import com.dream.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        获取请求路径
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getServletPath();
        //        判断是否是登录请求，如果是登录请求，则放行

        if (path.contains("/login")){
            log.info("登录请求");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
//        获取请求头中的token
        String token = request.getHeader("token");
        log.info("获取请求头中的token：{}",token);
        //        判断token是否存在，如果不存在，说明用户，则返回错误信息
        if (token==null||token.isEmpty()){
            log.info("token不存在,用户未登录");
            response.setStatus(401);
            return;
        }
//        tonken存在，则解析token，判断token是否正确，，如果错误，则返回错误信息
        log.info("token存在，开始解析token");
        try {
            Claims claims = JwtUtils.parseJWT(token);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("当前用户id为：{}",empId);

        }catch (Exception e){
            log.info("token解析失败");
            response.setStatus(401);
        }

//      如果正确，则放行
        log.info("token解析成功");
        filterChain.doFilter(servletRequest,servletResponse);
        CurrentHolder.remove();
    }
}
