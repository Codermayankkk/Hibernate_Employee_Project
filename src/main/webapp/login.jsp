<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="grey">
       <%
          String msg = (String)session.getAttribute("msg");
          if(msg != null)
          {
       %>
           <h4 style="text-align: center; color: maroon;"><%=msg%></h4>    
       <% 	  
            session.invalidate();
          }
       %>
       <h1 style="text-align: center;">Login Here</h1>
       <form action="Loginchecker" method="POST" style="text-align: center;">
              USERNAME : &nbsp;<input type="text" name="username" placeholder="Enter your username"><br><br>
              PASSWORD : &nbsp;<input type="password" name="password" placeholder="Enter your password"><br><br>
              <input type="submit" value="login"> 
       </form>
       <a href="Register.jsp" style="text-align: center;">Sign up.</a>
</body>
</html>