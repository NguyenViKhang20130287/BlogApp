package Controller;

import Dao.BlogDAO;
import Entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PostBlogControl", value = "/PostBlogControl")
public class PostBlogControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String title = request.getParameter("title");
        String content = request.getParameter("editor1");
        HttpSession sessionAcc = request.getSession();
        User acc = (User) sessionAcc.getAttribute("accLogged");
        PrintWriter out = response.getWriter();

//        response.getWriter().println(title + " " + content + " user id: " + acc.getId());
        if (!title.isEmpty() && !content.isEmpty()) {
            new BlogDAO().postBlog(title, content, acc.getId());
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Tải lên thành công ^^');");
            out.println("location='index.jsp';");
            out.println("</script>");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Không được để trống !!!');");
            out.println("location='post-blog.jsp';");
            out.println("</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}