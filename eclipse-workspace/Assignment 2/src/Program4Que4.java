import java.util.*;
public class Program4Que4 {

	public static void main(String[] args) {
		int a,b,c;
		 boolean a1 = true;
		 boolean b1 = false;
		                                    /*public static int main then we can return*/
		 Scanner s1=new Scanner(System.in);
		 
		 System.out.println("Enter the First number:");
		 a=s1.nextInt();
		 System.out.println("Enter the Second number:");
		 b=s1.nextInt();
		 System.out.println("Enter the Third number:");
		 c=s1.nextInt();
		 if(a<10 || a>1000)
		 {
			 System.out.println(b1);
		 }
		 else if(b<10 || b>1000) 
			 {
				 System.out.println(b1);
			 }
		else if(c<10 || c>1000) 
		   {
			 System.out.println(b1);
		   }
		else if((a % 10 == b % 10) || (a % 10 == c % 10) || (b % 10 == c % 10))
		 {  
			 System.out.println(a1);
		 }
        else 
         {
        	 System.out.println(b1);
         }
	}

}
