package Controller;

import Dao.BlogDAO;
import Entity.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditBlogControl", value = "/EditBlogControl")
public class EditBlogControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("blog_id"));
        String title = request.getParameter("title");
        String content = request.getParameter("editor2");

//        response.getWriter().println(id);
        if(!title.isEmpty() && !content.isEmpty()){
            new BlogDAO().editBlog(id, title, content);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Cập nhật thành công ^^');");
            out.println("location='blogs-user.jsp';");
            out.println("</script>");
        }else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Không được bỏ trống !!!');");
            out.println("location='loadDataBlog';");
            out.println("</script>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}