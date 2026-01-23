package com.dream.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration // 标记为配置类
public class CorsConfig {

    // 注册跨域过滤器
    @Bean
    public CorsFilter corsFilter() {
        // 1. 创建跨域配置对象
        CorsConfiguration config = new CorsConfiguration();
        // 允许所有前端域名访问（开发环境用*，生产环境建议指定具体域名，如http://localhost:5173）
        config.addAllowedOriginPattern("*");
        // 允许跨域携带Cookie（如果需要）
        config.setAllowCredentials(true);
        // 允许所有请求方法（GET/POST/PUT/DELETE等）
        config.addAllowedMethod("*");
        // 允许所有请求头
        config.addAllowedHeader("*");
        // 预检请求的缓存时间（秒），减少预检请求次数
        config.setMaxAge(3600L);

        // 2. 配置跨域规则生效的路径（/** 表示所有接口）
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        // 3. 返回跨域过滤器
        return new CorsFilter(source);
    }
}