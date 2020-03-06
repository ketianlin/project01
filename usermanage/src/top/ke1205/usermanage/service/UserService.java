package top.ke1205.usermanage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ke1205.usermanage.mapper.UserMapper;
import top.ke1205.usermanage.pojo.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public Long queryTotal() {
        return userMapper.queryTotal();
    }

    public List<User> queryUserAll() {
        return userMapper.queryUserAll();
    }
}
