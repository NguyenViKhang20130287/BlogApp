package Controller;

import Dao.BlogDAO;
import Entity.Blog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "DeleteBlogControl", value = "/DeleteBlogControl")
public class DeleteBlogControl extends HttpServlet {

    public int compareToDateTime(String createAtValue, String updateAtValue) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);
        LocalDateTime createAt = LocalDateTime.parse(createAtValue, dtf);
        LocalDateTime updateAt = LocalDateTime.parse(updateAtValue, dtf);
        int diff = createAt.compareTo(updateAt);
        return diff;
    }

    public String dateTime(String createAtValue, String updateAtValue) {
        String result = "";
        if (compareToDateTime(createAtValue, updateAtValue) < 0) {
            result = "<span class=\"timer\">\n" + "Cập nhật lúc: " + updateAtValue + "</span>";
        } else {
            result = "<span class=\"timer\">\n" + "Vừa đăng lúc: " + createAtValue + "</span>";
        }
        return result;
    }

    //
    public String checkBlogIsEmpty(List<Blog> listBlog, String data) {
        String result = "";
        if (listBlog.isEmpty()) {
            result = "<div class=\"empty-container\">\n" +
                    "<h1>Bạn chưa có bài đăng nào !</h1>\n" +
                    "</div>";
        } else {
            result = data;
        }
        return result;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int blog_id = Integer.parseInt(request.getParameter("id"));

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        new BlogDAO().deleteBlog(blog_id);

        int user_id = Integer.parseInt(request.getParameter("user_id"));
        List<Blog> listBlog = new BlogDAO().getBlogOfUserLogged(user_id);

        for (Blog b : listBlog) {
            String data = "<div class=\"blog-item\">\n" +
                    "                    <div class=\"main\">\n" +
                    "                        <h3 class=\"title\">" + b.getTitle() + "\n" +
                    "                        </h3>\n" +
                    dateTime(b.getCreateAt(), b.getUpdateAt()) +
                    "                        <p class=\"content\">\n" +
                    "                            " + b.getContent() + "\n" +
                    "                        </p>\n" +
                    "                    </div>\n" +
                    "                    <div class=\"action\">\n" +
                    "                        <button class=\"edit-blog\"><a href=\"LoadDataBlog?blogID=" + b.getId() + "\"><i\n" +
                    "                                class=\"fa-regular fa-pen-to-square\"></i></a></button>\n" +
                    "                        <button class=\"delete-blog\" type=\"button\"\n" +
                    "                                onclick=\"deleteBlog(id=" + b.getId() + ", user_id=" + user_id + ")\">\n" +
                    "                            <i class=\"fa-regular fa-trash-can\"></i>\n" +
                    "                        </button>\n" +
                    "                    </div>\n" +
                    "                </div>";
            out.println(checkBlogIsEmpty(listBlog, data));
        }

    }
}