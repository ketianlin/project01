package top.ke1205.serlver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Enumeration;

public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost()");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ServletConfig servletConfig = this.getServletConfig();
//        String url = servletConfig.getInitParameter("url");
//        System.out.println("url = " + url);


        ServletContext context = this.getServletContext();

        String username = context.getInitParameter("username");
        System.out.println("username = " + username);
        String password = context.getInitParameter("password");
        System.out.println("password = " + password);
        String path = context.getContextPath();
        System.out.println("path = " + path);
        String realPath = context.getRealPath("/css/a.css");
        System.out.println("realPath = " + realPath);
        System.out.println("doGet()");

        String username1 = request.getParameter("username");
        System.out.println("username1 = " + username1);
        String s = new String(username1.getBytes("iso-8859-1"), "utf-8");
        System.out.println("s = " + s);
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("Arrays.asList(hobbies) = " + Arrays.asList(hobbies));
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
