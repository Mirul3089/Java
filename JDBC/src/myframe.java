
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class myframe extends JFrame {

	public static void main(String[] args) {

		JFrame myFrame = new JFrame("My Frame");
		JButton jbt = new JButton("Submit");
		JTextField jf = new JTextField(20);
		JTextField jf1 = new JTextField(20);
		JPanel jp = new JPanel();
		JLabel jb = new JLabel("First name");
		JLabel jb1 = new JLabel("Last name");

		JLabel jb2 = new JLabel();

		
		
		jp.add(jb);
		jp.add(jf);
		jp.add(jb1);
		jp.add(jf1);
		
		jp.add(jb2);
		jp.add(jbt);
		
		myFrame.add(jp);

		

//		this.jbtOk.setText("New OK");
		// panel.add(jbtOk);

		// jbtCancel = new JButton("Cancel");
		// panel.add(jbtCancel);

		// Font myFont= new Font("SansSerif", Font.BOLD+Font.ITALIC, 15);
		// panel.setBackground(Color.YELLOW);
		// panel.setFont(myFont);

		myFrame.setSize(300, 250); // Set the frame size
//		this.pack();
		myFrame.setLocationRelativeTo(null);// Center a frame
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setVisible(true); // Display the frame
		myFrame.setResizable(false);

		ActionListener a1 = new ActionListener() {

			public void actionPerformed(ActionEvent e)
            {
				jb2.setText("Hello " + jf.getText() + " " + jf1.getText());
			}
		};
		jbt.addActionListener(a1);
	}

}