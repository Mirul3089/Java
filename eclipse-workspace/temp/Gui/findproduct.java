
package Gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Business.Information;
import Business.RandomIO;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class findproduct extends JFrame {
	private JTextField txtTo;
	private JTextField txtFrom;
	private JTextField txtKeyword;
	public findproduct() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Find/Display Products");
		
		JRadioButton rdbtnPriceRange = new JRadioButton("Price Range");
		rdbtnPriceRange.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnKeyword = new JRadioButton("Keyword");
		rdbtnKeyword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnAll = new JRadioButton("All");
		rdbtnAll.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtTo = new JTextField();
		txtTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTo.setColumns(10);
		
		txtFrom = new JTextField();
		txtFrom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFrom.setColumns(10);
		
		txtKeyword = new JTextField();
		txtKeyword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtKeyword.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		
		JButton btnFindDisplay = new JButton("Find/Display");
		btnFindDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPriceRange.isSelected()) {
					int pFrom = Integer.parseInt(txtFrom.getText());
					int pTo = Integer.parseInt(txtTo.getText());
					try {
						String output = RandomIO.checkPrice(pTo, pFrom);
						textArea.setText(output);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"Display",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(rdbtnKeyword.isSelected()) {
					String keyword = txtKeyword.getText();
					try {
						String output = RandomIO.checkkeyword(keyword);
						textArea.setText(output);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"Display",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(rdbtnAll.isSelected()) {
					try {
						int index = 1;
						String output = "";
						int num = RandomIO.getNumberOfRecords();
						while(index<=num) {
							Information info = RandomIO.readInformation(index);
							if (info != null) {
								output += "Product_id:" + info.getProduct_id() + " Name:" + info.getName() + " Description:" + info.getDescription() + " Quantity:" + info.getQuantity() + " Unit Price:" + info.getUnit_price() + "\n";
								index++;
							}
						}
						textArea.setText(output);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"Display",JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Choose any 1 radio button", "Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnFindDisplay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFrom.setText("");
				txtTo.setText("");
				txtKeyword.setText("");
				textArea.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(rdbtnPriceRange, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(txtTo, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(txtFrom, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(btnFindDisplay, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(rdbtnKeyword, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(txtKeyword, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(183)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(rdbtnAll, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnPriceRange, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtTo, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtFrom, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnFindDisplay, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnKeyword, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtKeyword, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addComponent(rdbtnAll, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(11))
		);
		getContentPane().setLayout(groupLayout);
	}
}
