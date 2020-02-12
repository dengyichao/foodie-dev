package com.dyc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// # 扫描mybatis 通用 mapper 所在的包
@MapperScan(basePackages = "com.dyc.mapper")
// 扫描所有包及相关组件包
@ComponentScan(basePackages = {"com.dyc","org.n3r.idworker"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
