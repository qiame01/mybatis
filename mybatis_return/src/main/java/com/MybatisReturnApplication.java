package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ddd")
public class MybatisReturnApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisReturnApplication.class, args);
    }

}
