package com;

import com.ddd.EmployeeMapper;
import com.ddd.ShopMapper;
import com.uuu.Employee;
import com.uuu.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试：mybatis的sql返回值类型。分为两类：resultType-自动映射、resultMap-自定义映射
 * 它们都属于查询，故可归类在工程mybatis_query
 * resultType-此处略，见工程mybatis_query
 * <p>
 * resultMap
 * <p>
 * 一、返回一个简单实体类
 * 1 返回一个简单实体类
 * <p>
 * 二、多对一
 * 1 多对一.join方式
 * 2 多对一.分步查询
 * sql注意点：
 * association
 * select：方法的全类名.方法名
 * column：外层sql的属性，会传递给分步查询sql作为其查询条件
 * 3 多对一.分步查询.懒加载
 * 开启懒加载：配置4：mybatis.configuration.lazy-loading-enabled=true
 * 开启懒加载后，只有当访问到某个类时(包括该类下嵌套的类)，如result.getId()，才会执行该sql查询
 * 开启懒加载后，再灵活设置个别sql立即加载：在sql里设置：fetchType="eager"
 * 若未开启懒加载，则fetchType无论取值是什么，fetchType都不会生效，它只基于开启懒加载后
 * <p>
 * 三、一对多
 * 一对多.join方式
 * 一对多.分步查询
 * sql注意点：
 * collection
 * select：方法的全类名.方法名
 * column：外层sql的属性，会传递给分步查询sql作为其查询条件
 * 一对多.分步查询.懒加载
 * <p>
 * 四、返回自增主键的两种方式
 * 1-使用数据库的主键生成策略：在sql上添加属性：useGeneratedKeys="true" keyProperty="id"
 * 2-sql里添加标签：selectkey。注意：mysql和oracle，对此的支持不同
 *
 * 注意：todo 待测试：批量插入后的主键是否能够获取？
 */
@RestController
public class MybatisTest {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private ShopMapper shopMapper;

    /**
     * resultMap.返回一个简单实体类
     */
    @RequestMapping("/aaa")
    public String aaa(String userName) {
        Employee result = employeeMapper.getEmployee();
        return result.toString();
    }

    /**
     * resultMap.多对一.join方式
     */
    @RequestMapping("/bbb")
    public String bbb(String userName) {
        Employee result = employeeMapper.getEmployAndDeptJoin();
        return result.toString();
    }

    /**
     * resultMap.多对一.分步查询
     */
    @RequestMapping("/ccc")
    public String ccc(String userName) {
        Employee result = employeeMapper.getEmployAndDeptLazy();
        return result.toString();
    }

    /**
     * resultMap.多对一.分步查询.懒加载
     */
    @RequestMapping("/ddd")
    public String ddd(String userName) {
        Employee result = employeeMapper.getEmployAndDeptEager();
        result.getId(); // 开启全局懒加载后，访问了哪个类，才会执行该sql查询，见控制台打印
        System.out.println("*************************");
        result.getDept(); // 访问该类时，才会执行该sql查询
        return "请查看控制台";
    }

    /**
     * resultMap.一对多.join方式
     */
    @RequestMapping("/eee")
    public String eee(String userName) {
        List<Shop> result = shopMapper.getClerksJoin();
        return result.toString();
    }

    /**
     * resultMap.一对多.分步查询
     * 注意：不能在Employee中反向引入Dept作为属性。
     * 此时，为了防止套娃似查询，需要启用新的实体类：Dept2、Employee2、及对应的接口和映射文件
     */
    @RequestMapping("/fff")
    public String fff(String userName) {
        Shop result = shopMapper.getClerksLazy();
        return result.toString();
    }

    /**
     * resultMap.一对多.分步查询.懒加载
     * 注意：不能在Employee中反向引入Dept作为属性
     */
    @RequestMapping("/ggg")
    public String ggg(String userName) {
        Shop result = shopMapper.getClerksEager();
        return result.toString();
    }


    /**
     *     User insertUserReturnId(User user);
     */

    /*
        User insertUserReturnId(User user);
    <!--返回自增主键-->
    <insert id="insertUserReturnId" useGeneratedKeys="true" keyProperty="id">
    insert into mybatis_aaa_user(user_name, age)
    values (#{userName}, #{age})
    </insert>


     */


}
