package top.ke1205.usermanage.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserMapperTest {
    private UserMapper userMapper;
    @Before
    public void setUp() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml",
                "classpath:spring/applicationContext-mybatis.xml");
        this.userMapper = context.getBean(UserMapper.class);
    }

    @Test
    public void queryUserById() {
        System.out.println(this.userMapper.queryUserById(1l));
    }

    @Test
    public void queryTotal() {
    }

    @Test
    public void queryUserAll() {
    }
}