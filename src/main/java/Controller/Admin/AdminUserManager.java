package Controller.Admin;

import Dao.AccountDAO;
import Dao.BlogDAO;
import Entity.Blog;
import Entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminUserManager", value = "/AdminUserManager")
public class AdminUserManager extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        List<User> listAcc = new AccountDAO().getAllUser();
        request.setAttribute("listAccountAdmin", listAcc);
        request.getRequestDispatcher("./admin/manager-user.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}