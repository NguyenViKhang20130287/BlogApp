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
    <link rel="stylesheet" href="../admin/css/style.css" />
    <title>Blog App - Quản lí người dùng</title>
  </head>
  <body>
    <div class="container-fluid d-flex justify-content-center">
      <div class="wrapper">
        <header>
          <nav class="navbar fixed-top navbar-expand-lg bg-secondary navbar-dark">
            <a class="navbar-brand" href="index.jsp" style="font-weight: 500; color: #fff;">Admin</a>
            <button
              class="navbar-toggler"
              type="button"
              data-toggle="collapse"
              data-target="#navbarNav"
              aria-controls="navbarNav"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item">
                  <a class="nav-link" href="index.jsp"
                    >Quản lí blog <span class="sr-only">(current)</span></a
                  >
                </li>
                <li class="nav-item active">
                  <a class="nav-link" href="../admin/manager-user.html"
                    >Quản lí người dùng</a
                  >
                </li>

                <li class="nav-item">
                  <a
                    class="nav-link"
                    href="#"
                    tabindex="-1"
                    aria-disabled="true"
                    >Đăng xuất</a
                  >
                </li>
              </ul>
            </div>
          </nav>
        </header>

        <div class="accounts-container">
          <div class="accounts-wrapper">

            <!--  -->
            <div class="account-item">
              <h3 class="email">vikhang17112002@gmail.com</h3>
              <input type="password" class="password" value="11111111" disabled>
              <div class="status">
                <span class="enable">Đang hoạt động</span>
                <!-- <span class="disable">Trạng thái: Bị khoá</span> -->
              </div>
              <div class="account-action">
                <button class="edit-account"><a href="edit-account.jsp"><i class="fa-regular fa-pen-to-square"></i></a></button>
                <button class="delete-account"><i class="fa-regular fa-trash-can"></i></button>
              </div>
            </div>
            <!--  -->
            <div class="account-item">
              <h3 class="email">vikhang17112002@gmail.com</h3>
              <input type="password" class="password" value="11111111" disabled>
              <div class="status">
                <span class="enable">Đang hoạt động</span>
                <!-- <span class="disable">Trạng thái: Bị khoá</span> -->
              </div>
              <div class="account-action">
                <button class="edit-account"><a href="edit-blog.html"><i class="fa-regular fa-pen-to-square"></i></a></button>
                <button class="delete-account"><i class="fa-regular fa-trash-can"></i></button>
              </div>
            </div>
            <!--  -->
            <div class="account-item">
              <h3 class="email">vikhang17112002@gmail.com</h3>
              <input type="password" class="password" value="11111111" disabled>
              <div class="status">
                <!-- <span class="enable">Đang hoạt động</span> -->
                <span class="disable">Bị khoá</span>
              </div>
              <div class="account-action">
                <button class="edit-account"><a href="edit-blog.html"><i class="fa-regular fa-pen-to-square"></i></a></button>
                <button class="delete-account"><i class="fa-regular fa-trash-can"></i></button>
              </div>
            </div>
            <!--  -->
            <div class="account-item">
              <h3 class="email">vikhang17112002@gmail.com</h3>
              <input type="password" class="password" value="11111111" disabled>
              <div class="status">
                <span class="enable">Đang hoạt động</span>
                <!-- <span class="disable">Trạng thái: Bị khoá</span> -->
              </div>
              <div class="account-action">
                <button class="edit-account"><a href="edit-blog.html"><i class="fa-regular fa-pen-to-square"></i></a></button>
                <button class="delete-account"><i class="fa-regular fa-trash-can"></i></button>
              </div>
            </div>
            
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
