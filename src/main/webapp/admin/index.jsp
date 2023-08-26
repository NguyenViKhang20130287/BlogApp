<%@ page import="Entity.User" %>
<%@ page import="java.util.List" %>
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
    <title>Blog App - Quản lí blog</title>
</head>
<body>
<div class="container-fluid d-flex justify-content-center">
    <div class="wrapper">
        <header>
            <nav class="navbar fixed-top navbar-expand-lg bg-secondary navbar-dark">
                <a class="navbar-brand" href="AdminHome" style="font-weight: 500; color: #fff;">Admin</a>
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
                            <a class="nav-link" href="AdminHome"
                            >Quản lí blog <span class="sr-only">(current)</span></a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="AdminUserManager">Quản lí người dùng</a>
                        </li>

                        <% HttpSession sessionAcc = request.getSession();
                            User acc = (User) sessionAcc.getAttribute("accLogged");%>
                        <% if (acc != null) {
                            if (acc.getRole_id() == 0) {%>
                        <li class="nav-item">
                            <a class="nav-link" href="LogoutControl">Đăng xuất (<%=acc.getEmail()%>)</a>
                        </li>
                        <% } else { %>
                        <% response.sendRedirect("login.jsp"); %>
                        <% }
                        } else { %>
                        <% response.sendRedirect("login.jsp"); %>
                        <% } %>
                        <%--                        --%>
                    </ul>
                </div>
            </nav>
        </header>

        <div class="blogs-container">
            <div class="blogs-wrapper">

                <% List<Blog> listBlog = (List<Blog>) request.getAttribute("listBlogAdmin");
                    if (!listBlog.isEmpty()) {
                        for (Blog b : listBlog) {%>
                <div class="blog-item">
                    <div class="main">
                        <h3 class="title"><%=b.getTitle()%>
                        </h3>
                        <span class="timer"><%=b.getCreateAt()%></span>
                        <p class="content">
                            <%=b.getContent()%>
                        </p>
                        <span class="email-User"> <%=b.getEmail()%> </span>
                    </div>
                    <div class="action">
                        <button class="delete-blog"><i class="fa-regular fa-trash-can"></i></button>
                    </div>
                </div>
                <%
                    }
                } else {%>
                <div class="empty-container">
                    <h1>Không có bài đăng nào !</h1>
                </div>
                <% } %>
            </div>
        </div>
    </div>
</div>
</body>
</html>
