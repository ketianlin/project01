package top.ke1205.serlver;

import top.ke1205.pojo.Book;
import top.ke1205.pojo.Cart;
import top.ke1205.pojo.CartItem;
import top.ke1205.service.BookService;
import top.ke1205.service.impl.BookServiceImpl;
import top.ke1205.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;

    private BookService bookService = new BookServiceImpl();
    protected void updateItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Utils.parseInt(request.getParameter("id"), 0);
        Integer count = Utils.parseInt(request.getParameter("count"), 0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.updateItem(id, count);
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取商品编号
        Integer id = Utils.parseInt(request.getParameter("id"), 0);
        //2 调用bookService.queryBookById(id);
        Book book = bookService.queryBookById(id);
        if (book == null){
            return;
        }
        //3 把Book商品信息转换为CartItem
        CartItem item = new CartItem(id, book.getName(), 1, book.getPrice(), book.getPrice());
        //4 准备购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        //5调用cart.addItem添加商品项
        cart.addItem(id, item);
        System.out.println(cart);
        //6 跳回请求发起时的页面
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        response.sendRedirect(request.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取商品编号
        Integer id = Utils.parseInt(request.getParameter("id"), 0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.deleteItem(id);
        System.out.println(cart);
        response.sendRedirect(request.getHeader("Referer"));
    }
}
