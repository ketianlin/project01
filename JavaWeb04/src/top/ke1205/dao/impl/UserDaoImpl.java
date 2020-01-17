package top.ke1205.dao.impl;

import top.ke1205.dao.UserDao;
import top.ke1205.pojo.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {
    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id,username,password,email from t_user where username=? and password=?";
        return queryOne(sql, User.class, username, password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username, password, email) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id,username,password,email from t_user where username=?";
        return queryOne(sql, User.class, username);
    }
}
