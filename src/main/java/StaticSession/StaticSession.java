package StaticSession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@WebServlet("/StaticSession")
public class StaticSession extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public static Session getSession()
	{
	  SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
	  Session ss  = sf.openSession();
	  
	  return ss;
	}

}
