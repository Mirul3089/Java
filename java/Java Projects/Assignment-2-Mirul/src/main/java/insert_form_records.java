
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert_form_records")
public class insert_form_records extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.jdbc.Driver");
		
		String dbURL = "jdbc:mysql://localhost:3306/as2_mirul";
		String username = "root";
		String dbp = "root";
		
		Connection con = DriverManager.getConnection(dbURL, username, dbp);
	
		String number = request.getParameter("enumber");
		String ename = request.getParameter("ename");
		String dep =request.getParameter("dep");
		String job=request.getParameter("jobs");
		
		//PrintWriter outt = response.getWriter();
		
		if(number == "") {
			String m= "Null values not allowed";
			throw new SQLException(m);
		}
		else {
		PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?)");
		ps.setString(1, number);
		ps.setString(2, ename);
		ps.setString(3, dep);
		ps.setString(4, job);
		
		int x=ps.executeUpdate();
		
		String message="value inserted";
		
		PrintWriter out = response.getWriter();
		
		   if(x==1)
		   {
			
			out.println("<html>");
			out.println("<head>");
			out.println("<body>");
			out.println("<script type='text/javascript'>");
			out.println("alert(" + "'" + message + "'" + ");</script>");
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
		   }
		}
	}
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
