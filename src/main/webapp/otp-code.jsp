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
    <title>Nhập mã xác nhận</title>
  </head>
  <body>
    <div
      class="container-fluid d-flex justify-content-center align-items-center"
    >
      <div class="wrapper">
        <h3 class="title">Nhập mã xác nhận</h3>
        <form>
            <div class="box">
                <label for="">Mã xác nhận</label>
                <input type="text" id="otp-code">
            </div>
            
            <button type="submit">Xác nhận</button>
        </form>
      </div>
    </div>
  </body>
</html>
