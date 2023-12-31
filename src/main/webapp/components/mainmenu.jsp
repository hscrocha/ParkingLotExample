<%@ page import="edu.loyola.cs.se.parkinglotexample.model.entity.User" %><%--
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
<%
  //Logged User to show/hide certain parts of the menu
  User logged = (User) session.getAttribute("User");
%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark"> <!-- Main Menu -->
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="index.jsp"><span class="bi-house-fill"></span> Home</a>
      </li>
      <% if(logged!=null){ //user is logged in the website %>
      <li class="nav-item">
        <a class="nav-link" href="#">My Vehicles</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Parking</a>
      </li>
      <% } //end-if %>
      <li class="nav-item">
        <a class="nav-link" href="contact.jsp">Contact</a>
      </li>
      <% if(logged!=null && logged.getPermission()==User.ADMIN_PERMISSION){ %>
      <li id="menu-admin" class="nav-item">
        <a class="nav-link" href="admin.jsp">Admin</a>
      </li>
      <% } //end-if %>
    </ul>
    <ul class="navbar-nav ms-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"><span class="bi-person-circle"></span> Account</a>
        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
          <% if(logged==null){ //User is not logged in the website %>
            <li id="menu-login"><a class="dropdown-item" href="login.jsp">Login</a></li>
            <li id="menu-register"><a class="dropdown-item" href="register.jsp">Register</a></li>
          <% } else { //User is logged %>
            <li id="menu-profile"><a class="dropdown-item" href="#">Profile</a></li>
            <li id="menu-logout"><a class="dropdown-item" href="logoutServlet">Logout</a></li>
          <% } //Closing else %>
        </ul>
      </li>
    </ul>
  </div>
</nav>

