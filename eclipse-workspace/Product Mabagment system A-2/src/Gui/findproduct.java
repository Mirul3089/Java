
package Gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import logic.info;
import logic.random;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class findproduct extends JFrame {
	
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	public findproduct() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Find/Display Products");
		
		JRadioButton PriceRange = new JRadioButton("Price Range");
		PriceRange.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton Keyword = new JRadioButton("Keyword");
		Keyword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton All = new JRadioButton("All");
		All.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tf2.setColumns(10);
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tf3.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		
		JButton btnFindDisplay = new JButton("Find/Display");
		btnFindDisplay.addActionListener(new ActionListener() { //Action Listener
			public void actionPerformed(ActionEvent e) {
				if(PriceRange.isSelected()) {
					int pFrom = Integer.parseInt(tf2.getText());
					int pTo = Integer.parseInt(tf1.getText());
					try {
						String output = random.checkPrice(pTo, pFrom);
						textArea.setText(output);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"Display",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(Keyword.isSelected()) {
					String keyword = tf3.getText();
					try {
						String output = random.checkkeyword(keyword);
						textArea.setText(output);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error:" + e1.getMessage(),"Display",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(All.isSelected()) {
					try {
						int index = 1;
						String output = "";
						int num = random.getNumberOfRecords();
						while(index<=num) {
							info info = random.readInformation(index);
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
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(PriceRange, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(tf1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(tf2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(btnFindDisplay, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(Keyword, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(tf3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(183))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(All, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(PriceRange, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(tf1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(tf2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnFindDisplay, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Keyword, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(tf3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)))
					.addGap(12)
					.addComponent(All, GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
					.addGap(7)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(11))
		);
		getContentPane().setLayout(groupLayout);
	}
}
