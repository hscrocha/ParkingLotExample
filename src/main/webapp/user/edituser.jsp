<%--
  Created by IntelliJ IDEA.
  User: Prof H. Rocha
  Date: 9/10/23
  Time: 12:05
  Adapted from register.jsp
  For now only Admin crudusers.jsp is using this...
  But we can adapt this page to use for a User editing its own profile.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String parId = request.getParameter("id");
    String parLogin = request.getParameter("login");
    String parPerm = request.getParameter("perm");
    if(parPerm==null) parPerm="1";

    String error = request.getParameter("error");
    String errorMessage = "";

    if(error != null) {
        switch (error) {
            case "1":
                errorMessage = "Email already registered in our App.";
                break;
            case "2":
                errorMessage = "Unexpected error. Please contact the web master.";
                break;
        }
    }

%>
<html>
<head>
    <jsp:include page="../components/header.jsp"/>
</head>
<body>
<jsp:include page="../components/title.jsp"/>
<jsp:include page="../components/mainmenu.jsp"/>
<%-- Here you put the content for this page --%>

<div class="container mt-2">
    <h3 class="center text-primary"> Edit User </h3>
    <form method="post" action="../updateUserServlet">
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_id"> ID: </label>
            <div class="col-12 col-md-6">
                <input class="form-control" type="text" name="txt_id" id="txt_id" value="<%= parId %>" readonly />
            </div>
        </div>
        <!-- <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_name"> Name: </label>
            <%-- BUG: This form has Name (not in my DB) to show that Web page Form is not the same as DB Entity  --%>
            <div class="col-12 col-md-6">
                <input class="form-control" type="text" name="txt_name" id="txt_name" />
            </div>
        </div> -->
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_login"> Login: </label>
            <div class="col-12 col-md-6">
                <input class="form-control" type="email" name="txt_login" id="txt_login" value="<%= parLogin %>" required/>
            </div>
        </div>
        <%-- Notice that now there is permission, since admin is using it.
         If we reuse this page for normal users, we need to "hide" permission --%>
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_perm"> Permission: </label>
            <div class="col-12 col-md-6">
                <select class="form-select" name="txt_perm" id="txt_perm">
                    <option value="1" <%= parPerm.equals("2")?"":"selected" %> > Normal </option>
                    <option value="2" <%= parPerm.equals("2")?"selected":"" %> > Admin </option>
                </select>
            </div>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_pass"> Password: </label>
            <div class="col-12 col-md-6">
                <input class="form-control" type="password" name="txt_pass" id="txt_pass" autocomplete="off"
                       minlength="6" />
                <%-- We do not "fill passwords" on edit,
                    1st - it is hashed and makes no sense to display it to user
                    2nd - security
                --%>
            </div>
        </div>
        <div class="row mb-2">
            <label class="col-form-label col-md-3 col-lg-1" for="txt_conf"> Confirm Password: </label>
            <div class="col-12 col-md-6">
                <input class="form-control" type="password" name="txt_conf" id="txt_conf" autocomplete="off"
                       minlength="6" />
            </div>
        </div>

        <div class="row mb-2">
            <div class="offset-md-1 col-12 col-md-2 d-grid">
                <button type="submit" onclick="return checkPasswordsOnForm()" class="btn btn-success me-2"> Save</button>
            </div>
            <div class="col-12 col-md-2 d-grid">
                <button type="reset" class="btn btn-warning me-2" id="clear_button"> Clear</button>
            </div>
            <div class="col-12 col-md-2 d-grid">
                <button type="button" class="btn btn-danger me-2" onclick="history.back()"> Cancel</button>
            </div>
        </div>
    </form>
</div>

<% if(errorMessage.length()>0){ %>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="alert alert-danger alert-dismissible">
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                <strong>Error!</strong> <%= errorMessage %>
            </div>
        </div>
    </div>
</div>
<% } /*Closing IF */ %>

<br/><br/>

<%-- =================================== --%>
<jsp:include page="../components/footer.jsp"/>
<script type="text/javascript"> <%-- Any custom JS goes in the bottom --%>
    //Javascript functions are great for quick form checks before sending data to the Servlet
    function checkPasswordsOnForm(){
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
