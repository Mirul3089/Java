

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/step2_mirul")
public class step2_mirul extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost:3306/HumberEvents";
			String username = "root";
			String dbp = "root";
			
			Connection con = DriverManager.getConnection(dbURL, username, dbp);
		
			String fname = request.getParameter("name");
			String lname = request.getParameter("lname");
			String bdate = request.getParameter("bdate");
			String status = request.getParameter("st");
			String email = request.getParameter("mail");

					
			PreparedStatement ps = con.prepareStatement("insert into member values(?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, bdate);
			ps.setString(4, status);
			ps.setString(5, email);

			
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
			catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
			}	

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		
		String fname = request.getParameter("name");
		String lname = request.getParameter("lname");
		String bdate = request.getParameter("bdate");
		String status = request.getParameter("st");
		String email = request.getParameter("mail");

			out.println("<html>");
			out.println("<link rel=\"stylesheet\" href=\"output.css\">");
			out.println("<head>");
			out.println("<body>");
			out.println("<div id=container>");
			out.println("<h3>Thank you, "+fname+" "+ lname + " for registering in this event. we will contact you via " +email+ " Your DOB is " +bdate+ ", "
					+ "and your status is "+status+"<h3>");
			out.println("</div>");
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

};
