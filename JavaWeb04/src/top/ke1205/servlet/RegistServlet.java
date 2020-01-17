package top.ke1205.servlet;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;
import top.ke1205.pojo.User;
import top.ke1205.service.UserService;
import top.ke1205.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        if ( ! "1234".equals(code)){
            System.out.println("验证码错误：" + code);
            request.getRequestDispatcher("/pages/user/regist.jsp")
                    .forward(request, response);
            return;
        }
        if (userService.existsUsername(username)){
            System.out.println("用户名已存在：" + username);
            request.getRequestDispatcher("/pages/user/regist.jsp")
                    .forward(request, response);
            return;
        }
        userService.registUser(new User(null, username, password, email));
        request.getRequestDispatcher("/pages/user/regist_success.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
