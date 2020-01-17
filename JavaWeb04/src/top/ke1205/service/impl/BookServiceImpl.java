package top.ke1205.service.impl;

import top.ke1205.dao.BookDao;
import top.ke1205.dao.impl.BookDaoImpl;
import top.ke1205.pojo.Book;
import top.ke1205.pojo.Page;
import top.ke1205.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if ((pageTotalCount % pageSize) != 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        Integer begin = (page.getPageNo() - 1) * page.getPageSize();
        List<Book> books = bookDao.queryForPageItems(begin, page.getPageSize());
        page.setItems(books);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {
        Page<Book> page = new Page<>();
        page.setPageSize(pageSize);
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / page.getPageSize();
        if ((pageTotalCount % page.getPageSize()) != 0){
            pageTotal++;
        }
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        Integer begin = (page.getPageNo() - 1) * page.getPageSize();
        List<Book> books = bookDao.queryForPageItemsByPrice(begin, page.getPageSize(), min, max);
        page.setItems(books);
        return page;
    }
}
