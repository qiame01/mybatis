package com;

import com.ddd.UserMapper;
import com.uuu.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 动态sql
 * <p>
 * 只演示if、foreach、sql片段。其他都不常用。如需要，再整理不迟
 * foreach有多种，见mapper映射文件
 * 动态sql的标签可用于增删改查任意sql类型
 */
@RestController
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * if
     */
    @RequestMapping("/aaa")
    public String aaa(String userName) {
        List<User> result = userMapper.getUsers(userName, "2");
        List<User> list2 = userMapper.getUsers(userName, "");
        List<User> list3 = userMapper.getUsers(null, "");
        System.out.println(result);
        System.out.println(list2);
        System.out.println(list3);
        return result.toString();
    }

    /**
     * foreach
     * 入参为list
     */
    @RequestMapping("/bbb")
    public String bbb(String userName) {
        User param = new User(null, userName, "1");
        User param2 = new User(null, userName + "2", "2");
        List<User> users = Arrays.asList(new User[]{param, param2});
        int result = userMapper.addUsers(users);
        return result + "";
    }


    /**
     * foreach
     * 入参为array
     * 入参为array或list时，mybatis会将该入参放入底层map，key默认为array或arg0，可自定义：@Param("自定义key")
     */
    @RequestMapping("/ccc")
    public String ccc(String userName) {
        List<User> result = userMapper.getUsersByIds(new Integer[]{1, 2, 3});
        return result.toString();
    }

    /**
     * foreach
     */
    @RequestMapping("/ddd")
    public String ddd(String userName) {
        int result = userMapper.deleteByIds(new Integer[]{1, 2, 3});
        return result + "";
    }

    /**
     * foreach
     */
    @RequestMapping("/eee")
    public String eee(String userName) {
        int result = userMapper.updateByIds(new Integer[]{1, 2, 3});
        return result + "";
    }

    /**
     * sql片段
     */
    @RequestMapping("/fff")
    public String fff(String userName) {
        User result = userMapper.getUser();
        return result.toString();
    }

}
