/*************************************************************************************************
*  Course_Name – Assignment 4                                                                                                                               *

*  I declare that this assignment is my own work in accordance with Humber Academic Policy.        *

*  No part of this assignment has been copied manually or electronically from any other source       *

*  (including web sites) or distributed to other students/social media.                                                       *
                                                                                                                                                                             
*  Name: ______________Mirul Patel________ Student ID: __N01489347________________ Date: ___16/03/2022_________________  	*/

package main;
import java.awt.*;
import db.jdbc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;


public class mymain
{
  
	
public static void main(String[]args) throws ClassNotFoundException, SQLException 
{
		
		 JFrame jf = new JFrame();
			jf.setSize(490,230);
			jf.setVisible(true);                                   //frame creation and visibility enable and many more
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setResizable(false);

	 JPanel p2; //panels
	 JPanel mp;
	 JPanel p1 ;  
	
	 JLabel l1= new JLabel("ID");
	 JLabel l2= new JLabel("Last Name");  //labels
	 JLabel l3= new JLabel("First Name");
	 JLabel l4= new JLabel("Sex");
	 JLabel l5= new JLabel("Address");
	 JLabel l6= new JLabel("City");
	 JLabel l7= new JLabel("State");
	 JLabel l8= new JLabel("Telephone");
	 
	 JTextField tf1= new JTextField(10);
	 JTextField tf2= new JTextField(10);
	 JTextField tf3= new JTextField(10);
	 JTextField tf4= new JTextField(3);  //textfields
	 JTextField tf5= new JTextField(12);
	 JTextField tf6= new JTextField(12);
	 JTextField tf7= new JTextField(3);
	 JTextField tf8= new JTextField(12);
	 
	 tf1.setBackground(Color.yellow);
	 
	 JTextArea ta=new JTextArea("Database Connected");  
	 ta.setBackground(null);
	 
	 JButton jb1;
	 JButton jb2; //buttons
	 JButton jb3;
	 JButton jb4;
	 
	 
	 
	    jb1=new JButton("View");
	    jb1.addActionListener(new ActionListener() {           //event action listener for view button
			public void actionPerformed(ActionEvent e) {
			 
			try {
						
						Connection con=null;
						ResultSet rs = null;
						PreparedStatement st = null;    //accessing the connection
						con=jdbc.dbo(); 
						
						st =con.prepareStatement("select * from Staff where ID = ?"); //select query
						
						st.setInt(1, Integer.parseInt(tf1.getText().trim().toString())); //setting the id by taking data from textfield and also converted string into int
						
						rs = st.executeQuery();  //query execution
						//JOptionPane.showMessageDialog(null,"You can view data in respective textfields");
						
						while(rs.next()){         // resultset for setting result in textfield

						String id1=rs.getString("id");
						tf1.setText(id1);
						
						String ln1=rs.getString("lastName");
						tf2.setText(ln1);	
						
						String fn1=rs.getString("firstName");
						tf3.setText(fn1);
		                
		                String mi1=rs.getString("mi");
						tf4.setText(mi1);
						
						String ad1=rs.getString("address");
						tf5.setText(ad1);
						
						String c1=rs.getString("city");
						tf6.setText(c1);
						
						String s1=rs.getString("state");
						tf7.setText(s1);
						
						String t1=rs.getString("telephone");
						tf8.setText(t1);
						JOptionPane.showMessageDialog(null,"You can view data in respective textfields");
						
						//con.close();
						
					}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}  
			}
		});
	    
		jb2=new JButton("Insert");
		jb2.addActionListener(new ActionListener() {           //event action listener for insert button
			public void actionPerformed(ActionEvent e)  {
				try {	
					
					 String id= tf1.getText();
					 String ln=tf2.getText();
					 String fn= tf3.getText();
					 String sex=tf4.getText();
					 String add= tf5.getText();
					 String ci= tf6.getText();
					 String st= tf7.getText();
					 String no=tf8.getText();
					
					 long totalCharacters = id.chars().count();  //counted characters of id
					 long tc = sex.chars().count();   
					 long sc = st.chars().count();   //counted characters of sex
					 
					if(id == null  || totalCharacters > 9 || sex == null || tc>1 || sc>2)  //data validation
					{
						JOptionPane.showMessageDialog(null,"Please Enter your valid data");
					}
					else {
						
						Connection con=null;
						con=jdbc.dbo();
						//insert query statement
						PreparedStatement stmt =con.prepareStatement("insert into Staff(ID,LASTNAME,FIRSTNAME,MI,ADDRESS,CITY,STATE,TELEPHONE) values(?,?,?,?,?,?,?,?)");
						
						stmt.setString(1,id);
						stmt.setString(2,ln);  //setting string for prepared statement
						stmt.setString(3,fn);
						stmt.setString(4,sex);  
						stmt.setString(5,add);  
						stmt.setString(6,ci);  
						stmt.setString(7,st);  
						stmt.setString(8,no);  
						
						stmt.executeUpdate(); //queryexecution
						con.close();
						
						JOptionPane.showMessageDialog(null,"Data successfully inserted");
					}
					
				}
		   catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		jb3=new JButton("Update");
		jb3.addActionListener(new ActionListener() {           //event action listener for insert button
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String id1= tf1.getText();
					 String ln11=tf2.getText();
					 String fn22= tf3.getText();
					 String sex33=tf4.getText();  //intializing value in various datatypes
					 String add44= tf5.getText();
					 String ci55= tf6.getText();
					 String st66= tf7.getText();
					 String no77=tf8.getText();
					
					Connection con=null;
					con=jdbc.dbo(); 
					//update query statement
					PreparedStatement stmt =con.prepareStatement("UPDATE Staff SET LASTNAME= ?,FIRSTNAME=?,MI=?,ADDRESS=?,CITY=?,STATE=?,TELEPHONE=? where ID = ?");
				
					stmt.setString(1,ln11);
					stmt.setString(2,fn22);
					stmt.setString(3,sex33);
					stmt.setString(4,add44);
					stmt.setString(5,ci55); //setting string for prepared statement
					stmt.setString(6,st66);
					stmt.setString(7,no77);
					stmt.setString(8,id1);
					
					stmt.executeUpdate(); //queryexecution
					 
					con.close();
					
					
					JOptionPane.showMessageDialog(null,"Data successfully updated");
					
					
				}
				 catch (SQLException e1) {
					
					e1.printStackTrace();
				}  
				
			}
		});
		
		jb4=new JButton("Clear");
		jb4.addActionListener(new ActionListener() {           //event action listener for clear button
			public void actionPerformed(ActionEvent e) {
				tf1.setText(null);
				tf2.setText(null);
				tf3.setText(null); //simply setting the textfileds into null
				tf4.setText(null);
				tf5.setText(null);
				tf6.setText(null);
				tf7.setText(null);
				tf8.setText(null);
			}
		});

	p1= new JPanel();
	p2= new JPanel();

	mp= new JPanel();
	
	mp.setLayout(new BorderLayout());
	mp.add(p1,BorderLayout.BEFORE_LINE_BEGINS); //layout for mainpanel
	mp.add(p2,BorderLayout.AFTER_LAST_LINE);
	
	jf.add(mp);
    
	 p1.add(l1);
	 p1.add(tf1); 
	 p1.add(l2);
	 p1.add(tf2);
	 p1.add(l3);
	 p1.add(tf3);
	 p1.add(l4); //adding components in panel
	 p1.add(tf4);
	 p1.add(l5);
	 p1.add(tf5);
	 p1.add(l6);
	 p1.add(tf6);
	 p1.add(l7);
	 p1.add(tf7);
	 p1.add(l8);
	 p1.add(tf8);
	 
	    p2.add(jb1);
		p2.add(jb2);//adding components in panel
		p2.add(jb3);
		p2.add(jb4);
		
	    p2.add(ta);
	 
	    GridLayout layout = new GridLayout(5,2);
	      layout.setHgap(5);  
	      layout.setVgap(3);//seting layout for panel
	    p1.setLayout(layout);
		p1.setBorder(new TitledBorder(new EtchedBorder(), "Staff Information"));
	}
}