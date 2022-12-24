import java.util.*;
public class Program3Que3 {

	public static void main(String[] args) 
	{
		long minutes,days,hours,years;
		 boolean a1 = true;
		 boolean b1 = false;
		 
		 Scanner s1=new Scanner(System.in);
		 
		 System.out.println("Enter the Minutes:");
		 minutes=s1.nextInt();
		 if(minutes>0) 
		 {
			 hours= minutes/60;
			 days=hours/24; 
			 years=days/365;
			 System.out.println(+minutes+ " min = " +years+ " Years and " +days+ " Days");
			 
			 
		 }
		 else 
		 {
			 System.out.println("Invalid"+b1);
		 }
		 
		 

	}

}
