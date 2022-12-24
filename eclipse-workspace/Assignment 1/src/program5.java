import java.util.*;
public class program5 {

	public static void main(String[] args) {
		double a, b;
        Scanner s= new Scanner(System.in);
		
		System.out.println("Enter the number a:");
		a= s.nextDouble();
		
		System.out.println("Enter the number b:");
		b= s.nextDouble();
		
		double sum= a+b;
		
		System.out.println("Addition of given Numbers is:"+sum);
		
        double mul= a*b;
		
		System.out.println("Multiplication of given Numbers is:"+mul);
        
        double sub= a-b;
		
		System.out.println("Substraction of given Numbers is:"+sub);
		
        double div= a/b;
		
		System.out.println("Division of given Numbers is:"+div);
		
        double rem= a%b;
		
		System.out.println("Remainder of given Numbers is:"+rem);
	}
	

}
