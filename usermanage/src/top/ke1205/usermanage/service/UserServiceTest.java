package top.ke1205.usermanage.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.ke1205.usermanage.pojo.User;

import java.util.Date;

import static org.junit.Assert.*;

public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext.xml",
                "classpath:spring/applicationContext-mybatis.xml",
                "classpath:spring/applicationContext-tx.xml");
        userService = context.getBean(UserService.class);
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setName("相信");
        user.setAge(20);
        user.setBirthday(new Date());
        user.setPassword("123");
        user.setSex(1);
        user.setUserName("xiangxin");
        User user2 = new User();
        user2.setName("相信2");
        user2.setAge(20);
        user2.setBirthday(new Date());
        user2.setPassword("123");
        user2.setSex(1);
        user2.setUserName("xiangxin2");
        userService.insertUser(user, user2);
    }
}