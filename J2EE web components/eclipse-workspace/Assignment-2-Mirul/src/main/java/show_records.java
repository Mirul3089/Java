

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class show_records
 */
@WebServlet("/show_records")
public class show_records extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost:3306/as2_mirul";
			String username = "root";
			String dbp = "root";
			
			Connection con = DriverManager.getConnection(dbURL, username, dbp);
			
		
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from emp");
			
			while(rs.next()) 
			{
				PrintWriter out = response.getWriter();
				
				out.println("<html>");
				out.println("<link rel=\"stylesheet\" href=\"outout.css\">");
				out.println("<head>");
				out.println("<body>");
				out.println(
				        "<title>Select Query</title>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<div id=\"container\">"
						+ "			<h2>Employee Details</h2>\r\n"
						+ "			<br>\r\n"
						+ "			<t1>Employee Number: " +rs.getString("EmpNo")+"</t1><br><br>\r\n"
						+ "			<t1>Employee Name: " +rs.getString("EmpName")+ "</t1><br><br>\r\n"
						+ "			<t1>Department: " +rs.getString("Department")+ "</t1><br><br>\r\n"
						+ "			<t1>Employee Job: " +rs.getString("EmpJob")+ "</t1><br><br>\r\n"
						);
				out.println("</div>");
				out.println("</body>");
				out.println("</head>");
				out.println("</html>");

			}
				
		}
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
