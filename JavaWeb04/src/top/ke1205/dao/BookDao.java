package top.ke1205.dao;

import top.ke1205.pojo.Book;

import java.util.List;

public interface BookDao {
    public int saveBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Integer queryForPageTotalCount();

    public List<Book> queryForPageItems(Integer begin, Integer pageSize);

    public Integer queryForPageTotalCountByPrice(Integer min, Integer max);

    public List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max);
}
