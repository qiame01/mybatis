package com;

import com.ddd.UserMapper;
import com.ddd.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.uuu.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 各种查询
 * 注意：见工程 mybatis_start1 下-注意(类 MybatisTest)
 * <p>
 * 查询.list
 * 查询.count：1 count(*)效果同count(1)；2 count(字段名)：不能用。因为如果该字段值为空，该行就会被忽略
 * 查询.返回一条记录的map形式
 * 查询.返回List<map>
 * 查询.返回List<map>，每个map带key
 * 查询.模糊
 * 查询.分页：1 创建全局配置文件：mybatis-config.xml，并在里面配置插件：PageInterceptor 2 启用#配置3(注意：配置与用全局配置文件互斥，只能二选一)
 * 查询.resultMap.多表联查，见工程.mybatis_return
 * 查询.动态sql，见工程.mybatis_dynamic
 */
@RestController
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserService userService;

    /**
     * 查询.list
     */
    @RequestMapping("/aaa")
    public String aaa(String userName) {
        List<User> list = userMapper.getUserList();
        return list.toString();
    }

    /**
     * 查询.count
     * count(*)效果同count(1)
     * count(字段名)：不能用。因为如果该字段值为空，该行就会被忽略
     */
    @RequestMapping("/bbb")
    public String bbb(String userName) {
        int count = userMapper.getCount();
        return count + "";
    }

    /**
     * 查询.返回一条记录的map形式
     */
    @RequestMapping("/ccc")
    public String ccc(String id) {
        Map<String, Object> map = userMapper.getUserMapById(id);
        return map.toString();
    }

    /**
     * 查询.返回List<map>
     */
    @RequestMapping("/ddd")
    public String ddd(String userName) {
        List<Map<String, Object>> mapList = userMapper.getUserMapList();
        return mapList.toString();
    }

    /**
     * 查询.返回List<map>，每个map带key
     */
    @RequestMapping("/eee")
    public String eee(String userName) {
        Map<String, Object> map = userMapper.getUserMapListWithKey();
        return map.toString();
    }

    /**
     * 查询.模糊
     */
    @RequestMapping("/fff")
    public String fff(String userName) {
        User user = userMapper.getUserByLike(userName);
        return user.toString();
    }

    /**
     * 查询.分页
     */
    @RequestMapping("/ggg")
    public String ggg(String userName) {
//        Page<Object> objects = PageHelper.startPage(1, 2);
        Page<Object> objects = PageHelper.startPage(3, 3);
        List<User> result = userService.getByPage();
        PageInfo<User> pageInfo1 = new PageInfo(result);
//        PageInfo pageInfo2 = new PageInfo(result, 5);
        return pageInfo1.toString();
    }

    /**
     * 查询.resultMap.多表联查，见工程.mybatis_return
     */

    /**
     * 查询.动态sql，见工程.mybatis_dynamic
     */


}
