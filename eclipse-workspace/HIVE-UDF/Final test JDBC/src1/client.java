/*************************************************************************************************                                                                                                                         *

*  I declare that this code is my own work in accordance with Humber Academic Policy.        *

*  No part of this code has been copied manually or electronically from any other source       *

*  (including web sites) or distributed to other students/social media.                                                       *
                                                                                                                                                                             
*  Name: ______________Mirul Patel________ Student ID: __N01489347________________ */

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;
public class client {
	
	public client() {
		
		try {		//try and catch for exception handling
			
			Socket socket = new Socket("localhost", 8000); //socket creation

			// Data input and output streams for reading and writing data
			DataInputStream ip = new DataInputStream(socket.getInputStream());
			DataOutputStream op = new DataOutputStream(socket.getOutputStream());
	
			try {
				
				Scanner s1=new Scanner(System.in);//scanner for user input
				
				System.out.println("*****Client side**********");
					
				System.out.println("Enter annual rate:");
				double ar=s1.nextDouble();
				System.out.println("Enter number of days:");
				double nd=s1.nextDouble();
				System.out.println("Enter loan amount:");
				double la=s1.nextDouble();
				
				op.writeDouble(ar); //writing user input to server or on server
				op.writeDouble(nd);
				op.writeDouble(la);
				
				double tp = ip.readDouble();//reading answers of calculation
				double mp = ip.readDouble();//reading answers of calculation
				
				
				System.out.println("*****Response From Server side**********");
				
				System.out.println("Your total payment :" +tp);
				System.out.println("Your monthly payment :" +mp);
				
				
			
			}
			catch (Exception e) {//try and catch for exception handling
				System.err.println(e);
			}
		}
			catch (Exception e) {//try and catch for exception handling
				System.err.println(e);
			}
		}
	
	public static void main(String[] args) {
		new client(); //calling the client
	}
	
}