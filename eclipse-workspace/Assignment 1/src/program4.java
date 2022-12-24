import java.util.*;
public class program4 {
	public static void main(String[] args) {
		
		double pi= Math.PI;
		double area, perimeter;
		double radius;
		
        Scanner s= new Scanner(System.in);
		
		System.out.println("Enter the Radius: ");
		radius= s.nextFloat();
		
		area= pi*radius*radius;
		perimeter= 2*pi*radius;
		
		
		System.out.println("Area of the circle is: "+area);
		
		System.out.println("Perimeter of the circle shape is: "+perimeter);
	
		
	}
}
