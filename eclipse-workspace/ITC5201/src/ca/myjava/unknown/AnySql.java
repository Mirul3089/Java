package ca.myjava.unknown;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AnySql {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		try {
			
			Scanner s1 =new Scanner(System.in); //created scanner for user input
			System.out.println("Enter a lifeExpectancy range");
			System.out.println("From:");
			int f=s1.nextInt();//Store the input in f variable
			System.out.println("To:");
			int t=s1.nextInt();//Store the input in t variable
			
			System.out.println("Information for lifeExpectancy from " +f+ " to " +t);
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Orcale Driver
			
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","n01489347","oracle");
			//created a connection for database
			
			PreparedStatement stmt= con.prepareStatement("SELECT * FROM Countries WHERE LifeExpectancy BETWEEN ? AND ?"); 
			//created prepared statement for select query and set the range through set int with user's input

			stmt.setInt(1,f);     
			stmt.setInt(2,t);  
			
			ResultSet rs=stmt.executeQuery();//result set for executing query and storing the result
			 
			
			while (rs.next())
			{//printed the result
			System.out.println("COUNTRY_ID: " +rs.getString(1)+ "| COUNTRY_NAME: "+ rs.getString(2)+ "| REGION_ID: "+ rs.getString(3)+ "| LIFEEXPECTANCY: " +rs.getString(4));  
			}
		}
		catch(Exception e){//if any Exception then it will be handled in catch
			e.printStackTrace();

		}
}

}
