package com;

import com.ddd.UserMapper;
import com.uuu.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mybatis入门3
 * 测试：mybatis配置方式2：mybatis全局配置文件
 * <p>
 * 1-导入相关依赖；准备mybatis_start目录下各文件；在启动类上加@MapperScan("mapper接口目录")
 * 2-类路径(resources目录)下创建mapper映射文件(UserMapper.xml) 和 mybatis全局配置文件(mybatis-config.xml)
 * 3-在application.properties里追加【配置3】：自定义两个文件位置：mybatis全局配置文件、映射文件
 * 4-启动项目，浏览器测试：http://localhost:9001/bbb/ccc?id=1
 */
@RestController
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * http://localhost:9001/bbb/ccc?id=1
     */
    @RequestMapping("/ccc")
    public String ccc(String id) {

        User user = userMapper.selectUserById(id);

        return user.toString();
    }

}