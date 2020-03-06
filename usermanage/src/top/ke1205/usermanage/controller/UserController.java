package top.ke1205.usermanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ke1205.usermanage.pojo.User;
import top.ke1205.usermanage.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("users")
    public String user(){
        return "users";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> queryUserAll(){
        Map<String, Object> map = new HashMap<>();
        Long total = userService.queryTotal();
        map.put("total", total);
        List<User> rows = userService.queryUserAll();
        map.put("rows", rows);
        return map;
    }
}
