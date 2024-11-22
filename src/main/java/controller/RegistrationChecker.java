package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import StaticSession.StaticSession;
import pojo.Emp;
import pojo.EmpInfo;

@WebServlet("/RegistrationChecker")
public class RegistrationChecker extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  response.sendRedirect("login.jsp");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String empid = request.getParameter("username");
		String emp_name = request.getParameter("name");
		String emp_mailid = request.getParameter("mailid");
		String emp_contact = request.getParameter("contact");
	    String npass = request.getParameter("npass");
	    String cpass = request.getParameter("cpass");
	    
	    if(empid != null && emp_name !=null && emp_mailid != null && emp_contact !=null && npass !=null && cpass != null)
	    {
	    	if(npass.equals(cpass))
		    {
		       Emp e1 = new Emp();
			   e1.setEmpid(empid);
			   e1.setEmp_password(cpass);
			    
			   EmpInfo e2 = new EmpInfo(empid, emp_name, emp_mailid, emp_contact);
			   
			   Session ss = StaticSession.getSession();
			   Transaction tt = ss.beginTransaction();
			   ss.save(e1);
			   ss.save(e2);
			   tt.commit();
			   
			   request.setAttribute("rmsg", "Registration Done");
	           RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
	           rd.forward(request, response);
		    } 
		    else
		    {
		    	request.setAttribute("emsg", "Password mismatched");
	            RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
	            rd.forward(request, response);
		    }	
	    }
	    else
	    {
	    	request.setAttribute("lmsg", "Please fill the information");
            RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
            rd.forward(request, response);	
	    }
	    
	}

}
