import java.util.*;
public class Exercise4 {

	public static void main(String[] args) {
		String str[][]={{"one", "two"}, {"three", "four"}, {"five", "six"}};
		
		for( int i=0;i<str.length;i++) 
		{
			for( int j=0;j<str[i].length;j++) 
			{
				System.out.print(str[i][j] +"\t");
			}
			System.out.print("\n");
		}
		
	}

}
