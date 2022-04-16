package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.ddd")
public class MybatisStart3Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisStart3Application.class, args);
    }

}
