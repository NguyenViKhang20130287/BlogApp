package Controller.User;

import Dao.AccountDAO;
import Entity.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "ForgotPasswordControl", value = "/ForgotPasswordControl")
public class ForgotPasswordControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");

        RequestDispatcher dispatcher = null;
        HttpSession mySession = request.getSession();
        int otpvalue = 0;
//        response.getWriter().println(email);
        PrintWriter out = response.getWriter();
        User acc = new AccountDAO().checkEmailIsExist(email);
        if (acc == null) {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Tài khoản email chưa được đăng kí !!!');");
            out.println("location='forgot-password.jsp';");
            out.println("</script>");
        } else {
            // random otp code
            Random rand = new Random();
            otpvalue = rand.nextInt(899999) + 100000;

            String to = email;

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("vikhang17112002@gmail.com", "fzjljqjsfkltospu");// Put your email
                    // id and
                    // password here
                }
            });

            // compose message
            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(email));// change accordingly
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("Xin chào");
                message.setText("Mã OTP của bạn là: " + otpvalue);
                // send message
                Transport.send(message);
                System.out.println("message sent successfully");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            dispatcher = request.getRequestDispatcher("otp-code-forgot-pass.jsp");
            request.setAttribute("message", "OTP is sent to your email id");
            //request.setAttribute("connection", con);
            mySession.setAttribute("otp", otpvalue);
            mySession.setAttribute("email-forgot-pass", email);
            dispatcher.forward(request, response);
            //request.setAttribute("status", "success");

        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}