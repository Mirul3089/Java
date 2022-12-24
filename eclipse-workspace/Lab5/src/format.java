import java.util.*;
public class format {

	public static void main(String[] args) {
		double x,y;
		
		Scanner s1=new Scanner(System.in);
		
		System.out.println("Enter the number X:");
		x= s1.nextDouble();
        
		y=x*x;
		System.out.printf("Square of X is: %.2f\n", y);
	}

}
