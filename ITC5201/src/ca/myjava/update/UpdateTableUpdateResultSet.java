package ca.myjava.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTableUpdateResultSet 
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		try {
			
			//Scanner s1 =new Scanner(System.in);
			//System.out.println("Enter a REGION_ID where you want to UPDATE in Countries table: ");
			
			//System.out.println("REGION_ID:");
			//int re=s1.nextInt();
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); //oracle driver
			
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","n01489347","oracle");
			//created a connection for database
			
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE ); 
			//to make resultset updatable
			
			ResultSet rs=stmt.executeQuery("SELECT COUNTRY_ID,COUNTRY_NAME,REGION_ID,LIFEEXPECTANCY FROM Countries");
			////created statement for hard/Static select query and set the range in query & result set for executing query and storing the result
			
			while (rs.next())//printed the result
			{
				System.out.println("COUNTRY_ID: " +rs.getString(1)+ "| COUNTRY_NAME: "+ rs.getString(2)+ "| REGION_ID: "+ rs.getString(3)+ "| LIFEEXPECTANCY: " +rs.getString(4));   
			}

			System.out.println("Data Displayed");
			
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("------------------------------------------------------------------------------------");
			
			rs.absolute(43);//setting the position of row for update
			rs.updateString("COUNTRY_ID", "lh");//updated string
			rs.updateString("COUNTRY_NAME", "agel");//updated string
			rs.updateInt("REGION_ID", 450);//updated int data
			rs.updateInt("LIFEEXPECTANCY", 900);//updated int data
			rs.updateRow();//row updated
			
			System.out.println("Updated data");
			
			rs.beforeFirst();//to go at start
			while (rs.next())//printed the updatedresult
			{
				System.out.println("COUNTRY_ID: " +rs.getString(1)+ "| COUNTRY_NAME: "+ rs.getString(2)+ "| REGION_ID: "+ rs.getString(3)+ "| LIFEEXPECTANCY: " +rs.getString(4));   
			}
	
		}
		catch(Exception e){//if any Exception then it will be handled in catch
			e.printStackTrace();
	
		}
}
}
