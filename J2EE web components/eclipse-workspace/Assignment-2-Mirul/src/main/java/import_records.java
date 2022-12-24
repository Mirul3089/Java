

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/import_records")
public class import_records extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost:3306/as2_mirul";
			String username = "root";
			String dbp = "root";
			
			Connection con = DriverManager.getConnection(dbURL, username, dbp);
			
			String[] number={"N0100","N0101","N0102","N0103","N0104","N0105","N0106","N0107","N0108","N0109"};
			String[] name={"Mirul","Rishi","Rahul","Mirul","Rishi","Rahul","Mirul","Rishi","Rahul","param"};
			String[] department={"IT","Financial","Sale","IT","Financial","Sale","IT","Financial","Sale","Sale"};
			String[] job={"Programmer","Tester","ProjectManger","Engineer","Programmer","Tester","ProjectManger","Engineer","Programmer","Tester"};
		
			int i =0;
			
			while(i<10) {
				
				PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?)");
				ps.setString(1, number[i]);
				ps.setString(2, name[i]);
				ps.setString(3, department[i]);
				ps.setString(4, job[i]);
				
				ps.executeUpdate();
				
				i++;
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
