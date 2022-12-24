package db;
import java.util.*;
import main.mymain;
import java.sql.*;

public class jdbc {
	  Connection con=null;
	  java.sql.PreparedStatement ps;

	public static Connection dbo() 
	{
		//created connection with oracle driver and have given the path for oracle server provided by humber
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","n01489347","oracle");
			
			return con;
			
			
		}
		catch(Exception e){
			e.printStackTrace();  //catch block for error handling
			return null;
		}
	

	}

}
