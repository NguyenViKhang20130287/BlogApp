<%@ page import="Entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="Entity.Blog" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Locale" %><%----%>
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
    <link rel="stylesheet" href="./admin/css/main.css"/>
    <link rel="stylesheet" href="./admin/css/toastMessage.css">
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
                            if (acc.getRole_id() == 0 && acc.getIs_locked() == 0) {%>
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
                    <div class="action">
                        <button class="delete-blog" onclick="deleteBlogs(id=<%=b.getId()%>)">
                            <i class="fa-regular fa-trash-can"></i>
                        </button>
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
    <!-- The actual snackbar -->
    <div id="snackbar"></div>
</div>
</body>

<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<script>
    function toastsMessage(message) {
        // Get the snackbar DIV
        var x = document.getElementById("snackbar");

        x.innerHTML = message

        // Add the "show" class to DIV
        x.className = "show";

        // After 3 seconds, remove the show class from DIV
        setTimeout(function () {
            x.className = x.className.replace("show", "");
        }, 3000);
    }

    function deleteBlogs(id) {
        $.ajax({
            url: "AdminDeleteBlog",
            type: "post",
            data: {
                id: id
            },
            success: function (data) {
                // console.log("data: ", data)
                let blogs = document.querySelector('.blogs-wrapper')
                blogs.innerHTML = data;
                toastsMessage("Xóa thành công")

            },
            error: function (error) {
                // alert("error")
                console.log("error: ", error)
            }
        })
    }
</script>

</html>
