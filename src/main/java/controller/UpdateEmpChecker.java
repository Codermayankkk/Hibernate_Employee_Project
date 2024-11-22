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
import pojo.EmpInfo;

@WebServlet("/UpdateEmpChecker")
public class UpdateEmpChecker extends HttpServlet 
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
		
		EmpInfo e1 = new EmpInfo(empid, emp_name, emp_mailid, emp_contact);
		
	    Session ss = StaticSession.getSession();	
	    Transaction tt = ss.beginTransaction();
	    ss.update(e1);
	    tt.commit();
	    
	    RequestDispatcher rd = request.getRequestDispatcher("UpdateEmp.jsp");
	    request.setAttribute("umsg", "Information updated");
	    rd.forward(request, response);
	}

}
