package top.ke1205.serlver;

import com.google.code.kaptcha.Constants;
import com.google.gson.Gson;
import top.ke1205.pojo.User;
import top.ke1205.service.UserService;
import top.ke1205.service.impl.UserServiceImpl;
import top.ke1205.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class UserServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;

    private UserService userService = new UserServiceImpl();

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getSession().invalidate();
        response.sendRedirect(request.getContextPath());
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user = Utils.copyParamToBean(request.getParameterMap(), new User());
        User login = userService.login(user);
        if (login == null){
            request.setAttribute("msg", "用户名或者密码不正确");
            request.setAttribute("username", user.getUsername());
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
        request.getSession().setAttribute("user", login);
        request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
    }

    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        User user = Utils.copyParamToBean(request.getParameterMap(), new User());
        String code = request.getParameter("code");
        Object token = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        request.getSession().removeAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (token == null || (token != null && ! token.equals(code))){
            request.setAttribute("msg", "验证码错误");
            request.setAttribute("username", user.getUsername());
            request.setAttribute("email", user.getEmail());
            request.setAttribute("code", code);
            request.getRequestDispatcher("/pages/user/regist.jsp")
                    .forward(request,response);
            return;
        }
        UserService userService = new UserServiceImpl();
        if (userService.existsUsername(user.getUsername())) {
            request.setAttribute("msg", "用户名已经存在");
            request.setAttribute("username", user.getUsername());
            request.setAttribute("email", user.getEmail());
            request.setAttribute("code", request.getParameter("code"));
            request.getRequestDispatcher("/pages/user/regist.jsp")
                    .forward(request,response);
            return;
        }
        userService.registUser(user);
        request.getRequestDispatcher("/pages/user/regist_success.jsp")
                .forward(request, response);
    }

    public void ajaxExistsUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);
        Map<String, Object> map = new HashMap<>();
        map.put("existsUsername", existsUsername);
        Gson gson = new Gson();
        String mapJsonString = gson.toJson(map);
        response.getWriter().write(mapJsonString);
    }
}
