package com.example.demonew;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
@ServletComponentScan//开启过滤器filter支持
@SpringBootApplication
@ComponentScan(basePackages ="com.example" )//扫描thymeleaf模板
@MapperScan("com.example.demonew.mapper")//扫描xml配置文件
public class DemoNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoNewApplication.class, args);
    }

}
