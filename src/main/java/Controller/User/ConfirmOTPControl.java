package Controller.User;

import Dao.AccountDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfirmOTPControl", value = "/ConfirmOTPControl")
public class ConfirmOTPControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");

        int otpIsSent = (int) session.getAttribute("otp");
        int otpValue = Integer.parseInt(request.getParameter("otp-code"));

        String message = "";

//        response.getWriter().println("OTP is sent: " + otpIsSent);
//        response.getWriter().println("OTP value: " + otpValue);

        if(otpValue == otpIsSent){

            // sign up
            new AccountDAO().signUpAccount(email, password);

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Đăng kí tài khoản thành công ^^');");
            out.println("location='login.jsp';");
            out.println("</script>");
        }else{
            message = "Mã xác nhận không chính xác !!!";
            request.setAttribute("messageError", message);
            request.getRequestDispatcher("otp-code.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}