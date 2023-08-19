<%--
  Created by IntelliJ IDEA.
  User: Prof H. Rocha
  Date: 8/17/23
  Time: 20:45
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
    <h3 class="center text-primary"> Register New User </h3>
    <form method="post" action="hello-servlet">
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_name"> Name: </label>
            <%-- BUG: This form has Name (not in my DB) to show that Web page Form is not the same as DB Entity  --%>
            <div class="col-12 col-md-6">
                <input class="form-control" type="text" name="txt_name" id="txt_name" />
            </div>
        </div>
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
            <label class="col-form-label col-md-3 col-lg-1" for="txt_conf"> Confirm Password: </label>
            <div class="col-12 col-md-6">
                <input class="form-control" type="password" name="txt_conf" id="txt_conf" autocomplete="off"
                       minlength="6" required/>
            </div>
        </div>
        <%-- Notice there is no permission. Normal Users cannot choose their permission. --%>

        <div class="row mb-2">
            <div class="offset-md-1 col-12 col-md-2 d-grid">
                <button type="submit" onclick="return checkRegisterForm()" class="btn btn-success me-2"> Register</button>
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

<%-- =================================== --%>
<jsp:include page="components/footer.jsp"/>
<script type="text/javascript"> <%-- Any custom JS goes in the bottom --%>
    //Javascript functions are great for quick form checks before sending data to the Servlet
    function checkRegisterForm(){
        let pass = document.getElementById("txt_pass").value;
        let conf = document.getElementById("txt_conf").value;
        if(pass === conf){
            //Typed text in Password and Confirm Password are the same
            return true;
        } else {
            //Typed text in Password and Confirm Password do not match.
            window.alert("Passwords do not match."); //Just an example, it is better to give more detail message for users
            return false;
        }
    }
</script>
</body>
</html>
