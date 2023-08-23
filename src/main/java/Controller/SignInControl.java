package Controller;

import Dao.AccountDAO;
import Entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignInControl", value = "/SignInControl")
public class SignInControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        response.getWriter().println(email + " " + password);

        User acc = new AccountDAO().signInAccount(email, password);
        if(acc != null){
            HttpSession session = request.getSession();
            session.setAttribute("accLogged", acc);
            response.sendRedirect("index.jsp");
        }else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Thông tin đăng nhập không chính xác !!!');");
            out.println("location='login.jsp';");
            out.println("</script>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}