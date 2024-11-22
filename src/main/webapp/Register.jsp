<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor = "grey">
       <%
       String rmsg = (String)request.getAttribute("rmsg");
       String emsg = (String)request.getAttribute("emsg");
       String lmsg = (String)request.getAttribute("lmsg");
       
       if(rmsg != null)
       {
    %>
       <h3 style="text-align: center; color: green;"><%=rmsg%></h3>
    <% 	  
       }
       
       if(emsg != null)
       {
    %>
       <h3 style="text-align: center; color: maroon;"><%=emsg%></h3>
    <% 	  
       }
       
       if(lmsg != null)
       {
    %>
       <h3 style="text-align: center; color: maroon;"><%=lmsg%></h3>
    <% 	  
       }
       %>
       <h1 style="text-align: center;">Register Here</h1>
       <form action="RegistrationChecker" method="POST" style="text-align: center;">
             Username : &nbsp; <input type="text" name="username" placeholder="Enter your username"> <br><br>
             Name : &nbsp; <input type="text" name="name" placeholder="Enter your name"> <br><br>
             Mail-Id : &nbsp; <input type="text" name="mailid" placeholder="Enter your mailid"> <br><br>
             Contact No.  : &nbsp;<input type="text" name="contact" placeholder="Enter your contact number"> <br><br>
             New-Password : &nbsp; <input type="password" name="npass" placeholder="Enter your new password"> <br><br>
             Confirm-Password : &nbsp; <input type="password" name="cpass" placeholder="Enter your confirm password"> <br><br>
             <input type="submit" value="register">
       </form> 
       <a href="login.jsp" style="text-align: center;">Sign in.</a>
</body>
</html>