package chat_application_with_UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

class server implements ActionListener{
	DataInputStream ip;
	DataOutputStream op; 
	 JButton jb;
	 JTextArea ta;
	 JTextField tf;
	 ServerSocket ss;
	 Socket socket;
	 

	 server()
	{
		JFrame jf=new JFrame("Server Window:");
		tf=new JTextField(20);
		jb=new JButton("send");
		ta=new JTextArea(1,25);
		jf.setLayout(new FlowLayout());
		jb.addActionListener(this);
		
		jf.add(tf);
		jf.add(jb);
		jf.add(ta);
		jf.setVisible(true);
		jf.setSize(300,300);
		ta.setLineWrap(true);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		try {
		ss = new ServerSocket(8000);
		socket =ss.accept();
		ip = new DataInputStream(socket.getInputStream());
		op = new DataOutputStream(socket.getOutputStream());
		
		String sm=tf.getText(); 
				op.writeUTF(sm);
		
		ta.append("\n Server: "+sm);
	
		tf.setText("");
		 //socket.close();
		
		String mb= ip.readUTF();
		
		ta.append("\n client: "+mb);
		
		
		}
		catch(Exception e1)
		{
			
		}
	}
	
		
		 
	public static void main(String[]args)
	{
		new server();
	}
}
