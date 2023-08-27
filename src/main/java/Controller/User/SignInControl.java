package Controller.User;

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
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();

        String message = "";

        User emailIsExist = new AccountDAO().checkEmailIsExist(email);
        // kiem tra email da dang ki hay chua
        if (emailIsExist != null) {

            int limitCount = 5;


            // kiem tra them mat khau
            User acc = new AccountDAO().signInAccount(email, password);


            // email dung va mat khau dung va khong bi khoa
            if (acc != null && acc.getIs_locked() == 0) {
                new AccountDAO().resetCount(emailIsExist.getEmail());
                HttpSession session = request.getSession();
                session.setAttribute("accLogged", acc);
                response.sendRedirect("index.jsp");
            }

            // email dung va mat khau dung va bi khoa
            if (acc != null && acc.getIs_locked() == 1) {
                message = "Tài khoản đã bị khoá !!!";
                request.setAttribute("messageError", message);

                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

            // email dung va sai mat khau
            if (acc == null) {
                new AccountDAO().upCount(emailIsExist.getEmail());
                int remainder = limitCount - emailIsExist.getCount();
                // System.out.println("Remainder: " + (limitCount - emailIsExist.getCount()));

                message = "Mật khẩu không chính xác, còn " + remainder + " lần nhập !!!";
                request.setAttribute("messageError", message);

                if (remainder <= 0) {
                    new AccountDAO().lockAcc(emailIsExist.getEmail());
                    message = "Tài khoản đã bị khoá !!!";
                    request.setAttribute("messageError", message);
                }

                request.getRequestDispatcher("login.jsp").forward(request, response);

            }
        } else {
            // email khong ton tai
            message = "Email chưa được đăng kí !!!";
            request.setAttribute("messageError", message);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}