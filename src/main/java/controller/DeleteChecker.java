package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import StaticSession.StaticSession;
import pojo.Emp;
import pojo.EmpInfo;

@WebServlet("/DeleteChecker")
public class DeleteChecker extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  String username = request.getParameter("username");
	  
	  Emp e1 = new Emp();
	  e1.setEmpid(username);
	  
	  EmpInfo e2 = new EmpInfo();
	  e2.setEmpid(username);
	  
	  Session ss = StaticSession.getSession();
	  Transaction tt = ss.beginTransaction();
	  ss.delete(e1);
	  ss.delete(e2);
	  tt.commit();
	  
	  HttpSession s = request.getSession(true);
	  s.invalidate();
	  response.sendRedirect("login.jsp");
	}

}
