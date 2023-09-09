<%@ page import="edu.loyola.cs.se.parkinglotexample.model.entity.User" %>
<%@ page import="edu.loyola.cs.se.parkinglotexample.controller.service.UserService" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hsrocha
  Date: 9/8/23
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<User> lstUsers = UserService.listUsers(null); %>

<html>
<head>
    <jsp:include page="../components/header.jsp"/>
</head>
<body>
<jsp:include page="../components/title.jsp"/>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark"> <!-- Main Menu -->
    <div class="container-fluid">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="../admin.jsp"> << Back to Admin </a>
            </li>
        </ul>
    </div>
</nav>
<%-- Here you put the content for this page --%>

<div class="container mt-2">
    <h3 class="text-primary"> <span class="bi bi-people-fill"></span> Manage Users </h3>

    <table class="table table-striped table-hover">
        <thead class="table-primary">
            <tr>
                <th style="max-width:30px">  </th>
                <th> ID </th>
                <th> Login </th>
                <th> Permission </th>
            </tr>
        </thead>
        <tbody>
            <% for(User u : lstUsers){ %>
                <tr>
                    <td style="max-width:30px">
                        <a href="#"><span class="bi bi-pencil-square text-primary" title="edit"></span></a>
                        <a href="#"><span class="bi bi-trash3 text-danger" title="delete"></span></a>
                    </td>
                    <td> <%= u.getID() %> </td>
                    <td> <%= u.getLogin() %> </td>
                    <td> <%= u.getPermissionAsString() %> </td>
            </tr>
            <% } //end for %>
        </tbody>
    </table>

</div>


<br/><br/>
<br/><br/>
<br/><br/>

<%-- =================================== --%>
<jsp:include page="../components/footer.jsp" />
<script type="text/javascript"> <%-- Any custom JS goes in the bottom --%>
</script>
</body>
</html>