<%@ page import="Entity.User" %>
<%@ page import="Entity.Blog" %><%----%>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"/>
    <link rel="stylesheet" href="./css/style.css"/>
    <script src="./ckeditor/ckeditor.js"></script>
    <title>Sửa bài đăng</title>
</head>
<body>
<div class="container-fluid d-flex justify-content-center">
    <div class="wrapper">
        <header>
            <nav class="navbar fixed-top navbar-expand-lg bg-secondary navbar-dark">
                <a class="navbar-brand" href="Home" style="font-weight: 500; color: #fff;">BlogApp</a>
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
                            <a class="nav-link" href="Home"
                            >Trang chủ <span class="sr-only">(current)</span></a
                            >
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="post-blog.jsp">Đăng blog</a>
                        </li>
                        <%--       CHECK ACCOUNT LOGGED                 --%>
                        <% HttpSession sessionAcc = request.getSession();
                            User acc = (User) sessionAcc.getAttribute("accLogged");%>

                        <% if (acc != null) { %>
                        <%if (acc.getRole_id() == 0) {%>
                        <li class="nav-item active">
                            <a class="nav-link" href="LoadBlogUser?user_id=<%=acc.getId()%>"><%=acc.getEmail()%>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AdminHome">Quản lí website</a>
                        </li>
                        <% } else { %>
                        <li class="nav-item active">
                            <a class="nav-link" href="LoadBlogUser?user_id=<%=acc.getId()%>"><%=acc.getEmail()%>
                            </a>
                        </li>
                        <% } %>
                        <% } else { %>
                        <% response.sendRedirect("login.jsp"); %>
                        <% } %>
                        <%--                        --%>
                        <%--          LOGOUT ACCOUNT              --%>
                        <li class="nav-item">
                            <a class="nav-link"
                               href="LogoutControl"
                               tabindex="-1"
                               aria-disabled="true"
                            >Đăng xuất</a>
                        </li>
                        <%--                        --%>
                    </ul>
                </div>
            </nav>
        </header>

        <%Blog b = (Blog) request.getAttribute("dataBlog");%>
        <form action="EditBlogControl" method="get">
            <div class="wrapper-edit">

                <input type="text" value="<%=b.getId()%>" name="blog_id" style="display: none">

                <div class="title-edit">
                    <label for="">tiêu đề</label>
                    <input type="text" name="title" value="<%=b.getTitle()%>" >
                </div>

                <textarea id="editor1" name="editor2" cols="80" rows="10">
              <%=b.getContent()%>
          </textarea>

                <!-- (3): Code Javascript thay thế textarea có id='editor1' bởi CKEditor -->
                <script>

                    CKEDITOR.replace('editor2');

                </script>
                <div class="action-edit">
                    <button type="submit">Đăng</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
