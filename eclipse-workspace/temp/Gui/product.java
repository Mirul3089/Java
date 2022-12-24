
package Gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;

import Business.*;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class product extends JFrame {
	private JTextField txtProduct_id;
	private JTextField txtName;
	private JTextField txtQuantity;
	private JTextField txtUnitPrice;
	public product() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		setTitle("Add/Update Product");
		getContentPane().setLayout(null);
		
		JLabel lblProduct_id = new JLabel("Product ID:");
		lblProduct_id.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProduct_id.setBounds(23, 22, 77, 14);
		getContentPane().add(lblProduct_id);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(22, 66, 46, 14);
		getContentPane().add(lblName);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescription.setBounds(23, 112, 77, 14);
		getContentPane().add(lblDescription);
		
		JLabel lblQuantity = new JLabel("Quantity in hand:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuantity.setBounds(303, 112, 98, 14);
		getContentPane().add(lblQuantity);
		
		JLabel lblUnit_price = new JLabel("Unit Price:");
		lblUnit_price.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUnit_price.setBounds(324, 166, 77, 14);
		getContentPane().add(lblUnit_price);
		
		txtProduct_id = new JTextField();
		txtProduct_id.setBounds(95, 20, 86, 20);
		getContentPane().add(txtProduct_id);
		txtProduct_id.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(95, 64, 86, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JTextArea txtDescription = new JTextArea();
		txtDescription.setRows(5);
		txtDescription.setColumns(6);
		txtDescription.setBounds(95, 108, 198, 85);
		getContentPane().add(txtDescription);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if(Validator.isPresent(txtProduct_id, "Product ID") && Validator.isPresent(txtName, "Name") && Validator.isNumber(txtQuantity, "Quantity") && Validator.isNumber(txtUnitPrice, "Unit Price") && RandomIO.checkpID(txtProduct_id)) {
					String pID = txtProduct_id.getText();
					String Name = txtName.getText();
					String desc = txtDescription.getText();
					int quantity = Integer.parseInt(txtQuantity.getText());
					int price = Integer.parseInt(txtUnitPrice.getText());
					try {
						RandomIO.addInformation(pID, Name, desc, quantity, price);
						JOptionPane.showMessageDialog(null, "Information is saved to file.","Save Information",JOptionPane.INFORMATION_MESSAGE);
					}
					catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error saving to file ->" + e1.getMessage(),"Save Information",JOptionPane.ERROR_MESSAGE);
					}
				}
				/*else {
					JOptionPane.showMessageDialog(null, "Duplicate ID is not allowed.","Duplicate Data",JOptionPane.ERROR_MESSAGE);
				}*/
				}catch (IOException e2) {
					JOptionPane.showMessageDialog(null, "Duplicate ID is not allowed." + e2.getMessage(),"Duplicate Data",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(33, 216, 89, 23);
		getContentPane().add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Validator.isPresent(txtProduct_id, "Product ID") && Validator.isPresent(txtName, "Name") && Validator.isNumber(txtQuantity, "Quantity") && Validator.isNumber(txtUnitPrice, "Unit Price") && !(RandomIO.checkpID(txtProduct_id))) {
						String pID = txtProduct_id.getText();
						String Name = txtName.getText();
						String desc = txtDescription.getText();
						int quantity = Integer.parseInt(txtQuantity.getText());
						int price = Integer.parseInt(txtUnitPrice.getText());
						try {
							RandomIO.updateInformation(pID, Name, desc, quantity, price);
							JOptionPane.showMessageDialog(null, "Information is saved to file.","Save Information",JOptionPane.INFORMATION_MESSAGE);
						}
						catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "Error saving to file ->" + e1.getMessage(),"Save Information",JOptionPane.ERROR_MESSAGE);
						}
					}
					/*else {
						JOptionPane.showMessageDialog(null, "No matching ID found.","Cannot Update",JOptionPane.ERROR_MESSAGE);
					}*/
					}catch (IOException e2) {
						JOptionPane.showMessageDialog(null, "No matching ID found." + e2.getMessage(),"Cannot Update",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setBounds(156, 216, 89, 23);
		getContentPane().add(btnUpdate);
		
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Information info = RandomIO.readInformation(1);
					if (info != null) {
						txtProduct_id.setText(info.getProduct_id());
						txtName.setText(info.getName());
						txtDescription.setText(info.getDescription());
						txtQuantity.setText(info.getQuantity()+"");
						txtUnitPrice.setText(info.getUnit_price()+"");
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"First",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFirst.setBounds(33, 269, 89, 23);
		getContentPane().add(btnFirst);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pID = txtProduct_id.getText();
					int index = RandomIO.findIndex(pID);
					if (index > 0) {
						Information info = RandomIO.readInformation((index-1));
						if (info != null) {
							txtProduct_id.setText(info.getProduct_id());
							txtName.setText(info.getName());
							txtDescription.setText(info.getDescription());
							txtQuantity.setText(info.getQuantity()+"");
							txtUnitPrice.setText(info.getUnit_price()+"");
						}
					}
				}catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"Last",JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPrevious.setBounds(156, 269, 89, 23);
		getContentPane().add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String pID = txtProduct_id.getText();
					int index = RandomIO.findIndex(pID);
					if (index <= RandomIO.getNumberOfRecords()) {
						Information info = RandomIO.readInformation((index+1));
						if (info != null) {
							txtProduct_id.setText(info.getProduct_id());
							txtName.setText(info.getName());
							txtDescription.setText(info.getDescription());
							txtQuantity.setText(info.getQuantity()+"");
							txtUnitPrice.setText(info.getUnit_price()+"");
						}
					}
				}catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"Last",JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNext.setBounds(278, 269, 89, 23);
		getContentPane().add(btnNext);
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = RandomIO.getNumberOfRecords();
					Information info = RandomIO.readInformation((num));
					if (info != null) {
						txtProduct_id.setText(info.getProduct_id());
						txtName.setText(info.getName());
						txtDescription.setText(info.getDescription());
						txtQuantity.setText(info.getQuantity()+"");
						txtUnitPrice.setText(info.getUnit_price()+"");
					}
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"Last",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLast.setBounds(395, 269, 89, 23);
		getContentPane().add(btnLast);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(411, 110, 86, 20);
		getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		txtUnitPrice = new JTextField();
		txtUnitPrice.setBounds(411, 164, 86, 20);
		getContentPane().add(txtUnitPrice);
		txtUnitPrice.setColumns(10);
	}
}
