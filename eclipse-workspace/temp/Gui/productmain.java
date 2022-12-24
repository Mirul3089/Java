
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
	public ProductMainGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Product Main GUI");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFileMenu = new JMenu("File");
		menuBar.add(mnFileMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		mnFileMenu.add(mntmExit);
		
		JMenu mnProductMenu = new JMenu("Product");
		menuBar.add(mnProductMenu);
		
		JMenuItem mntmAddUpdate = new JMenuItem("Add/Update");
		mntmAddUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				product add = new product();
				add.setVisible(true);
				add.setResizable(false);
				add.setSize(600, 400);
			}
		});
		mnProductMenu.add(mntmAddUpdate);
		
		JMenuItem mntmFindDisplay = new JMenuItem("Find/Display");
		mntmFindDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findproduct find = new findproduct();
				find.setVisible(true);
				find.setResizable(false);
				find.setSize(600, 350);
			}
		});
		mnProductMenu.add(mntmFindDisplay);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(74, 93, 281, 35);
		getContentPane().add(lblNewLabel);
	}

}
