
import java.util.*;

public class program1 {

	public static void main(String[] args) {
	
		double pr, gp;
		int hours;
		String fname, lname;
		
		Scanner s= new Scanner(System.in);
		
		System.out.println("What is your firstname? ");
		fname= s.nextLine();
		
		System.out.println("What is your Lastname? ");
		lname= s.nextLine();
		
		System.out.println("How many hours have you worked?");
		hours= s.nextInt();
		
		System.out.println("What is your pay rate? ");
		pr= s.nextDouble();
		
	
		gp = hours * pr;
		
		System.out.println("Your Grosspay is:"+ gp);

}
}
