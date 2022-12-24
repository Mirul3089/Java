import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class pizzaorder extends JFrame
{
	
private static final double LARGE =14.99;
private static final double MEDIUM =10.99;
private static final double SMALL =6.99;
private static final double PEPPERONI =5.00;
private static final double VEGGIES =3.00;

private double price;

private ActionListener l;

JPanel jp = new JPanel();
JPanel jp1 = new JPanel();
JPanel jp2 = new JPanel();
JPanel jp3 = new JPanel();


JRadioButton rb = new JRadioButton("Small");
JRadioButton rb1 = new JRadioButton("Medium");
JRadioButton rb2 = new JRadioButton("Large");

public void CreateRadioButton() 
{
	
	jp.setLayout(new GridLayout(3,1));
	jp.setBorder(new TitledBorder(new EtchedBorder(),"Size"));
	
	ButtonGroup group =new ButtonGroup();

	group.add(rb);
	group.add(rb1);
	group.add(rb2);
	
	rb.addActionListener(l);
	rb1.addActionListener(l);
	rb2.addActionListener(l);
	
	rb.setSelected(true);
	
	jp.add(rb);
	jp.add(rb1);
	jp.add(rb2);

}

JCheckBox cb= new JCheckBox("Pepperoni");
JCheckBox cb1= new JCheckBox("Veggies");

public void CreateCheckBox() 
{
	
	
	jp1.setLayout(new GridLayout(2,1));
	jp1.setBorder(new TitledBorder(new EtchedBorder(),"Toppings"));
	
	cb.addActionListener(l);
	cb1.addActionListener(l);
	
	jp1.add(cb);
	jp1.add(cb1);
	
	
}
JTextField jtf = new JTextField(20);

public void Createdisplay() {
	
	JLabel p1= new JLabel("Your Price:");
	
	jp2.add(p1);
	jp2.add(jtf);
}

public void display() {
	
	jp3.add(jp);
	jp3.add(jp1);
	
    add(jp3, BorderLayout.CENTER);
	
	add(jp2, BorderLayout.SOUTH);
	
	
}


public pizzaorder() {
	
	setSize(300, 200);
    
	
	class PizzaSelectionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent ae) {
			calculateprice();
		}
	}
	
	l=new PizzaSelectionListener();
	
	CreateRadioButton();
	CreateCheckBox();
	Createdisplay();
	display();
	
	
}

public void calculateprice(){
	
	price=0;
	if(rb.isSelected()) {
		price=SMALL;
	}
	else if(rb1.isSelected()) {
		price=MEDIUM;
	}
		
	else if(rb2.isSelected()) {
		price=LARGE;
	}
	 
	if(cb.isSelected()) {
		price=price + PEPPERONI;
	}
	if(cb1.isSelected()) {
		price=price + VEGGIES;
	}
	
	jtf.setText("$" + String.format("%.2f", price));
	

}
}
