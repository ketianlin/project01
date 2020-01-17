package top.ke1205.serlver;

import top.ke1205.pojo.Book;
import top.ke1205.pojo.Page;
import top.ke1205.service.BookService;
import top.ke1205.service.impl.BookServiceImpl;
import top.ke1205.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = Utils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = Utils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setPageUrl("client/book?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp")
                .forward(request, response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = Utils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = Utils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Integer min = Utils.parseInt(request.getParameter("min"), 0);
        Integer max = Utils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        page.setPageUrl("client/book?action=pageByPrice&min="+min+"&max="+max);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/client/index.jsp")
                .forward(request, response);
    }
}
