package top.ke1205.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import top.ke1205.util.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * BaseDao中，所有操作不能关闭连接，和消化异常
 */
public abstract class BaseDaoImpl {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 执行insert、update、delete语句
     *
     * @param sql
     *           要执行的sql语句
     * @param args
     *           占位符的参数值
     * @return  -1表示执行失败，其他值表示执行的行数
     */
    public int update(String sql, Object... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return  queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public <T> T queryOne(String sql, Class<T> type, Object... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> queryList(String sql, Class<T> type, Object... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new BeanListHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Object queryForValue(String sql, Object... args){
        Connection conn = JdbcUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
