package com;

import com.ddd.UserMapper;
import com.uuu.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * mybatis入门2
 * 1-对入门1进行两处优化
 * 2-测试：mybatis配置方式1：所有配置均放在application.properties的mybatis.configuration属性下(不包括mybatis.mapper-locations，二者平级)
 * 注意：如果配置了mybatis.configuration属性，就不能再配置mybatis全局配置文件位置(mybatis.config-location)这个属性，不然启动时会冲突
 * <p>
 * 优化1：去掉入门1中pom里resources插件
 * 1-各依赖同入门1；注释掉resources插件(如果不是自动引入，则注意必须刷新一下pom才生效)
 * 2-在application.properties里，配置自定义的mapper映射文件位置(在配置1基础上，增加配置2)
 * 3-将mapper映射文件，迁移到上一步自定义目录下，如类路径下resources/mapper/aaa
 * 4-运行项目，浏览器访问：http://localhost:9001/bbb/bbb?id=1（此时，访问bbb/aaa则无法访问，因为mapper映射文件已经指定了新目录）
 * <p>
 * 优化2：@MapperScan 取代 @Mapper
 * 1-去掉所有mapper接口上的 @Mapper
 * 2-在启动类上面添加 @MapperScan(指定一个或多个mapper接口目录)
 */
@RestController
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * http://localhost:9001/bbb/bbb?id=1
     */
    @RequestMapping("/bbb")
    public String bbb(String id) {

        User user = userMapper.selectUserById(id);

        return user.toString();
    }


}
