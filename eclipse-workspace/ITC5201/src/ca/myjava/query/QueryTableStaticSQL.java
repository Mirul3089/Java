package ca.myjava.query;

import java.sql.*;

import java.util.*;

public class QueryTableStaticSQL 
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Orcale Driver
			
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","n01489347","oracle");
			//created a connection for database
			
			Statement stmt=con.createStatement();
			//created statement for hard/Static select query and set the range in query 
			
			ResultSet rs=stmt.executeQuery("SELECT * FROM Countries WHERE LifeExpectancy BETWEEN 50 AND 100");
			//result set for executing query and storing the result
			
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
