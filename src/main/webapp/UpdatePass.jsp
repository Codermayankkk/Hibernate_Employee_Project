<%@page import="java.util.List"%>
<%@page import="pojo.Emp"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.cfg.AnnotationConfiguration"%>
<%@page import="org.hibernate.SessionFactory"%>
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
          String pmsg = (String)request.getAttribute("Password updated");
          String mismsg = (String)request.getAttribute("mismsg");
          String errormsg = (String)request.getAttribute("errormsg");
          
          if(pmsg != null)
          {
       %>
          <h3 style="text-align: center; color: green;"><%=pmsg%></h3>
       <% 	  
          }
          if(mismsg != null)
          {
       %>
           <h3 style="text-align: center; color: maroon;"><%=mismsg%></h3>
       <%  	  
          }
          if(errormsg != null)
          {
       %>
           <h3 style="text-align: center; color: maroon;"><%=errormsg%></h3>
       <%  	  
          }
          if(username == null)
          {
        	 response.sendRedirect("login.jsp"); 
          }
       %>
            <h1 style="text-align: center;">Update Employee Password</h1>
            <%@include file="Structure.html"%><br><br>
       <form action="UpdatePassChecker" method="POST" style="text-align: center;">
             <input type="hidden" name="username" value="<%=username%>" readonly>
             Old-Password : &nbsp; <input type="password" name="opass" placeholder="Enter your current password"> <br><br>
             New-Password : &nbsp; <input type="password" name="npass" placeholder="Enter your new password"> <br><br>
             Confirm-Password : &nbsp; <input type="password" name="cpass" placeholder="Enter your confirm password"> <br><br>
             <input type="submit" value="update">
       </form> 
</body>
</html>