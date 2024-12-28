package org.leye.maven.pinitbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author leye
 * @version 1.0
 * @description: TODO
 * @date 2024/12/27 23:48
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 配置所有请求路径允许跨域
        registry.addMapping("/**")  // 配置允许跨域的请求路径
                .allowedOrigins("http://localhost:3000")  // 允许访问的来源地址
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的 HTTP 方法
                // .allowedHeaders("Content-Type", "Authorization")  // 允许的请求头
                .allowedHeaders("*")  // 允许的请求头
                .allowCredentials(true);  // 允许跨域请求中携带认证信息（如 cookies）
    }
}
