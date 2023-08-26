package Controller.User;

import Dao.BlogDAO;
import Entity.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoadDataBlog", value = "/LoadDataBlog")
public class LoadDataBlog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        int blog_id = Integer.parseInt(request.getParameter("blogID"));
//        response.getWriter().println(blog_id);
        Blog b = new BlogDAO().getDataBlog(blog_id);
        request.setAttribute("dataBlog", b);
        request.getRequestDispatcher("edit-blog.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}