
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serve
 */
@WebServlet("/serve")
public class serve extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		// String dbDriver = "com.mysql.jdbc.Driver";
		

		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost:3306/oct5_mirul";
			String username = "root";
			String password = "root";
			
			System.out.println("successfully");
			Connection con = DriverManager.getConnection(dbURL, username, password);
			
			
		} 
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

	}

}
