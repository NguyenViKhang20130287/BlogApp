package Controller.Admin;

import Dao.AccountDAO;
import Entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AdminUnLockAcc", value = "/AdminUnLockAcc")
public class AdminUnLockAcc extends HttpServlet {

    public String checkStatusBtns(int is_locked, int user_id) {
        String result = "";
        if (is_locked == 0) {
            result = "<button class=\"edit-account\" style=\"color: red\"\n" +
                    "                        onclick=\"lockAcc(id=" + user_id + ")\">\n" +
                    "                            <i class=\"fa-solid fa-lock\"></i>\n" +
                    "                        </button>";
        } else if (is_locked == 1) {
            result = "<button class=\"edit-account\" style=\"color: green\"\n" +
                    "                            onclick=\"unLockAcc(id= " + user_id + ")\">\n" +
                    "                            <i class=\"fa-solid fa-lock-open\"></i>\n" +
                    "                        </button>";
        }
        return result;
    }

    public String checkStatusSpans(int is_locked) {
        String result = "";
        if (is_locked == 0) {
            result = "<div class=\"status\">\n" +
                    "                        <span class=\"enable\">Đang hoạt động</span>\n" +
                    "                    </div>";
        } else if (is_locked == 1) {
            result = "<div class=\"status\">\n" +
                    "                        <span class=\"disable\">Bị khoá</span>\n" +
                    "                    </div>";
        }
        return result;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int user_id = Integer.parseInt(request.getParameter("id"));
        new AccountDAO().unLockAcc(user_id);
        new AccountDAO().resetCountWithID(user_id);
        List<User> users = new AccountDAO().getAllUser();
        for (User u : users) {
            out.println(
                    "<div class=\"account-item\">\n" +
                            "                    <h3 class=\"email\"> " + u.getEmail() + "\n" +
                            "                    </h3>\n" +
                            "                    <input type=\"password\" class=\"password\" value=\" " + u.getPassword() + "\" disabled>\n" +
                            "\n" +
                            checkStatusSpans(u.getIs_locked()) +
                            "\n" +
                            "                    <div class=\"account-action\">\n" +
                            checkStatusBtns(u.getIs_locked(), u.getId()) +
                            "                        <button class=\"delete-account\" style=\"color: red\"\n" +
                            "                                onclick=\"deleteUser(id=<%=u.getId()%>)\">\n" +
                            "                            <i class=\"fa-regular fa-trash-can\"></i></button>\n" +
                            "                    </div>\n" +
                            "                </div>"
            );

        }


    }
}