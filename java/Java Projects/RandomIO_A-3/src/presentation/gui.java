package presentation;

import Business.person;
import data.randomIO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.*;

public class gui  {

	public static void main(String[] args) {
	
		MainOp o1 = new MainOp();
	}

}


class MainOp extends JFrame  
{
	
	private JPanel p1,p2;
	
	private JLabel l1; // GUI components
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	
	
	
	private JButton jb1;
	private JButton jb2;
	
	public MainOp() {
		
		
		l1=new JLabel("Record #:-");
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		
		l2=new JLabel("First Name:-");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		
		l3=new JLabel("Phone:-");
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		
		l4=new JLabel("Last Name:-");
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		
		l5=new JLabel("Age:-");
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		
		jb1 = new JButton("Add");
		jb1.addActionListener(new ActionListener() {           //action listener
			public void actionPerformed(ActionEvent e) {
				
				try {
					int recordnumber = Integer.parseInt(tf1.getText());      //user input validation 
					
					String firstname = tf4.getText();
					
					if(firstname.length() <= 20)   
					{
						JOptionPane.showMessageDialog(null, "Record Added Successfully");
					}
					else {
						JOptionPane.showMessageDialog(null, "Maxium input level reached");
					}
					
					String lastname = tf2.getText();
					
					
					if (lastname.length()<=25)
					{
						JOptionPane.showMessageDialog(null, "Record Added Successfully");
					}
					else {
						JOptionPane.showMessageDialog(null, "Maxium input level reached");
					}
					
					
					int age = Integer.parseInt(tf3.getText());
					
					String phone = tf5.getText();
					
					if (phone.length()<=10)
					{
						JOptionPane.showMessageDialog(null, "Record Added Successfully");
					}
					else {
						JOptionPane.showMessageDialog(null, "Maxium input level reached");
					}
					
					
					
					randomIO data = new randomIO(); //created object for random io class
					
					data.open("temporary.data");
					
					person p = new person(recordnumber,firstname,lastname,phone,age); //created object for person class
						
					int pos = data.size();
					
					data.write(pos, p); //binary write
					
							
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
					tf5.setText("");
				
					
				}
				catch(NumberFormatException n) {
					System.out.println("number format exception");
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		jb2 = new JButton("Find");
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					
				int recordNumber = Integer.parseInt(tf1.getText()); //parsing
				
				randomIO data = new randomIO();
				
				data.open("temporary.data");
				
				int position = data.find(Math.abs(recordNumber));
				
				
					person p = data.read(position);
					
					
					tf4.setText(p.getFirstName());
			        tf2.setText(p.getLastName());    //setting results in textfields
					tf3.setText(String.valueOf(p.getAge()));
					tf5.setText(p.getPhone());	
					 
				}
				catch(NumberFormatException n) {
					System.out.println("number format exception");
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 2, 5, 10));  //panels
		
		p2 = new JPanel();
		p2.setBorder(null);

		p1.add(l1);
		p1.add(tf1);
		p1.add(l2);
		p1.add(tf4); //adding components in panel
		p1.add(l4);
		p1.add(tf2);
		p1.add(l5);
		p1.add(tf3);
		p1.add(l3);
		p1.add(tf5);
		
		
		p2.add(jb1);
		p2.add(jb2);
		
		
		add(p1);
		add(p2, BorderLayout.PAGE_END);
		
		setResizable(false);
		setSize(500,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Random File Processing");
		setVisible(true);
		
	}
	
	
	

	
	
}