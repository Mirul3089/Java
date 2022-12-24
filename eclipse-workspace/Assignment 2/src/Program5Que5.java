import java.util.*;
public class Program5Que5 {

	public static void main(String[] args) 
	{
		int q,u;
		double f,d;
		Scanner s1=new Scanner(System.in);
		 
		 System.out.println("Enter the Purchased Quantity:");
		 q=s1.nextInt();
		 
		 if(q>1000) 
		 {
			 u=q*100;
			 d=u*0.1;
			 f=u-d;
			 
			 System.out.println("Your total cost after 10% discount is: "+f);
		 }
		 else 
		 {
			 System.out.println("You haven't got any discount");
		 }

	}

}

