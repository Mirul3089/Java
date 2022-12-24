import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class employeeDAO {
	
	public int registerEmployee(employeeModel emp)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost:3306/as2_mirul";
			String username = "root";
			String dbp = "root";
			
			Connection con = DriverManager.getConnection(dbURL, username, dbp);
		
			//PrintWriter outt = response.getWriter();
			
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?)");
			ps.setString(1, emp.getFname());
			ps.setString(2, emp.getLname());
			ps.setString(3, emp.getUname());
			ps.setString(4, emp.getPassword());
			ps.setString(5, emp.getAddress());
			ps.setString(6, emp.getContact());
			
			int x=ps.executeUpdate();
			
			
			
		}
			catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
			}
		return 0;	
	}

}
