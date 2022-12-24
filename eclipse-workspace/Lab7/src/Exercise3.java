import java.util.*;
public class Exercise3 {

	public static void main(String[] args) {
		int a, fact=1;
		
		Scanner s1=new Scanner(System.in);
		
		System.out.println("Enter a number:");
        a=s1.nextInt();
        
        for(int i=1;i<=a;i++) 
		{
			fact=fact*i;
		}
            
        System.out.printf("Factorial of %d is: %d", a, fact) ;  
	}

}
