package top.ke1205.dao.impl;

import top.ke1205.dao.BookDao;
import top.ke1205.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDaoImpl implements BookDao {
    @Override
    public int saveBook(Book book) {
        String sql = "insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) values(?, ?, ?, ?, ?, ?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id = ?";
        return queryOne(sql, Book.class, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book";
        return queryList(sql, Book.class);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Object o = queryForValue(sql);
        return new Integer(o.toString());
    }

    @Override
    public List<Book> queryForPageItems(Integer begin, Integer pageSize) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book limit ?,?";
        return queryList(sql, Book.class, begin, pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(Integer min, Integer max) {
        String sql = "select count(*) from t_book where price BETWEEN ? and ?";
        return Integer.parseInt(queryForValue(sql, min, max).toString());
    }

    @Override
    public List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where price BETWEEN ? and ? order by price limit ?,?";
        return queryList(sql, Book.class, min, max, begin, pageSize);
    }
}
