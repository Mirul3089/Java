/*************************************************************************************************
*  I declare that this code is my own work in accordance with Humber Academic Policy.        *

*  No part of this code has been copied manually or electronically from any other source       *

*  (including web sites) or distributed to other students/social media.                                                       *
                                                                                                                                                                             
*  Name: ______________Mirul Patel________ Student ID: __N01489347________________ 	*/

package main;
import java.awt.*;
import database.jdbc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;


public class gui
{
  
	
public static void main(String[]args) throws ClassNotFoundException, SQLException 
{
		
		 JFrame jf = new JFrame("ATM MACHINE");
			

	
	 JLabel lt= new JLabel("Welcome to the ATM");//labels
	 lt.setForeground(Color.red);
	 
	 JLabel l1= new JLabel("Card Number");
	
     
	 JLabel l2= new JLabel("Pin number"); 
	 
	 
	 
	 JTextField tf1= new JTextField(10);//textfileds
	 
     
	 JTextField tf2= new JTextField(10);
	
	 
	 
	 
	 JButton jb1;
	 JButton jb2; //buttons
	 
	 
	 
	    jb1=new JButton("Login");
	    
	    jb1.addActionListener(new ActionListener() {           //event action listener for view button
			public void actionPerformed(ActionEvent e) {
			 
			try {
						
						Connection con=null;
						ResultSet rs = null;
						PreparedStatement st = null;    //accessing the connection
						con=jdbc.dbo(); 
						
						String cnumber=tf1.getText();
						String pnumber=tf2.getText();
						
						st =con.prepareStatement("select NAME from ATMDATA where CARDNUMBER= ? AND PINNUMBER = ?"); //select query
						
						st.setString(1,cnumber);
						st.setString(2,pnumber);
						
						
						rs = st.executeQuery();  //query execution

						
						while(rs.next()){ 
							// resultset for setting result in textfield
							String val1 = rs.getString("NAME");
					        
						JOptionPane.showMessageDialog(null, ""+val1+ " is Login successfully");
						
						//con.close();
						
					}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}  
			}
		});
	    
		
		jb2=new JButton("Clear");
		jb2.addActionListener(new ActionListener() {           //event action listener for clear button
			public void actionPerformed(ActionEvent e) {
				tf1.setText(null);
				tf2.setText(null);
			}
		});
		
		//JPanel mp= new JPanel();
		
		//jf.add(mp);
		
		jf.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 30));
		
		jf.add(lt);
		jf.add(l1);
		jf.add(tf1);
		jf.add(l2);
		jf.add(tf2);
		jf.add(jb1);
		jf.add(jb2);
		
		jf.setSize(300,300);
		jf.setVisible(true);                                   //frame creation and visibility enable and many more
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		/*mp.setLayout();
		
		*/
		
		
	}
}