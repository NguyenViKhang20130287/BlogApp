<%@ page import="java.util.List" %>
<%@ page import="Dao.BlogDAO" %>
<%@ page import="Entity.Blog" %>
<%@ page import="Entity.User" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Locale" %><%-- JSP --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
    />
    <link rel="stylesheet" href="./css/style.css"/>
    <title>Blog App</title>
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
                        <li class="nav-item active">
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
                        <li class="nav-item">
                            <a class="nav-link" href="LoadBlogUser?user_id=<%=acc.getId()%>"><%=acc.getEmail()%>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AdminHome">Quản lí website</a>
                        </li>
                        <% } else { %>
                        <li class="nav-item">
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

        <div class="blogs-container">
            <div class="blogs-wrapper">
                <% List<Blog> listBlog = (List<Blog>) request.getAttribute("listBlog");
                    for (Blog b : listBlog) {%>
                <div class="blog-item">
                    <h3 class="title"><%=b.getTitle()%>
                    </h3>
                    <% DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.US);
                        LocalDateTime createAt = LocalDateTime.parse(b.getCreateAt(), dtf);
                        LocalDateTime updateAt = LocalDateTime.parse(b.getUpdateAt(), dtf);
                        int diff = createAt.compareTo(updateAt);
                        if (diff < 0) {%>
                    <span class="timer">
                            Cập nhật lúc: <%=b.getUpdateAt()%>
                        </span>
                    <%} else {%>
                    <span class="timer">
                            Vừa đăng lúc: <%=b.getCreateAt()%>
                        </span>
                    <%}%>
                    <p class="content">
                        <%=b.getContent()%>
                    </p>
                    <span class="email-User"> <%=b.getEmail()%> </span>
                </div>
                <%}%>

            </div>
        </div>
    </div>
</div>
</body>
</html>
