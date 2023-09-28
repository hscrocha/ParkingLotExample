<%--
  Created by IntelliJ IDEA.
  User: hsrocha
  Date: 9/26/23
  Time: 22:06
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
    <h3 class="center text-primary"> Contact </h3>
    <form method="post" action="">
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_name"> Name: </label>
            <div class="col-12 col-md-6">
                <input class="form-control" type="text" name="txt_name" id="txt_name" />
            </div>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_email"> Email: </label>
            <div class="col-12 col-md-6">
                <input class="form-control" type="email" name="txt_email" id="txt_email" required/>
            </div>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_subject"> Subject: </label>
            <div class="col-12 col-md-6">
                <input class="form-control" type="text" name="txt_subject" id="txt_subject" required/>
            </div>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_message"> Message: </label>
            <div class="col-12 col-md-6">
                <textarea class="form-control" id="txt_message" name="txt_message" rols="8" style="height:150px" required>

                </textarea>
            </div>
        </div>

        <div class="row mb-2">
            <div class="offset-md-1 col-12 col-md-2 d-grid">
                <button type="submit" class="btn btn-success me-2"> <span class="bi bi-send-fill"></span> Send </button>
            </div>
            <div class="col-12 col-md-2 d-grid">
                <button type="reset" class="btn btn-warning me-2" id="clear_button"> Clear</button>
            </div>
            <div class="col-12 col-md-2 d-grid">
                <a type="button" class="btn btn-danger me-2" href="index.jsp"> Cancel</a>
            </div>
        </div>
    </form>
</div>


<%-- =================================== --%>
<jsp:include page="components/footer.jsp" />
<script type="text/javascript"> <%-- Any custom JS goes in the bottom --%>
</script>
</body>
</html>