import java.util.*;

public class admit {
	static int smaller;
	
	
    public static void main(String[] args) {
    	int a = 7, b = 42;
    	minimum (a,b);
    	
        if (smaller == a) {
            System.out.println("a is the smallest!");
        }
       else {
    	   System.out.println("b is the smallest!");
       }
    }

    public static int minimum(int a, int b) {  // returns which int is smaller
        if (a < b) {
            return smaller = a;
        } 
        else if (a >= b)   
        {
            return smaller = b;
        }
        else {
        	
        }
		return smaller;
       
    }
}