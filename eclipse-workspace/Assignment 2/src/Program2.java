import java.util.*;
public class Program2 {
//it's Question 1
	public static void main(String[] args) 
	{ 
	     boolean issinging = true;
		 boolean isnotsinging = false;
		 int hour;
		 
		/* Scanner s1=new Scanner(System.in);
		 System.out.println("What time is it? please give the hour only from 24 hour format.");
		 hour=s1.nextInt();*/
		 
      for(hour=0;hour<=23;hour++) 
		 {
			 
		 if(hour<=0 || hour>23) 
		 {
			 System.out.println("(Please provide a valid time) " +isnotsinging);
	     }
		 else if(hour<8 || hour>22)
		 {
			 System.out.println("(Bird is singing You have to wake up) " +issinging);
		 }
		 else 
		 {
			 System.out.println("(You don't have to wakeup) "+ isnotsinging);
		 }
	  }
}
}