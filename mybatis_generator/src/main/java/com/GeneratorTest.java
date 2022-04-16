package springboot10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot10.pojo.SbTestUser;
import springboot10.service.UserService;

import java.util.List;

@Controller
public class GeneratorTest {
    private static final String AAA = "mmm/aaa";
    private static final String BBB = "mmm/bbb";

    @Autowired
    private UserService userService;


    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return AAA;
    }

    @RequestMapping("/user/add")
    public String llll(SbTestUser user) {
        try {
//            String ddd = null;
//            ddd.length();
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            // 这里直接跳转错误页面视图，没有做重定向
            return "error";
        }
        return "ok";
    }

    @RequestMapping("/listUsers")
    public String listUsers(Model model) {
        List<SbTestUser> users = userService.listUsers();
        model.addAttribute("users", users);
        return BBB;
    }
}
