import java.util.*;
public class program2 {

	public static void main(String[] args) {
		
     System.out.println("One chocolate holds a 10 calories");
     float c,o;
     int cal=10;
     
     Scanner s= new Scanner(System.in);
		
		System.out.println("How many chocolates have you eaten?");
		c= s.nextFloat();
		
		o= c*cal;
		System.out.println("The consumed calories are:"+o);
	}

}
