import java.util.*;
public class test {
	
public static void main(String[]args) {
	int[] list = {2, 18, 6, -4, 5, 1};
	
	for (int i = 0; i < list.length; i++) 
	{	
		System.out.println("before: " + list[i]);
	    list[i] = list[i] + (list[i] / list[0]);
	    System.out.println("After: " + list[i]);
	}


}
}
/*String[] values=new String[5];
={1,2,3,4,5,6}
Scanner s1=new Scanner (System.in);
int bb[]= {1,2,3,4,5,6,7,8,9};



for(int index=0;index<bb.length;index++) 
{
System.out.println(bb[index]);
System.out.println("enter the strings");
values[0]=s1.nextLine();
System.out.println(values[0]);
}*/
