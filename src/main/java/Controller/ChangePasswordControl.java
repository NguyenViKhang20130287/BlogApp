package Controller;

import Dao.AccountDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ChangePasswordControl", value = "/ChangePasswordControl")
public class ChangePasswordControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String newPassword = request.getParameter("new-password");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email-forgot-pass");

        if(!newPassword.isEmpty()){
            new AccountDAO().changePassword(email, newPassword);
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Đổi mật khẩu thành công ^^');");
            out.println("location='login.jsp';");
            out.println("</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}