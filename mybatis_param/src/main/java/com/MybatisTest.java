package com;

import com.ddd.UserMapper;
import com.uuu.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 测试：mybatis接口入参类型
 * <p>
 * <p>
 * 一 预备知识
 * 预备知识1：sql接收接口入参的两种方式：#{}与${}
 * #{}与${}相同点：接收单个普通参数(注意是单个)且无@Param注解时，#{}与${}内部均可用任意名称接收
 * #{}与${}不同点：
 * #{}本质是占位符，会自动补充单引号(见控制台sql日志)
 * ${}本质是字符串拼接，不会自动补充单引号。故若属性是String类型，则${}的外层必须手动加单引号。若不加引号，则可动态传递表名
 * <p>
 * 预备知识2：mybatis在接收多个普通参数(或者入参为实体类/map/list/array)时，底层会将入参放入一个map里，key有默认值(报错时会打印)
 * 底层map默认的key：或与普通参数名相同，或为param1、param2...或与实体类属性名和map的key相同
 * 但在方法入参上手动添加@Param(自定义key名)，可以自定义底层map看key
 * <p>
 * <p>
 * 二 接口入参类型
 * 普通参数、map、实体类、list或array
 * 设定1：a.接收普通参数/array/list时，接口方法入参上一律加@Param(自定义key名)；b.接收实体类/map参数时，不用加注解
 * 设定2：sql里通常用 #{}接收，故以下采用这种方式接受参数
 * <p>
 * <p>
 * 三 注意
 * 1 增删改查sql上的属性 parameterType 均可以省略，它的值可以是：自定义实体类，mybatis内置类型别名(如java.util.List)
 * 2 查询时返回值全部采用 resultType(关于返回值类型详情，见 mybatis_return)
 * 3 #{}和${}以及@Param，对于sql的增删改查都适用，不唯select语句。动态sql也是同理
 */
@RestController
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 预备知识1：sql接收接口入参的两种方式：#{}与${}
     * 单个普通参数，且不加@Param注解
     * http://localhost:9001/bbb/aaa?userName=aaa
     */
    @RequestMapping("/aaa")
    public String aaa(String userName) {
        // #{任意名称}，外层不加引号
        User user1 = userMapper.selectUserByUserName1(userName);
        // '${任意名称}'，外层加引号
        User user2 = userMapper.selectUserByUserName2(userName);
        // ${表名}：原理：因为${}本质上是字符串拼接，不会自动补充单引号，故可传递表名
        String tableName = "mybatis_aaa_user";
        User user3 = userMapper.selectUserByTableName(tableName, userName);

        return ""
                + "#{任意名称}：" + user1.toString() + "<br>"
                + "${任意名称}：" + user2.toString() + "<br>"
                + "${表名}：" + user3.toString() + "<br>"
                ;
    }

    /**
     * 普通参数
     * 底层map的key，就是接口方法上@param里自定义的key。若接口方法不加@Param，则默认在sql里使用入参名作为key
     * 若既不加@Param，又不与入参名一致，则报错，并给出可用的key：Available parameters are [userName, param1, age, param2]
     */
    @RequestMapping("/bbb")
    public String bbb(String userName, String age) {
        User user = userMapper.selectUserByCommon(userName, age);
        return user.toString();
    }

    /**
     * map参数
     * 底层map的key，就是入参map的key，接口方法无需再加@Param
     */
    @RequestMapping("/ccc")
    public String ccc(String userName) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        User user = userMapper.selectUserByMap(map);
        return user.toString();
    }

    /**
     * 实体类参数(本质上跟上面的map入参一样)
     * 底层map的key，就是实体类的属性名，接口方法无需再加@Param
     */
    @RequestMapping("/ddd")
    public String ddd(String userName) {
        User param = new User();
        param.setUserName(userName);
        int result = userMapper.insertUser(param); // 测试入参类型和接收参数，与sql的增删改查类型无关
        return result + "";
    }

    /**
     * list参数
     * 批量插入
     */
    @RequestMapping("/eee")
    public String eee(String userName) {
        User param = new User(null, userName, "1");
        User param2 = new User(null, userName + "2", "2");
        List<User> users = Arrays.asList(new User[]{param, param2});
        int result = userMapper.insertUsers(users);
        return result + "";
    }
}
