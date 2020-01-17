package top.ke1205.junit;

import org.junit.Test;
import top.ke1205.util.JdbcUtils;

import java.sql.Connection;


public class JdbcUtilsTest {
    @Test
    public void test() throws Exception{
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);

    }
}
