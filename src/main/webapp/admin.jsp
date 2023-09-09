<%@ page import="edu.loyola.cs.se.parkinglotexample.model.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Prof H Rocha
  Date: Sep/08/23
  Time: 14:40
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User logged = (User) session.getAttribute("User");
%>

<html>
<head>
    <jsp:include page="components/header.jsp"/>
</head>
<body>
<jsp:include page="components/title.jsp"/>
<jsp:include page="components/mainmenu.jsp"/>
<%-- Here you put the content for this page --%>

<div class="container mt-2">
    <h3 class="center text-primary"> Admin </h3>

    <div class="row">
        <div class="d-grid col-3 col-md-1 offset-1">
            <a href="#" class="btn btn-primary" style="width:100px">
                <h3><span class="bi bi-people-fill"></span></h3>
                Manage Users
            </a>
        </div>
        <div class="d-grid col-3 col-md-1 offset-1">
            <a href="#" class="btn btn-primary" style="width:100px">
                <h3><span class="bi bi-chat-text-fill"></span></h3>
                Contact Messages
            </a>
        </div>
        <div class="d-grid col-3 col-md-1 offset-1">
            <a href="#" class="btn btn-primary" style="width:100px">
                <h3><span class="bi bi-gear-fill"></span></h3>
                App Settings
            </a>
        </div>
    </div>
</div>

<%-- =================================== --%>
<jsp:include page="components/footer.jsp" />
<script type="text/javascript"> <%-- Any custom JS goes in the bottom --%>
</script>
</body>
</html>
