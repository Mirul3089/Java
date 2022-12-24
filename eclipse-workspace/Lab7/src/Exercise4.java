import java.util.*;
public class Exercise4 {

	public static void main(String[] args) {
		int a,b, sum;
		char y;
		
        Scanner s1=new Scanner(System.in);
		
		do {
			System.out.println("Enter a number A:");
	        a=s1.nextInt();
	        System.out.println("Enter a number B:");
	        b=s1.nextInt();
			sum= a+b;
			System.out.println("Sum is:"+sum);
			
			System.out.println("Do you want to continue? Enter Yes or No");
             y=s1.next().charAt(0);
		}
		
		  while(y=='y');
		
	}
	

}
