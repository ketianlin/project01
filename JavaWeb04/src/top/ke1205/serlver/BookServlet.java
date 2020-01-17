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

public class BookServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = Utils.parseInt(request.getParameter("pageNo"), 1);
        Integer pageSize = Utils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setPageUrl("manager/book?action=page");
        request.setAttribute("page", page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp")
                .forward(request, response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = Utils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.addBook(book);
        response.sendRedirect(request.getContextPath() + "/manager/book?action=page&pageNo="+Integer.MAX_VALUE);
    }

    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Utils.parseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        request.setAttribute("book", book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp")
                .forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Utils.parseInt(request.getParameter("id"), 0);
        bookService.deleteBookById(id);
        response.sendRedirect(request.getContextPath() + "/manager/book?action=page&pageNo=" + request.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = Utils.copyParamToBean(request.getParameterMap(), new Book());
        bookService.updateBook(book);
        response.sendRedirect(request.getContextPath() + "/manager/book?action=page&pageNo=" + request.getParameter("pageNo"));
    }
}
