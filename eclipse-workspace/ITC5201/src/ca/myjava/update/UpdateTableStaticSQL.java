package ca.myjava.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTableStaticSQL {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); //oracle driver
			
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","n01489347","oracle");
			//created a connection for database
			
			Statement stmt=con.createStatement(); 
			//created statement for hard/Static select query and set the range in query 
			
			ResultSet rs=stmt.executeQuery("DELETE FROM COUNTRIES WHERE Region_ID=215");
			//result set for executing query and storing the result
			
			System.out.println("Data Deleted");
			
			System.out.println("------------------------------------------------------------------------------------");
			
			System.out.println("Press 0 to recover your deleted data or 1 to exit");
			Scanner s2 =new Scanner(System.in);//Scanner class
			int c=s2.nextInt();
			
			while(c<2) {//while loop 
			if(c==0)// if condition for 0 it will rollback means simple recovering the deleted data
			{
			con.setAutoCommit(false);//set auto commit off
			con.rollback();//rollback connection or query
			System.out.println("Data Recovered");
			}
			else if(c==1)
			{
				System.out.println("Thank you for using JDBC");
				break;
			}	
			System.out.println("Press 0 to recover your deleted data or 1 to exit");
			c=s2.nextInt();
			
			}
		}
		catch(Exception e){//if any Exception then it will be handled in catch
			e.printStackTrace();
	
		}
}

}
