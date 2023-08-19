<%--
  Created by IntelliJ IDEA.
  User: Prof H. Rocha
  Date: 8/17/23
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- This is not a complete web page.
Since the main menu web site is "basically" the same for all pages
I am going to center its code here for reuse.

Then I can just use <jsp:include> to add this menu and all its logic
to any web page I want.
--%>
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
          <li id="menu-register"><a class="dropdown-item" href="register.jsp">Register</a></li>
          <li style="display:none;" id="menu-logout"><a class="dropdown-item" href="/logout">Logout</a></li>
        </ul>
      </li>
    </ul>
  </div>
</nav>

