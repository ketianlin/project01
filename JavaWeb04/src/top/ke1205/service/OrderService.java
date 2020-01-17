package top.ke1205.service;

import top.ke1205.pojo.Cart;

public interface OrderService {
    String createOrder(Cart cart, Integer userId);
}
