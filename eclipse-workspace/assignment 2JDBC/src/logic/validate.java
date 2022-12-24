
package logic;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class validate{
	public static boolean isPresent(JTextComponent c, String title) {
		if(c.getText().length() == 0) {
			showMessage(c, title + " is a required field.\nPlease re-enter");
			c.requestFocusInWindow();
			return false;
		}
		return true;
	}
	
	public static boolean isNumber(JTextComponent c, String title) {
		if(c.getText().length() == 0) {
			showMessage(c, title + " is a required field.\nPlease re-enter");
			c.requestFocusInWindow();
			return false;
		}
		else {
			try {
				int num = Integer.parseInt(c.getText());
				if(num > 0)
					return true;
				else {
					showMessage(c,title + " should be greater than zero.\nPlease re-enter");
					c.requestFocusInWindow();
					return false;
				}
			}
			catch (NumberFormatException nfe) {
				JOptionPane.showConfirmDialog(null, title + " should be numeric",title, JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
	}
	
	private static void showMessage(JTextComponent c, String message) {
		JOptionPane.showConfirmDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
	}

}
