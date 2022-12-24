

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myservlet
 */
@WebServlet("/myservlet")
public class myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		InetAddress ip = InetAddress.getLocalHost();
		//String hh=ip.getHostAddress();
		//String hh1=ip.getHostName();
		//response.getWriter().append(hh);
		//response.getWriter().append(hh1);
		
		String mm = request.getParameter("name");
		response.getWriter().append(mm);
		// TODO Auto-generated method stub
		//response.getWriter().append("hello").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("hellooooo");
	}


	

}