import java.util.*;
public class Exercise2 {

	public static void main(String[] args) {
		int a[][]={{10,20}, {30,40}, {50,60}, {70,80}, {90, 100}};
		
		for(int row=0;row<a.length;row++) 
		{
			for(int col=0;col<a[row].length;col++) {
				System.out.print(a[row][col]+ "\t");
			}
			System.out.print("\n");
		}

	}

}
