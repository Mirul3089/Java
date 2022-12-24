import java.util.*;
public class testfloor {
	public static void main(String[]args) 
	{
		Tile tile = new Tile(3.5);
		Floor floor = new Floor(2.75, 4.0);
		Calculator calculator = new Calculator(floor, tile);
		System.out.println("total= " + calculator.getTotalCost());
		tile = new Tile(1.5);
		floor = new Floor(5.4, 4.5);
		calculator = new Calculator(floor, tile);
	    System.out.println("total= " + calculator.getTotalCost());

	}
}
