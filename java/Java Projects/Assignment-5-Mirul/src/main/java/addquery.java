import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class addquery {
	public void addfriend(M_47_friends mf)
	{
	try {
		
		String fname=mf.getFname();
		String email=mf.getEmail();
		int age= mf.getAge();
		String fcolor=mf.getFcolor();
		
	Class.forName("com.mysql.jdbc.Driver");
	
	String dbURL = "jdbc:mysql://localhost:3306/w11_mirul";
	String username = "root";
	String dbp = "root";
	
	Connection con = DriverManager.getConnection(dbURL, username, dbp);
	
	PreparedStatement ps = con.prepareStatement("insert into friend(fname,email,age,color) values(?,?,?,?)");
	
	ps.setString(1,fname);
	ps.setString(2,email);
	ps.setInt(3,age);
	ps.setString(4,fcolor);
	
	ps.executeUpdate();
	
	
}
	catch (ClassNotFoundException | SQLException e) {
		System.out.println(e);
	}
	}
}
