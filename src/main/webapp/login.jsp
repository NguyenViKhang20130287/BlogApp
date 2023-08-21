<%----%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%----%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
    <link rel="stylesheet" href="./css/login-signup.css" />
    <title>Đăng nhập</title>
  </head>
  <body>
    <div
      class="container-fluid d-flex justify-content-center align-items-center"
    >
      <div class="wrapper">
        <h3 class="title">Đăng nhập tài khoản</h3>
        <form>
            <div class="box">
                <label for="">Email</label>
                <input type="text" id="email">
                <span class="message-email" style="color: red; font-size: 14px; visibility: hidden;">Tài khoản email không hợp lệ !!!</span>
            </div>
            <div class="box">
                <label for="">Mật khẩu</label>
                <input type="password" id="password">
                <span class="message-password" style="color: red; font-size: 14px; visibility: hidden;">Mật khẩu phải có độ dài tối thiểu 8 kí tự !!!</span>
                <!-- <span class="show-hide-password"><i class="fa-regular fa-eye"></i></span> -->
            </div>
            <button type="submit" id="login">Đăng nhập</button>
            <span class="sign-up">
                Chưa có tài khoản ? <a href="sign-up.jsp">Đăng kí</a>
            </span>
            <br>
            <span class="forgot-password">
                Quên mật khẩu ? <a href="forgot-password.jsp">Lấy lại mật khẩu</a>
            </span>
        </form>
      </div>
    </div>
  </body>
  <script src="/js/validate.js"></script>
</html>
