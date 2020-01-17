package top.ke1205.service;

import top.ke1205.pojo.Book;
import top.ke1205.pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    public Page<Book> page(Integer pageNo, Integer pageSize);

    public Page<Book> pageByPrice(Integer pageNo, Integer pageSize,
                                  Integer min, Integer max);
}
