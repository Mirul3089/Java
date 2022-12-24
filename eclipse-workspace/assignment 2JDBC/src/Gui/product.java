
package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;

import logic.*;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class product extends JFrame {
	private JTextField tf;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	
	public product() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add/Update Product");
		getContentPane().setLayout(null);
		
		//GUI Components
		 
		JLabel l1 = new JLabel("Product ID:");
		l1.setBounds(23, 22, 77, 14);
		getContentPane().add(l1);
		
		JLabel l2 = new JLabel("Name:");
		l2.setBounds(22, 66, 46, 14);
		getContentPane().add(l2);
		
		JLabel l3 = new JLabel("Description:");
		l3.setBounds(23, 112, 77, 14);
		getContentPane().add(l3);
		
		JLabel l4 = new JLabel("Quantity in hand:");
		l4.setBounds(303, 112, 98, 14);
		getContentPane().add(l4);
		
		JLabel l5 = new JLabel("Unit Price:");
		l5.setBounds(324, 166, 77, 14);
		getContentPane().add(l5);
		
		tf = new JTextField();
		tf.setBounds(95, 20, 86, 20);
		getContentPane().add(tf);
		tf.setColumns(10);
		
		tf1 = new JTextField();
		tf1.setBounds(95, 64, 86, 20);
		getContentPane().add(tf1);
		tf1.setColumns(10);
		
		JTextArea ta = new JTextArea();
		ta.setRows(5);
		ta.setColumns(6);
		ta.setBounds(95, 108, 198, 85);
		getContentPane().add(ta);
		
		JButton Add = new JButton("Add");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //productid validation
				try {
				if(validate.isPresent(tf, "Product ID") && validate.isPresent(tf1, "Name") && validate.isNumber(tf2, "Quantity") && validate.isNumber(tf3, "Unit Price") && random.checkpID(tf)) {
					String id = tf.getText();
					String name = tf1.getText();
					String desc = ta.getText();
					int quantity = Integer.parseInt(tf2.getText());
					int price = Integer.parseInt(tf3.getText());
					try {
						random.addInformation(id, name, desc, quantity, price);
						JOptionPane.showMessageDialog(null, "Information is saved to file.","Save Information",JOptionPane.INFORMATION_MESSAGE);
					}
					catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error saving to file ->" + e1.getMessage(),"Save Information",JOptionPane.ERROR_MESSAGE);
					}
				}
	
				}catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "Duplicate ID is not allowed." + e2.getMessage(),"Duplicate Data",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		Add.setBounds(33, 216, 89, 23);
		getContentPane().add(Add);
		
		JButton Update = new JButton("Update");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(validate.isPresent(tf, "Product ID") && validate.isPresent(tf1, "Name") && validate.isNumber(tf2, "Quantity") && validate.isNumber(tf3, "Unit Price") && !(random.checkpID(tf))) {
						String id = tf.getText();
						String name = tf1.getText();
						String desc = ta.getText();
						int quantity = Integer.parseInt(tf2.getText());
						int price = Integer.parseInt(tf3.getText());
						try {
							random.updateInformation(id, name, desc, quantity, price);
							JOptionPane.showMessageDialog(null, "Information is saved to file.","Save Information",JOptionPane.INFORMATION_MESSAGE);
						}
						catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "Error saving to file ->" + e1.getMessage(),"Save Information",JOptionPane.ERROR_MESSAGE);
						}
					}
					
					}catch (IOException e2) {
						JOptionPane.showMessageDialog(null, "No matching ID found." + e2.getMessage(),"Cannot Update",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
	   
		Update.setBounds(156, 216, 89, 23);
		getContentPane().add(Update);
		
		JButton first = new JButton("First");
		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					info info = random.readInformation(1);
					if (info != null) {
						tf.setText(info.getProduct_id());
						tf1.setText(info.getName());
						ta.setText(info.getDescription());
						tf2.setText(info.getQuantity()+"");
						tf3.setText(info.getUnit_price()+"");
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"First",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		first.setBounds(33, 269, 89, 23);
		getContentPane().add(first);
		
		JButton previous = new JButton("Previous");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pID = tf.getText();
					int index = random.findIndex(pID);
					if (index > 0) {
						info info = random.readInformation((index-1));
						if (info != null) {
							tf.setText(info.getProduct_id());
							tf1.setText(info.getName());
							ta.setText(info.getDescription());
							tf2.setText(info.getQuantity()+"");
							tf3.setText(info.getUnit_price()+"");
						}
					}
				}catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"Last",JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		
		previous.setBounds(156, 269, 89, 23);
		getContentPane().add(previous);
		
		JButton next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pID = tf.getText();
					int index = random.findIndex(pID);
					if (index <= random.getNumberOfRecords()) {
						info info = random.readInformation((index+1));
						if (info != null) {
							tf.setText(info.getProduct_id());
							tf1.setText(info.getName());
							ta.setText(info.getDescription());
							tf2.setText(info.getQuantity()+"");
							tf3.setText(info.getUnit_price()+"");
						}
					}
				}catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"Last",JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		next.setBounds(278, 269, 89, 23);
		getContentPane().add(next);
		
		JButton last = new JButton("Last");
		last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = random.getNumberOfRecords();
					info info = random.readInformation((num));
					if (info != null) {
						tf.setText(info.getProduct_id());
						tf1.setText(info.getName());
						ta.setText(info.getDescription());
						tf2.setText(info.getQuantity()+"");
						tf3.setText(info.getUnit_price()+"");
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"Last",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		last.setBounds(395, 269, 89, 23);
		getContentPane().add(last);
		
		tf2 = new JTextField();
		tf2.setBounds(411, 110, 86, 20);
		getContentPane().add(tf2);
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setBounds(411, 164, 86, 20);
		getContentPane().add(tf3);
		tf3.setColumns(10);
	}
}
