package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import StaticSession.StaticSession;
import pojo.Emp;

@WebServlet("/UpdatePassChecker")
public class UpdatePassChecker extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
      response.sendRedirect("login.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
      String opass = request.getParameter("opass");
      String npass = request.getParameter("npass");
      String cpass = request.getParameter("cpass");
      String username = request.getParameter("username");
      String tablepassword = "";

      Session ss = StaticSession.getSession();
      Transaction tt = ss.beginTransaction();
      
      String hql1 = "FROM Emp WHERE empid = '"+username+"'";
      Query q1 = ss.createQuery(hql1);
      
      List<Emp> l1 = q1.list();
      if(l1 != null)
      {
    	for(Emp e : l1)
    	{
    	  	tablepassword = e.getEmp_password();
    	}
      }
      
      if(opass.equals(tablepassword))
      {
    	 if(npass.equals(cpass))
    	 {
    		Emp e1 = new Emp();
    	    e1.setEmp_password(cpass);
    	      
    	    String hql = "UPDATE Emp SET emp_password = '"+cpass+"' WHERE empid = '"+username+"'"; 
    	    q1 = ss.createQuery(hql);
    	    q1.executeUpdate();
    	    tt.commit();
    	    
    	    request.setAttribute("pmsg", "Password Updated");
            RequestDispatcher rd = request.getRequestDispatcher("UpdatePass.jsp");
            rd.forward(request, response);
          }
    	  else
    	  {
    		request.setAttribute("mismsg", "Your new and confirm password are not matched");
            RequestDispatcher rd = request.getRequestDispatcher("UpdatePass.jsp");
            rd.forward(request, response);  
    	  }   	 
      }
      else
      {
    	request.setAttribute("errormsg", "Your current password is not correct");
        RequestDispatcher rd = request.getRequestDispatcher("UpdatePass.jsp");
        rd.forward(request, response);  
      }
	}

}
