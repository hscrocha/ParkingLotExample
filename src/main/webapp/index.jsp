<%--
  Created by IntelliJ IDEA.
  User: Prof. H. Rocha
  Date: 8/4/23
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CS482 Parking Lot Example</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body>
    <div class="p-4 bg-primary text-white text-center"> <!-- Jumbotron -->
       <h1>CS482 Parking Lot <span class="bi bi-truck-front-fill"></span>  Example</h1>
    </div>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark"> <!-- Main Menu -->
        <div class="container-fluid">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp"><span class="bi-house-fill"></span> Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="users.html">Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Contact</a>
                </li>
                <li id="menu-admin" style="display:none" class="nav-item">
                    <a class="nav-link" href="admin.html">Admin</a>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><span class="bi-person-circle"></span> Account</a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li id="menu-login"><a class="dropdown-item" href="/login.html">Login</a></li>
                        <li id="menu-register"><a class="dropdown-item" href="/register.html">Register</a></li>
                        <li style="display:none;" id="menu-logout"><a class="dropdown-item" href="/logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>



    <div class="mt-5 p-4 bg-dark text-white text-center">
        <p>Loyola University Maryland -- CS Department</p>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
