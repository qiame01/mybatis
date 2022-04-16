package com;

import com.ddd.UserMapper;
import com.uuu.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mybatis入门1
 * 1-依赖：web、mybatis、mysql驱动
 * 2-编写start和ddd目录下各文件：mapper映射文件(注意编写规范，如id同接口名)、mapper接口(要加@Mapper)、User实体类、Test类
 * 注意：由于在pom里配置了resources插件，所以mapper映射文件和接口，必须放在同一目录下(即同在ddd或同在start1下)，不然无法被该插件扫描到
 * 3-配置：application.properties配置1
 * 4-pom里添加resources插件，注意必须刷新pom(不实用，start2里将主要对其进行优化)
 * 5-运行项目，浏览器访问：http://localhost:9001/bbb/aaa?id=1
 * <p>
 * 注意(此注意的详细展开，见工程 mybatis_param 和 mybatis_return)：
 * 1-增删改查sql里属性 resultType 和 parameterType 的值都可以是：自定义实体类，mybatis内置类型别名。
 * 对于自定义实体类，可以设置类型别名，从而省略以上两个属性值里冗长的包名；
 * 而对于mybatis内置类型别名，则可以直接省掉包名。如java.util.List，可以直接写 list，且大小写不敏感 todo 百度 mybatis内置类型别名；
 * 2-parameterType 与 resultType 区别在于：parameterType 一般可以省略不写，而 resultType 不可省略。
 */
@RestController
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * http://localhost:9001/bbb/aaa?id=1
     */
    @RequestMapping("/aaa")
    public String aaa(String id) {

        User user = userMapper.selectUserById(id);

        return user.toString();
    }

}
