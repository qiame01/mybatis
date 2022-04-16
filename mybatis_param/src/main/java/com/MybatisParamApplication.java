package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ddd")
public class MybatisParamApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisParamApplication.class, args);
    }

}
