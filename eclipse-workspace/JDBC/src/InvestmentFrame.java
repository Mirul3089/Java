

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class InvestmentFrame extends JFrame {

	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 100;
	private static final double DEFAULT_RATE = 5;
	private static final double INITIAL_BALANCE = 1000;
	
	private static final int AREA_ROWS = 10;
	private static final int AREA_COLUMNS = 30;

	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private JTextArea resultArea;
	private JPanel panel;
	private bank account;

	public InvestmentFrame() {
		account = new bank(INITIAL_BALANCE);
		resultArea = new JTextArea(AREA_ROWS,AREA_COLUMNS);
		resultArea.setEditable(false);

		createTextField();
		createButton();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	private void createTextField() {
		rateLabel = new JLabel("Interest Rate: ");
		final int FIELD_WIDTH = 10;
		rateField = new JTextField(FIELD_WIDTH);
		rateField.setText("" + DEFAULT_RATE);
	}

	private void createButton() {
		button = new JButton("Add Interest");

		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				double rate = Double.parseDouble(rateField.getText());
				double interest = account.getBalance() * rate / 100;
				account.deposit(interest);
				resultArea.append(account.getBalance() + "\n");
			}
		};
		button.addActionListener(al);
	}

	private void createPanel() {
		panel = new JPanel();
		panel.add(rateLabel);
		panel.add(rateField);
		panel.add(button);
		panel.add(resultArea);
		
		JScrollPane sp=new JScrollPane(resultArea);
		panel.add(sp);
		add(panel);
	}
}
