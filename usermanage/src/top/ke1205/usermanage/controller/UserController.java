package top.ke1205.usermanage.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ke1205.usermanage.pojo.User;
import top.ke1205.usermanage.service.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("save")
    @ResponseBody
    public Map<String, Object> saveUser(@Valid User user, BindingResult result){
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()){
            map.put("status", 500);
            return map;
        }

        if(userService.save(user)){
            map.put("status", 200);
        }else{
            map.put("status", 500);
        }
        return map;
    }

    @RequestMapping("edit")
    @ResponseBody
    public Map<String, Object> updateUser(@Valid User user, BindingResult result){
        Map<String, Object> map = new HashMap<>();
        if (result.hasErrors()){
            map.put("status", 500);
            return map;
        }
        if (userService.updateUser(user)){
            map.put("status", 200);
        }else{
            map.put("status", 500);
        }
        return map;
    }

    @PostMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteUser(@RequestParam("ids") List<Long> ids){
        Map<String, Object> map = new HashMap<>();
        if (userService.deleteUsersByIds(ids)){
            map.put("status", 200);
        }else{
            map.put("status", 500);
        }
        return map;
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
