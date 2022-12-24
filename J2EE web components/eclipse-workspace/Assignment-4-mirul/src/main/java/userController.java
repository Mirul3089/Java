

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	userModel um;
	userDAO ud;
	
  public void init()
  {
	  this.um = new userModel();
  }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uname");
		String password = request.getParameter("pword");
		
		um.setUsername(username);
	    um.setPassword(password);
	    
	    ud = new userDAO(); 
	    
        try {
	        boolean userValidate = ud.userlogin(um); 
	 
	        if(userValidate == true) 
	         {
	        	response.sendRedirect("success.jsp");
	         }
	         else
	         {
	        	 response.sendRedirect("error.jsp");
	         }
        }catch(Exception e)
        {
        	System.out.print(e);
        }
		
	}

}
