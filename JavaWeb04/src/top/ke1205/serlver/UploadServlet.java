package top.ke1205.serlver;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // isMultipartContent 判断是否是多段的形式提交的数据
        if (ServletFileUpload.isMultipartContent(request)) {
            // 创建一个FileItemFactory工厂
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建ServletFileUpload对象实例，用于解决上传的数据
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            String content = "";
            try {
                List<FileItem> fileItems = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : fileItems) {
                    content += "name=" + fileItem.getFieldName();
                    if (fileItem.isFormField()){
                        content += ",value=" + fileItem.getString("utf-8");
                    }else{
                        content += ",filename=" + fileItem.getName();
                        fileItem.write(new File("c:\\" + fileItem.getName()));
                    }
                }
                request.setAttribute("msg", "上传成功，信息=" + content);
                request.getRequestDispatcher("/test/success.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
