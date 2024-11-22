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
        if(username == null)
        {
      	 response.sendRedirect("login.jsp"); 
        }
        %>
        <h1 style="text-align: center;">Delete Account</h1>
        <%@include file="Structure.html"%><br><br><br>
        
        <form action="DeleteChecker" method="POST" style="text-align: center;">
             USERNAME : &nbsp;<input type="text" name="username" value="<%=username%>" readonly>
             <input type="submit" value="Delete">
       </form> 
</body>
</html>