package top.ke1205.usermanage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.ke1205.usermanage.mapper.UserMapper;
import top.ke1205.usermanage.pojo.User;

import java.util.Date;
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

    public void insertUser(User user, User user2){
        userMapper.insertUser(user);
//        int i = 10 / 0;
        userMapper.insertUser(user2);
    }

    public Boolean save(User user){
        return userMapper.insertUser(user) == 1;
    }

    public Boolean updateUser(User user) {
        return userMapper.updateUser(user) == 1;
    }

    public Boolean deleteUsersByIds(List<Long> ids) {
        return userMapper.deleteUsersByIds(ids) > 0;
    }
}
