import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class myframe1 {

	public static void main(String[]args) {
		
		JFrame jf = new JFrame("Calculator");
		JPanel jp = new JPanel();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel mainp = new JPanel();
		
		JLabel jl = new JLabel("Enter a first number:");
		JLabel jl2 = new JLabel("Enter a Second number:");
		JLabel jl3 = new JLabel();
	
		JTextField jtf = new JTextField(20); 
		JTextField jtf1 = new JTextField(20); 
		
		JButton jb = new JButton("Add");
		JButton jb1 = new JButton("Substract");
		JButton jb2 = new JButton("Divide");
		JButton jb3 = new JButton("Multiply");
		
		BoxLayout boxlayout = new BoxLayout(jp,BoxLayout.X_AXIS);
		BoxLayout boxlayout1 = new BoxLayout(jp3,BoxLayout.X_AXIS);
		BoxLayout buttonlayout = new BoxLayout(jp1,BoxLayout.X_AXIS);
		BoxLayout resultlayout = new BoxLayout(jp2,BoxLayout.X_AXIS);
		
		jp.setLayout(boxlayout);
		jp3.setLayout(boxlayout1);
		jp1.setLayout(buttonlayout);
		jp2.setLayout(resultlayout);
		
		jp.add(jl);
		jp.add(jtf);
		jp3.add(jl2);
		jp3.add(jtf1);
		jp1.add(jb);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		jp2.add(jl3);
		
		mainp.add(jp);
		mainp.add(jp3);
		mainp.add(jp1);
		mainp.add(jp2);
		
		
		jf.setSize(550, 500);
		jf.setLocationRelativeTo(null); 
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true); 
		jf.setResizable(false);
		
		jf.add(mainp);
		
		ActionListener a1 = new ActionListener() {

			public void actionPerformed(ActionEvent e)
            {
				if(e.getSource() == jb) 
				{
					double result= Double.parseDouble(jtf.getText()) + Double.parseDouble(jtf1.getText());
					jl3.setText("the result is: " + result);
				}
				else if(e.getSource() == jb1)
				{
					double result= Double.parseDouble(jtf.getText()) - Double.parseDouble(jtf1.getText());
					jl3.setText("the result is: " + result);
				}
				else if(e.getSource() == jb2)
				{
					double result= Double.parseDouble(jtf.getText()) / Double.parseDouble(jtf1.getText());
					jl3.setText("the result is: " + result);
				}
				else if(e.getSource() == jb3)
				{
					double result= Double.parseDouble(jtf.getText()) * Double.parseDouble(jtf1.getText());
					jl3.setText("the result is: " + result);
				}
			}
		};
		jb.addActionListener(a1);
		jb1.addActionListener(a1);
		jb2.addActionListener(a1);
		jb3.addActionListener(a1);
	
	}
		
}

