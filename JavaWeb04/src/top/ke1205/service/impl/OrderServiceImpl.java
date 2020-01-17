package top.ke1205.service.impl;


import top.ke1205.dao.BookDao;
import top.ke1205.dao.OrderItemDao;
import top.ke1205.dao.impl.BookDaoImpl;
import top.ke1205.dao.impl.OrderDaoImpl;
import top.ke1205.dao.impl.OrderItemDaoImpl;
import top.ke1205.pojo.*;
import top.ke1205.service.OrderService;

import java.util.Date;

public class OrderServiceImpl implements OrderService {
    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        new OrderDaoImpl().saveOrder(order);
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        BookDao bookDao = new BookDaoImpl();
        int i = 1 / 0;
        for (CartItem item : cart.getItems().values()) {
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);
            Book book = bookDao.queryBookById(item.getId());
            book.setSales(book.getSales() + 1);
            book.setStock(book.getStock() - 1);
            bookDao.updateBook(book);
        }
        return orderId;
    }
}
