<%@ page import="Entity.User" %>
<%@ page import="java.util.List" %><%----%>
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
    <title>Blog App - Quản lí người dùng</title>
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
                        <li class="nav-item">
                            <a class="nav-link" href="AdminHome"
                            >Quản lí blog <span class="sr-only">(current)</span></a
                            >
                        </li>

                        <li class="nav-item active">
                            <a class="nav-link" href="manager-user.jsp">Quản lí người dùng</a>
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

        <div class="accounts-container">
            <div class="accounts-wrapper">

                <!--  -->
                <% List<User> listUser = (List<User>) request.getAttribute("listAccountAdmin"); %>
                <% for (User u : listUser) { %>
                <div class="account-item">
                    <h3 class="email"><%=u.getEmail()%>
                    </h3>
                    <input type="password" class="password" value="<%=u.getPassword()%>" disabled>

                    <% if (u.getIs_locked() == 0) { %>
                    <div class="status">
                        <span class="enable">Đang hoạt động</span>
                    </div>
                    <% } else { %>
                    <div class="status">
                        <span class="disable">Bị khoá</span>
                    </div>
                    <% } %>

                    <div class="account-action">
                        <% if (u.getIs_locked() == 0) {%>
                        <button class="edit-account" style="color: red">
                            <i class="fa-solid fa-lock"></i>
                        </button>
                        <% } else if (u.getIs_locked() == 1) {%>
                        <button class="edit-account" style="color: green">
                            <i class="fa-solid fa-lock-open"></i>
                        </button>
                        <% } %>
                        <button class="delete-account" style="color: red"
                                onclick="deleteUser(id=<%=u.getId()%>)">
                            <i class="fa-regular fa-trash-can"></i></button>
                    </div>
                </div>
                <%}%>

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

    function deleteUser(id) {
        $.ajax({
            url: "AdminDeleteUser",
            type: "post",
            data: {
                id: id
            },
            success: function (data) {
                // console.log("data: ", data)
                let accounts = document.querySelector('.accounts-wrapper')
                accounts.innerHTML = data;
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
