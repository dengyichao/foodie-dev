package com.dyc;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @description:  打包war【4】 创建war启动类
 * @author: dengyichao
 * @createDate: 2020/3/1
 * @version: 1.0
 */

public class WarStaticApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 只想Application这个springboot启动类
        return super.configure(builder.sources(Application.class));
    }
}
