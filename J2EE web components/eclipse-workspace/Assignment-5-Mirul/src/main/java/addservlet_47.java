

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/addservlet_47")
public class addservlet_47 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	M_47_friends mf = new M_47_friends();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fname=request.getParameter("fn");
		String email=request.getParameter("em");
		int age= Integer.parseInt(request.getParameter("ag"));
		String fcolor=request.getParameter("fc");
		
		if (fname == null ||email == null||age <= 0 ||fcolor == null)
		{
			 RequestDispatcher dispatcher1 = request.getRequestDispatcher("error.jsp");
				dispatcher1.forward(request, response);
		}
		mf.setFname(fname);
		mf.setEmail(email);
        mf.setAge(age);
        mf.setFcolor(fcolor);
        
	 addquery aq = new addquery();
	 aq.addfriend(mf);
	 
	 RequestDispatcher dispatcher = request.getRequestDispatcher("v_47_display.jsp");
		dispatcher.forward(request, response);
	 
	}

}
