package top.ke1205.dao.impl;

import top.ke1205.dao.OrderItemDao;
import top.ke1205.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDaoImpl implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";

        return update(sql, orderItem.getName(), orderItem.getCount(),
                orderItem.getPrice(), orderItem.getTotalPrice(),
                orderItem.getOrderId());
    }
}
