
import javax.swing.JOptionPane; // Needed for Box Dialog

 /**This program demonstrates using dialogs with JOptionPane. */

 public class Bday
{
 public static void main(String[] args)
 {
 String firstName; // The user's first name
 String LastName; // The user's last name



 // Get the user's first name.
 firstName = JOptionPane.showInputDialog("What is " + "your first name? ");

 // Get the user's last name.
 LastName = JOptionPane.showInputDialog("What is " + "your Last name? ");

 // Display a greeting
 JOptionPane.showMessageDialog(null, "Hello " +firstName + " " + LastName);

 System.exit(0);
 }
 }

