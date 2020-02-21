package com.dyc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// # 扫描mybatis 通用 mapper 所在的包
@MapperScan(basePackages = "com.dyc.mapper")
// 扫描所有包及相关组件包
@ComponentScan(basePackages = {"com.dyc","org.n3r.idworker"})
@EnableScheduling  // 开启定时任务
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
