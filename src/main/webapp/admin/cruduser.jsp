<%@ page import="edu.loyola.cs.se.parkinglotexample.model.entity.User" %>
<%@ page import="edu.loyola.cs.se.parkinglotexample.controller.service.UserService" %>
<%@ page import="java.util.List" %>
<%--
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

    <%-- The Crud View Table --%>
    <table class="table table-striped table-hover">
        <thead class="table-primary">
            <tr>
                <th style="max-width:30px">
                    <button type="button" class="btn btn-sm btn-success" title="New User" data-bs-toggle="modal" data-bs-target="#UserFormModal"> <span class="bi bi-person-plus-fill"></span>  </button>
                </th>
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
                        <a href="../deleteUserServlet?id=<%= u.getID()%>" onclick="return window.confirm('Are you sure?')"><span class="bi bi-trash3 text-danger" title="delete"></span></a>
                    </td>
                    <td> <%= u.getID() %> </td>
                    <td> <%= u.getLogin() %> </td>
                    <td> <%= u.getPermissionAsString() %> </td>
            </tr>
            <% } //end for %>
        </tbody>
    </table>
</div>

<!-- The Modal -->
<div class="modal" id="UserFormModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title" id="UserModalTitle">New User</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <form class="was-validated" method="post" action="crudUserServlet">
                <!-- Modal body -->
                <div class="modal-body">
                    <div class="container" id="UserMainForm">
                        <div class="row mb-2">
                            <label class="col-form-label col-md-3 col-lg-1" for="txt_name"> Name: </label>
                            <div class="col-12 col-md">
                                <input class="form-control" type="text" name="txt_name" id="txt_name" required />
                            </div>
                        </div>
                        <div class="row mb-2">
                            <label class="col-form-label col-md-3 col-lg-1" for="txt_login"> Login: </label>
                            <div class="col-12 col-md">
                                <input class="form-control" type="email" name="txt_login" id="txt_login" required />
                            </div>
                        </div>
                        <div class="row mb-2">
                            <label class="col-form-label col-md-3 col-lg-1" for="txt_pass"> Password: </label>
                            <div class="col-12 col-md">
                                <input class="form-control" type="password" name="txt_pass" id="txt_pass" minlength="6" required />
                            </div>
                        </div>
                        <div class="row mb-2">
                            <label class="col-form-label col-md-3 col-lg-1" for="txt_perm"> Permission: </label>
                            <div class="col-12 col-md">
                                <select class="form-select" name="txt_perm" id="txt_perm">
                                    <option value="2">Normal</option>
                                    <option value="1">Admin</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-success me-2"> Save </button>
                    <button type="reset" class="btn btn-warning me-2" id="clear_button"> Clear </button>
                    <button type="button" class="btn btn-danger me-2" data-bs-dismiss="modal">Cancel</button>
                </div>
            </form>

        </div>
    </div>
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