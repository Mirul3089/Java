package ca.myjava.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

import static javax.swing.JOptionPane.showMessageDialog;

public class UpdateTablePreparedStm {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		try {
			
			Scanner s1 =new Scanner(System.in);//created scanner for user input
			System.out.println("Enter data that you want to insert in Countries table: ");
			System.out.println("COUNTRY_ID:");
			String id=s1.nextLine();//Store the input in id variable
			System.out.println("COUNTRY_NAME");
			String na=s1.nextLine();//Store the input in na variable
			System.out.println("REGION_ID");
			int re=s1.nextInt();//Store the input in re variable
			System.out.println("LIFEEXPECTANCY");
			int le=s1.nextInt();//Store the input in le variable
			
			//long tc = id.chars().count();
			
			//if(tc<2) 
			//{
				//System.out.println("Enter valid data");
			//}
			//else {
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); //Orcale Driver
			
			Connection con= DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok","n01489347","oracle");
			//created a connection for database
			
			PreparedStatement stmt= con.prepareStatement("INSERT INTO COUNTRIES(COUNTRY_ID,COUNTRY_NAME,REGION_ID,LIFEEXPECTANCY) VALUES(?,?,?,?)"); 
			//created prepared statement for select query and set the range through set int with user's input
			
			stmt.setString(1,id);   //setting the value for insert
			stmt.setString(2,na);  
			stmt.setInt(3,re);     
			stmt.setInt(4,le);  
			
			stmt.executeUpdate();//executing update
			//con.close();
			
			System.out.println("Your Data inserted");
			
			System.out.println("------------------------------------------------------------------------------------");
			
			
			Scanner s2 =new Scanner(System.in);//Scanner class
			
			System.out.println("Press 0 to view inserted data or 1 to exit");
			int c=s1.nextInt();
			
			
			while(c<2) {//while loop
			switch (c) { //switch case if user choose 0 it will displays the data
			  case 0:
				  
				  Statement stm=con.createStatement(); 
					
					ResultSet rs=stm.executeQuery("SELECT * FROM Countries");
					
					while (rs.next())//resultset
					{
						System.out.println("COUNTRY_ID: " +rs.getString(1)+ "| COUNTRY_NAME: "+ rs.getString(2)+ "| REGION_ID: "+ rs.getString(3)+ "| LIFEEXPECTANCY: " +rs.getString(4));   
					}
			    break;
			  case 1://switch case if user choose 1 code will exit
			    exit(); 
			    break;
			}
			if(c<1) 
			{
			System.out.println("Press 0 to view inserted data or 1 to exit");
			c=s1.nextInt();
			}
			else
			{
				break;
			}
			}
			
		}
	
		catch(Exception e){//if any Exception then it will be handled in catch
			e.printStackTrace();

		}
}

	private static void exit() {
		System.out.println("Thank you for using JDBC");
	}
}
