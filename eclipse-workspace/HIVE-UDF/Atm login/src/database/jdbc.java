/*************************************************************************************************
*  I declare that this code is my own work in accordance with Humber Academic Policy.        *

*  No part of this code has been copied manually or electronically from any other source       *

*  (including web sites) or distributed to other students/social media.                                                       *
                                                                                                                                                                             
*  Name: ______________Mirul Patel________ Student ID: __N01489347________________ 	*/

package database;
import java.util.*;
import java.sql.*;
import main.gui;

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
