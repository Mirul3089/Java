

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class employeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	employeeDAO ed;
	
  public void init() 
  {
	  ed = new employeeDAO(); 
  }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("firstName");
		String lname=request.getParameter("lastName");
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		String add=request.getParameter("address");
		String cont=request.getParameter("contact");
		
		employeeModel emd= new employeeModel();
		
		emd.setFname(fname);
		emd.setLname(lname);
		emd.setUname(uname);
		emd.setPassword(pass);
		emd.setAddress(add);
		emd.setContact(cont);
		
		try {
			ed.registerEmployee(emd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		response.sendRedirect("employeedetails.jsp");
	  
	}

}
