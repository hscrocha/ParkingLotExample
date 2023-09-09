<%--
  Created by IntelliJ IDEA.
  User: hsrocha
  Date: 9/8/23
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="components/header.jsp"/>
</head>
<body>
<jsp:include page="components/title.jsp"/>
<jsp:include page="components/mainmenu.jsp"/>
<%-- Here you put the content for this page --%>

<div class="container mt-2">
    <h3 class="center text-primary"> Login </h3>
    <form method="post" action="loginServlet">
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_login"> Login: </label>
            <div class="col-12 col-md-6">
                <input class="form-control" type="email" name="txt_login" id="txt_login" required/>
            </div>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_pass"> Password: </label>
            <div class="col-12 col-md-6">
                <input class="form-control" type="password" name="txt_pass" id="txt_pass" autocomplete="off"
                       minlength="6" required/>
            </div>
        </div>

        <div class="row mb-2">
            <div class="offset-md-1 col-12 col-md-2 d-grid">
                <button type="submit" class="btn btn-success me-2"> <span class="bi bi-box-arrow-in-right"></span> Login </button>
            </div>
            <div class="col-12 col-md-2 d-grid">
                <button type="reset" class="btn btn-warning me-2" id="clear_button"> Clear</button>
            </div>
            <div class="col-12 col-md-2 d-grid">
                <button type="button" class="btn btn-danger me-2" href="index.jsp"> Cancel</button>
            </div>
        </div>
    </form>
</div>


<br/><br/>
<br/><br/>
<br/><br/>

<%-- =================================== --%>
<jsp:include page="components/footer.jsp" />
<script type="text/javascript"> <%-- Any custom JS goes in the bottom --%>
</script>
</body>
</html>