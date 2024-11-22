<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <%
          String username = (String)session.getAttribute("username");
          if(username == null || username.equals(""))
          {
        	response.sendRedirect("login.jsp");  
          }
       %>
       <h1 style="text-align: center;">HOME</h1>
       <%@include file="Structure.html"%>
</body>
</html>