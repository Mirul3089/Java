import java.util.*;
public class car {

	public void m1() {
	      System.out.println("car 1");
	   }

	   public void m2() {
	      System.out.println("car 2");
	   }

	   public String toString() {
	      return "vroom";
	   }
	   public static void main(String[]args) {
	   truck mycar = new truck();

	      mycar.m1();            

	      mycar.m2(); 
	   
	}
}
