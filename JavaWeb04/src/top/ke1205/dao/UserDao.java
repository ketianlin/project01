package top.ke1205.dao;

import top.ke1205.pojo.User;

public interface UserDao {
    User queryUserByUsernameAndPassword(String username, String password);

    int saveUser(User user);

    User queryUserByUsername(String username);
}
