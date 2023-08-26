package Controller;

import Dao.BlogDAO;
import Entity.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadBlogUser", value = "/LoadBlogUser")
public class LoadBlogUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        int user_id = Integer.parseInt(request.getParameter("user_id"));
//        response.getWriter().println(user_id);
        List<Blog> listBlog = new BlogDAO().getBlogOfUserLogged(user_id);
        request.setAttribute("listBlogUserLogged", listBlog);
        request.getRequestDispatcher("blogs-user.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}