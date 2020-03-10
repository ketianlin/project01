package top.ke1205.usermanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import top.ke1205.usermanage.pojo.User;
import top.ke1205.usermanage.service.UserService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("rest/user")
public class RestUserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> queryUserAll(){
        Long total = userService.queryTotal();
        List<User> users = userService.queryUserAll();
        if (CollectionUtils.isEmpty(users)){
            return ResponseEntity.notFound().build();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", users);
        return ResponseEntity.ok(map);
    }

    @PostMapping
    public ResponseEntity<Void> saveUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        Boolean flag = userService.save(user);
        if (flag){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
//        if (user == null || user.getId() == null){
//            return ResponseEntity.badRequest().build();
//        }
        Boolean flag = userService.updateUser(user);
        if (flag){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestParam("ids") List<Long> ids){
        if (ids == null || ids.size() < 1){
            return ResponseEntity.badRequest().build();
        }
        Boolean flag = userService.deleteUsersByIds(ids);
        if (flag){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> queryUserById(@PathVariable("id") Long id){
        if (id < 1){
            return ResponseEntity.badRequest().build();
        }
        User user = userService.queryUserById(id);
        if (user == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user);
    }
}
