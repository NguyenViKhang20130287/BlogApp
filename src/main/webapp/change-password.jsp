<%----%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%----%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="./css/login-signup.css"/>
    <title>Đổi mật khẩu</title>
</head>
<body>
<div
        class="container-fluid d-flex justify-content-center align-items-center">
    <div class="wrapper">
        <h3 class="title">Đổi mật khẩu</h3>
        <form method="get" action="ChangePasswordControl">
            <div class="box">
                <label for="">Mật khẩu mới</label>
                <input type="text" id="new-password" name="new-password">
                <span class="message-new-password" style="color: red; font-size: 14px; visibility: hidden;">Mật khẩu phải có độ dài tối thiểu 8 kí tự !!!</span>
            </div>
            <button type="submit" id="change-pass-btn">Đổi mật khẩu</button>
        </form>
    </div>
</div>
</body>
<script src="./js/validate-change-password.js"></script>
</html>
