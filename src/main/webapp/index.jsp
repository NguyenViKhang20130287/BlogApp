<%-- JSP --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="./css/style.css" />
    <title>Blog App</title>
  </head>
  <body>
    <div class="container-fluid d-flex justify-content-center">
      <div class="wrapper">
        <header>
          <nav class="navbar fixed-top navbar-expand-lg bg-secondary navbar-dark">
            <a class="navbar-brand" href="index.html" style="font-weight: 500; color: #fff;">BlogApp</a>
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
                <li class="nav-item active">
                  <a class="nav-link" href="index.html"
                    >Trang chủ <span class="sr-only">(current)</span></a
                  >
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="post-blog.jsp">Đăng blog</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="blogs-user.jsp">vikhang17112002@gmail.com</a>
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

        <div class="blogs-container">
          <div class="blogs-wrapper">
            <div class="blog-item">
              <h3 class="title">ten tieu de</h3>
              <span class="timer">2023-08-19 12:07:10</span>
              <p class="content">
                noi dung noi dung noi dung noi dung noi dung noi dung noi dung
                noi dungnoi dungnoi dung noi dung noi dung noi dung noi dung noi
                dung noi dung noi dung noi dungnoi dungnoi dung
              </p>
              <span class="email-User"> vikhang17112002@gmail.com </span>
            </div>
            <div class="blog-item">
              <h3 class="title">ten tieu de</h3>
              <span class="timer">2023-08-19 12:07:10</span>
              <p class="content">
                noi dung noi dung noi dung noi dung noi dung noi dung noi dung
                noi dungnoi dungnoi dung noi dung noi dung noi dung noi dung noi
                dung noi dung noi dung noi dungnoi dungnoi dung
              </p>
              <span class="email-User"> vikhang17112002@gmail.com </span>
            </div>
            <div class="blog-item">
              <h3 class="title">ten tieu de</h3>
              <span class="timer">2023-08-19 12:07:10</span>
              <p class="content">
                noi dung noi dung noi dung noi dung noi dung noi dung noi dung
                noi dungnoi dungnoi dung noi dung noi dung noi dung noi dung noi
                dung noi dung noi dung noi dungnoi dungnoi dung
              </p>
              <span class="email-User"> vikhang17112002@gmail.com </span>
            </div>
            <div class="blog-item">
              <h3 class="title">ten tieu de</h3>
              <span class="timer">2023-08-19 12:07:10</span>
              <p class="content">
                noi dung noi dung noi dung noi dung noi dung noi dung noi dung
                noi dungnoi dungnoi dung noi dung noi dung noi dung noi dung noi
                dung noi dung noi dung noi dungnoi dungnoi dung
              </p>
              <span class="email-User"> vikhang17112002@gmail.com </span>
            </div>
            <div class="blog-item">
              <h3 class="title">ten tieu de</h3>
              <span class="timer">2023-08-19 12:07:10</span>
              <p class="content">
                noi dung noi dung noi dung noi dung noi dung noi dung noi dung
                noi dungnoi dungnoi dung noi dung noi dung noi dung noi dung noi
                dung noi dung noi dung noi dungnoi dungnoi dung
              </p>
              <span class="email-User"> vikhang17112002@gmail.com </span>
            </div>
            <div class="blog-item">
              <h3 class="title">ten tieu de</h3>
              <span class="timer">2023-08-19 12:07:10</span>
              <p class="content">
                noi dung noi dung noi dung noi dung noi dung noi dung noi dung
                noi dungnoi dungnoi dung noi dung noi dung noi dung noi dung noi
                dung noi dung noi dung noi dungnoi dungnoi dung
              </p>
              <span class="email-User"> vikhang17112002@gmail.com </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>