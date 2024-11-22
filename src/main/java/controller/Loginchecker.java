package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import pojo.Emp;

import org.hibernate.Session;
import org.hibernate.Criteria;

@WebServlet("/Loginchecker")
public class Loginchecker extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
      response.sendRedirect("Login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       
       SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
       Session ss = sf.openSession();
       
       Criteria ct = ss.createCriteria(Emp.class);
       
       ct.add(Restrictions.eq("empid", username));
       ct.add(Restrictions.eq("emp_password", password));
       
       List l1 = ct.list();
       
       if(!l1.isEmpty())
       {
         HttpSession session = request.getSession(true);
         session.setAttribute("username", username);
         response.sendRedirect("home.jsp");
       }
       else
       {
    	 HttpSession session = request.getSession(true);
    	 session.setAttribute("msg", "Login Failed");
    	 response.sendRedirect("login.jsp");
       }
	}
}
