package top.ke1205.filter;

import top.ke1205.util.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            chain.doFilter(req, resp);// 等价于调用所有XxxService.xxxx()方法
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            // 把异常交Tomcat处理
            throw new RuntimeException(e);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
