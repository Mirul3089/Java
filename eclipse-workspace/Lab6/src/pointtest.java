import java.util.*;
public class pointtest {

	public static void main(String[] args) {
		point first = new point(6, 5);
		point second = new point(3, 1);
	    System.out.println("distance(0,0)= " + first.distance());
		System.out.println("distance(second)= " + first.distance(second));
		System.out.println("distance(2,2)= " + first.distance(2, 2));
		point point = new point();
		System.out.println("distance()= " + point.distance());

	}

}
