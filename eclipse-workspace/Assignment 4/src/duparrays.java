import java.util.*;
public class duparrays {

	public static void main(String[] args) 
    {
        String array[]  = {"Mirul","Rishi", "Deep", "Raj", "Shaym", "Rishi", "Mirul"};
 
        for (int i = 0; i < array.length-1; i++)
        {
            for (int j = i+1; j < array.length; j++)
            {
                if ((array[i] == array[j]) && (i != j))
                {
                    System.out.println("Duplicate values in array : "+array[j]);
                }
            }
        }
    }    
}

