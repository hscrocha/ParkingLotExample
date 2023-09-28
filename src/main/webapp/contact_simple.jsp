<%--
  Created by IntelliJ IDEA.
  User: hsrocha
  Date: 9/28/23
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="components/header.jsp" />
</head>
<body>
  <jsp:include page="components/title.jsp" />
  <jsp:include page="components/mainmenu.jsp" />

<form action="messageContactServlet">
  Name: <input type="text" name="txt_name" id="txt_name" /> <br/>
  Email: <input type="email" name="txt_email" id="txt_email" /> <br/>
  Subject: <input type="text" name="txt_subject" id="txt_subject" /> <br/>
  Message:<textarea name="txt_message" id="txt_message" rols="5"> </textarea> <br/>
  <button type="submit"> Send <i class="bi bi-chat-left-text"></i> </button>
</form>

<jsp:include page="components/footer.jsp" />
</body>
</html>
