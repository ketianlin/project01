package top.ke1205.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    static DruidDataSource dataSource;
    static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    static {
        try {
            Properties properties = new Properties();
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = threadLocal.get();
        if (connection == null){
            try {
                // 从数据库连接池中获取数据库连接
                connection = dataSource.getConnection();
                // 保存到Threadlocal中，供后面操作使用
                threadLocal.set(connection);
                // 设置手动管理事务
                connection.setAutoCommit(false);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 提交事务并关闭连接
     */
    public static void commitAndClose(){
        Connection connection = threadLocal.get();
        if (connection != null){
            try {
                connection.commit();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 因为Tomcat底层使用了线程池======不写此代码就会报错
        threadLocal.remove();
    }

    /**
     * 回滚事务并关闭连接
     */
    public static void rollbackAndClose(){
        Connection connection = threadLocal.get();
        if (connection != null){
            try {
                connection.rollback();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 因为Tomcat底层使用了线程池======不写此代码就会报错
        threadLocal.remove();
    }

    public static void closeConnection(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
