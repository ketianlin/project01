package top.ke1205.service.impl;

import top.ke1205.dao.UserDao;
import top.ke1205.dao.impl.UserDaoImpl;
import top.ke1205.pojo.User;
import top.ke1205.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public boolean existsUsername(String username) {
        User user = userDao.queryUserByUsername(username);
        return user != null;
    }
}
