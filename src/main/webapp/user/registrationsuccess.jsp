<%--
  Created by IntelliJ IDEA.
  User: Prof H Rocha
  Date: 8/20/23
  Time: 09:33

  IMPORTANT: This is to just show how you can use 'temp web pages' and
     automatic redirects. Do not overuse this in your website.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="../components/header.jsp"/>
  <meta http-equiv="Refresh" content="4;url=../index.jsp"> <!-- redirects after 4 secs -->
</head>
<body>
<jsp:include page="../components/title.jsp" />

<%-- Here you put the content for this page --%>
<div class="container">
  <br/>
  <div class="alert alert-primary" role="alert">
    <h4 class="alert-heading">Registration Successful!</h4>
    <p>Well done. You registered successfully in our Web App.</p>
    <hr>
    <p class="mb-0">
    <div class="spinner-border" role="status">
      <span class="visually-hidden">Loading...</span>
    </div>
      You will be redirected automatically to our main page in a few seconds.
    <div class="spinner-border ms-auto" role="status" aria-hidden="true"></div>
    </p>
  </div>

</div>

<br/><br/><br/><br/><br/>
<%-- =================================== --%>
<jsp:include page="../components/footer.jsp" />
<script type="text/javascript"> <%-- Any custom JS goes in the bottom --%>
</script>
</body>
</html>