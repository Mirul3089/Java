

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteservlet")
public class deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	M_47_friends mf = new M_47_friends();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		deletequery dq = new deletequery();
		 dq.deletefriend();
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("v_47_display.jsp");
			dispatcher.forward(request, response);
	}

}
