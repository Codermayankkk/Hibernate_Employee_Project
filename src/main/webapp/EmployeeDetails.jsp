<%@page import="pojo.EmpInfo"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="StaticSession.StaticSession"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
       <h1 style="text-align: center;">Employee Detail</h1>
       <%@include file="Structure.html"%><br><br>
       <%
          String username = (String)session.getAttribute("username");
          if(username == null || username.equals(""))
          {
        	response.sendRedirect("login.jsp");  
          }
          
          Session ss = StaticSession.getSession();
          
          String hql = "FROM EmpInfo WHERE empid = '"+username+"'";
          Query q = ss.createQuery(hql);
          
          List<EmpInfo> l1 = q.list();
          
          if(l1 != null)
          {
        	  for(EmpInfo e1 : l1)
        	  {
       %>
              <form style="text-align: center;"><br><br>
             USERNAME : &nbsp; <input type="text" name="username" value="<%=username%>" readonly> &nbsp; &nbsp; &nbsp;
             NAME : &nbsp; <input type="text" name="name" value="<%=e1.getEmp_name()%>" readonly> &nbsp; &nbsp; &nbsp;
             Mail-Id : &nbsp; <input type="text" name="mailid" value="<%=e1.getEmp_mailid()%>"> &nbsp; &nbsp; &nbsp;
             Contact No.  : &nbsp;<input type="text" name="contact" value="<%=e1.getEmp_contact()%>"> &nbsp; &nbsp; &nbsp;
       </form> 
       <%  		  
        	  }
          }
       %>
       
</body>
</html>