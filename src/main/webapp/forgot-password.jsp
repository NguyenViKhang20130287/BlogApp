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
    <title>Lấy lại mật khẩu</title>
</head>
<body>
<div
        class="container-fluid d-flex justify-content-center align-items-center"
>
    <div class="wrapper">
        <h3 class="title">Lấy lại mật khẩu</h3>

        <%--        --%>
        <% String message = (String) request.getAttribute("messageError");%>
        <%--    --%>
        <span style="font-weight: bold; font-size: 14px; color: red">
            <%= message != null ? message : "" %>
        </span>

        <form method="get" action="ForgotPasswordControl">
            <div class="box">
                <label for="">Email</label>
                <input type="text" id="email" name="email">
            </div>
            <button type="submit">Lấy lại mật khẩu</button>
        </form>
    </div>
</div>
</body>
</html>
