package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

// 除了以下 value、basePackages，还有多个属性可以扫描mapper接口，点进去看
//@MapperScan(basePackages = {"mybatis_start.ccc","mybatis_start.ddd"}) // 多个mapper接口目录
//@MapperScan(basePackages = "mybatis_start.ddd")
//@MapperScan(value = "mybatis_start.ddd")
@MapperScan("com.ddd")
public class MybatisStart2Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisStart2Application.class, args);
    }

}
