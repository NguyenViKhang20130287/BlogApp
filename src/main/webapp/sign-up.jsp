<%----%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%----%><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="./css/login-signup.css" />
    <title>Đăng kí</title>
  </head>
  <body>
    <div
      class="container-fluid d-flex justify-content-center align-items-center"
    >
      <div class="wrapper">
        <h3 class="title">Đăng kí tài khoản</h3>
        <form action="SignUpControl" method="get">
          <div class="box">
            <label for="">Email</label>
            <input type="text" id="email" name="email" />
            <span
              class="message-email"
              style="color: red; font-size: 14px; visibility: hidden"
              >Tài khoản email không hợp lệ !!!</span
            >
          </div>
          <div class="box">
            <label for="">Mật khẩu</label>
            <input type="password" id="password" name="password" />
            <span
              class="message-password"
              style="color: red; font-size: 14px; visibility: hidden"
              >Mật khẩu phải có độ dài tối thiểu 8 kí tự !!!</span
            >
          </div>
          <div class="box">
            <label for="">Xác nhận mật khẩu</label>
            <input type="password" id="confirm-password" name="confirm-password" />
            <span
              class="message-confirm-password"
              style="color: red; font-size: 14px; visibility: hidden"
              >Mật khẩu nhập lại không khớp</span
            >
          </div>
          <button type="submit" id="signUp">Đăng kí</button>
          <span class="sign-up">
            Đã có tài khoản ? <a href="login.jsp">Đăng nhập</a>
          </span>
        </form>
      </div>
    </div>
  </body>
  <script src="./js/validate-signup.js"></script>
</html>
