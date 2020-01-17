package top.ke1205.serlver;

import top.ke1205.pojo.Cart;
import top.ke1205.pojo.User;
import top.ke1205.service.OrderService;
import top.ke1205.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {
    protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            request.setAttribute("msg", "请先登录");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null || cart.getTotalCount() <= 0){
            response.sendRedirect(request.getContextPath());
            return;
        }
        OrderService orderService = new OrderServiceImpl();
        String orderId = orderService.createOrder(cart, user.getId());
        request.setAttribute("orderId", orderId);
        cart.clear();
        request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
    }

}
