package com.dyc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    public CorsConfig() {
    }

    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:8080");
        corsConfiguration.addAllowedOrigin("http://192.168.80.139:8080");
        corsConfiguration.addAllowedOrigin("http://192.168.80.139"); // 为以后准备
        // 设置是否发送cookie
        corsConfiguration.setAllowCredentials(true);
        // 设置允许请求的方式
        corsConfiguration.addAllowedMethod("*");
        // 设置允许的header
        corsConfiguration.addAllowedHeader("*");

        // 2.为url添加映射路径
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(corsSource);

    }
}
