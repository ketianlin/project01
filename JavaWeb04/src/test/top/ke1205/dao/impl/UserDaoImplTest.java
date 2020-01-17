package top.ke1205.dao.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import top.ke1205.dao.UserDao;
import top.ke1205.pojo.User;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    static UserDao userDao = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        userDao = new UserDaoImpl();
    }


    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("admin", "admin");
        System.out.println("user = " + user);
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setEmail("zhangsan@qq.com");
        int i = userDao.saveUser(user);
        System.out.println("i = " + i);
    }

    @Test
    public void queryUserByUsername() {
        User user = userDao.queryUserByUsername("张三");
        System.out.println("user = " + user);
    }
}