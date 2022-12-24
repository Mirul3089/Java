package chat_application_with_UI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class client implements ActionListener{
	DataInputStream ip;
	DataOutputStream op; 
	 JButton jb;
	 JTextArea ta;
	 JTextField tf;
	 Socket socket;

	 client()
	{
		 JFrame jf=new JFrame("Client Window:");
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
				socket =new Socket("localhost",8000);
				
				ip = new DataInputStream(socket.getInputStream());
				op = new DataOutputStream(socket.getOutputStream());
				
				String st=ip.readUTF();
				
				ta.append("\n Server: "+st);
				
				String cm=tf.getText();
				
				op.writeUTF(cm);
				
				ta.append("\n Client: "+cm);
				tf.setText(null);
			
				 //socket.close();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
	public static void main(String[]args)
	{
		new client();
	}
}

