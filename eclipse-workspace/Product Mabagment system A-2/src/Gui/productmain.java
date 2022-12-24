
package Gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class productmain extends JFrame {
	
	public productmain() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Product Management System");
		
		JMenuBar menuBar = new JMenuBar();//Menu bar
		setJMenuBar(menuBar);
		
		JMenu FileMenu = new JMenu("File"); //Menu item
		menuBar.add(FileMenu);
		
		JMenuItem Exit = new JMenuItem("Exit");
		Exit.addActionListener(new ActionListener() {      //Event listener
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		FileMenu.add(Exit); //added exit item in menu
		
		JMenu PMenu = new JMenu("Product"); //menu for product
		menuBar.add(PMenu);
		
		JMenuItem AddUpdate = new JMenuItem("Add/Update");
		AddUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product add = new product();
				add.setVisible(true);
				add.setResizable(false);
				add.setSize(600, 400);
			}
		});
		PMenu.add(AddUpdate);
		
		JMenuItem FindDisplay = new JMenuItem("Find/Display");
		FindDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findproduct find = new findproduct();
				find.setVisible(true);
				find.setResizable(false);
				find.setSize(600, 350);
			}
		});
		PMenu.add(FindDisplay);
		getContentPane().setLayout(null);
		
		JLabel L1= new JLabel("Product Management System");
		
		L1.setBounds(74, 93, 281, 35);
		getContentPane().add(L1);
	}

}
