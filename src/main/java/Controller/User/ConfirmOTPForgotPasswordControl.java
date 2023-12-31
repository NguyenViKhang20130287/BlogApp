package Controller.User;

import Dao.AccountDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfirmOTPForgotPasswordControl", value = "/ConfirmOTPForgotPasswordControl")
public class ConfirmOTPForgotPasswordControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        int otpIsSent = (int) session.getAttribute("otp");
        int otpValue = Integer.parseInt(request.getParameter("otp-code"));
        String message = "";

        if(otpValue == otpIsSent){
            response.sendRedirect("change-password.jsp");
        }else{
            message = "Mã xác nhận không chính xác !!!";
            request.setAttribute("messageError", message);
            request.getRequestDispatcher("otp-code-forgot-pass.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}