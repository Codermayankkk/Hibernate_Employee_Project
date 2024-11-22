<%@page import="pojo.EmpInfo"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
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
          String umsg = (String)request.getAttribute("umsg");
          
          if(umsg != null)
          {
      %>  
          <h3 style="text-align: center; color: green;"><%=umsg%></h3>
      <%  	  
          }
          else
          {
      %>  
              
      <%   	  
          }
          if(username == null)
          {
        	 response.sendRedirect("login.jsp"); 
          }
          
          SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
          Session ss = sf.openSession();
          
          String hql = "FROM EmpInfo WHERE empid = '"+username+"'";
          Query q = ss.createQuery(hql);
          
          List<EmpInfo> l1 = q.list();
          
          if(l1 != null)
          {
        	  for(EmpInfo e1 : l1)
        	  {
       %>
            <h1 style="text-align: center;">Update Employee Information</h1>
            <%@include file="Structure.html"%><br><br>
       <form action="UpdateEmpChecker" method="POST" style="text-align: center;">
             USERNAME : &nbsp; <input type="text" name="username" value="<%=username%>" readonly> <br><br>
             NAME : &nbsp; <input type="text" name="name" value="<%=e1.getEmp_name()%>" readonly> <br><br>
             Mail-Id : &nbsp; <input type="text" name="mailid" value="<%=e1.getEmp_mailid()%>"> <br><br>
             Contact No.  : &nbsp;<input type="text" name="contact" value="<%=e1.getEmp_contact()%>"> <br><br>
             <input type="submit" value="update">
       </form> 
       <% 		  
        	  }
          }
       %>
       
</body>
</html>