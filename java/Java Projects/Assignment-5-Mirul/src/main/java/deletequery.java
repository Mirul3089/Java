import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
;

public class deletequery {
	public void deletefriend()
	{
		
	try {
	Class.forName("com.mysql.jdbc.Driver");
	
	String dbURL = "jdbc:mysql://localhost:3306/w11_mirul";
	String username = "root";
	String dbp = "root";
	
	Connection con = DriverManager.getConnection(dbURL, username, dbp);
	
	Statement stmt = con.createStatement();
	
	ResultSet rs = stmt.executeQuery("select id from friend");
	 
	int id=0;

			while (rs.next()) 
			{
		       id=rs.getInt("id");
		    }
	
	PreparedStatement ps = con.prepareStatement("DELETE from friend where id = ?");
	
	ps.setInt(1,id);
	
    ps.executeUpdate();
	
}
	catch (ClassNotFoundException | SQLException e) {
		System.out.println(e);
	}
	}
}
