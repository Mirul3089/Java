

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletdb")
public class servletdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servletdb() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() {
		// String dbDriver = "com.mysql.jdbc.Driver";
		

		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			String dbpassword = request.getParameter("dpwd");

			Class.forName("com.mysql.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost:3306/oct5_mirul";
			String username = "root";
			
			Connection con = DriverManager.getConnection(dbURL, username, dbpassword);
			
			String uname = request.getParameter("uname");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("mail");
			
			//PreparedStatement ps = con.prepareStatement("insert into login values(?,?,?)");
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from login");
			
			while(rs.next())
			{
				System.out.println("username: "+rs.getString("username"));
			}
			
		/*	ps.setString(1, uname);
			ps.setString(2, pwd);
			ps.setString(3, email);
			
			ps.executeUpdate();*/
			
			PrintWriter out = response.getWriter();
	
			/*try {
				Thread.sleep(5000);
				out.println("Data inserted succesfully");
			}
			catch(Exception e){
				
			}*/
			
			
			//response.sendRedirect("http://localhost:8080/Assignment-Mirul/user-reg.html");
			//RequestDispatcher rd = request.getRequestDispatcher("http://localhost:8080/Assignment-Mirul/user-reg.html"); 
			//rd.forward(request,response);
			
			
		}
		catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
