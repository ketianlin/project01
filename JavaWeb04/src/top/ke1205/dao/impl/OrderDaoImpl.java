package top.ke1205.dao.impl;

import top.ke1205.dao.OrderDao;
import top.ke1205.pojo.Order;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(),
                order.getPrice(), order.getStatus(), order.getUserId());
    }
}
