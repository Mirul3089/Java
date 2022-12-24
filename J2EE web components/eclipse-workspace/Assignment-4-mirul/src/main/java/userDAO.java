import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class userDAO {
	public boolean userlogin(userModel um)
	{
		try {
			
			String un = um.getUsername();
			String pw = um.getPassword();
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost:3306/w11_mirul";
			String username = "root";
			String dbp = "root";
			
			Connection con = DriverManager.getConnection(dbURL, username, dbp);
		
			//PrintWriter outt = response.getWriter();
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM user");
			
			String dbuname = null;
			String dbpwd = null;
			
			while(rs.next()) 
			{
			dbuname=rs.getString("username");
			dbpwd=rs.getString("password");
			}
			
			
			
			if(dbuname.equals(un) & dbpwd.equals(pw) )
			{
				return true;
			}
			
			
		}
			catch (ClassNotFoundException | SQLException e) {
				System.out.println(e);
			}
		return false;
	}

}


	
	

