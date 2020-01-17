package top.ke1205.service;

import top.ke1205.pojo.User;

public interface UserService {
    User login(User user);

    void registUser(User user);

    boolean existsUsername(String username);
}
