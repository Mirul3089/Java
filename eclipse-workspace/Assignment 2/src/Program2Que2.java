import java.util.*;
public class Program2Que2 {

	public static void main(String[] args) {
		int a,b,c;
		 boolean a1 = true;
		 boolean b1 = false;
		 
		 Scanner s1=new Scanner(System.in);
		 System.out.println("Enter the First number:");
		 a=s1.nextInt();
		 System.out.println("Enter the Second number:");
		 b=s1.nextInt();
		 System.out.println("Enter the Third number:");
		 c=s1.nextInt();
		 
		 int sum= a+b;
		 
		 if (sum == c) 
		 {
			 System.out.println(a1);
		 }
		 else 
		 {
			 System.out.println(b1);
		 }
}
}
