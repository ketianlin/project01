package top.ke1205.serlver;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("name");
        ServletContext servletContext = getServletContext();
        String path = "/uploads/" + filename;
        String ua = request.getHeader("User-Agent");
        String str = "";
        if (ua.contains("Firefox")){
            str = "attachment; fileName=" + "=?utf-8?B?" + new BASE64Encoder().encode(filename.getBytes("utf-8")) + "?=";
        }else{
            str = "attachment; fileName=" + URLEncoder.encode(filename, "UTF-8");
        }
        response.setHeader("Content-Disposition", str);
        // 客户端收到数据，怎么处理（下载）
        // 通过响应头，设置，告诉客户端收到数据后，给用户做下载操作
        // Content-Disposition告诉客户端返回的数据怎么处理
        // attachment表示附件，都是用于下载。
        // filename 表示默认的文件名是多少
        /**
         * 不同浏览器处理方式不同<br/>
         * 如果是谷歌浏览器和IE浏览器，只需要使用URL编码处理即可。<br/>
         * URL编码 是把 中文 ====转成>>>>> %xx%xx的格式<br/>
         * 火狐浏览器 需要使用Base64编码。<br/>
         *
         */
        InputStream inputStream = servletContext.getResourceAsStream(path);
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        inputStream.close();
        outputStream.close();
    }
}
