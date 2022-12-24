/*************************************************************************************************                                                                                                                         *

*  I declare that this code is my own work in accordance with Humber Academic Policy.        *

*  No part of this code has been copied manually or electronically from any other source       *

*  (including web sites) or distributed to other students/social media.                                                       *
                                                                                                                                                                             
*  Name: ______________Mirul Patel________ Student ID: __N01489347________________ */
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class server  {

	private int port = 8000; // port number

	public server() {
try {//try and catch for exception handling
		ServerSocket ss = new ServerSocket(port); // created a server socket
			
			// will accept the connection request from client
		Socket socket = ss.accept(); 

			// Data input and output streams for reading and writing data
			DataInputStream in = new DataInputStream(socket.getInputStream()); 
			DataOutputStream op = new DataOutputStream(socket.getOutputStream());


			while (true) { 
				try {//try and catch for exception handling
					
					
					double air = in.readDouble();//reading annual rates from client
					double ny = in.readDouble();// reading number of years from client
					double la = in.readDouble(); //reading loan amount from client
								
					double tp=air*ny*la; //calculation of monthly payments and annual payments
					double mp=tp/12;		
					
					

					op.writeDouble(tp);//writing the answers to client
					op.writeDouble(mp);
			
				} catch (Exception e) //try and catch for exception handling
				{ 
					System.err.println(e);
				}
								
			}
}
			 catch(IOException e) {//try and catch for exception handling
					System.err.println(e);
				}
	}
	
	public static void main(String[] args) {
		new server(); //calling the server
	}
	
}