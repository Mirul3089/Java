import java.util.Scanner;
public class exception1 {
	public static int quotient1(int n1, int n2) {
		if (n2 == 0)
			throw new IllegalArgumentException("Divisor cannot be zero"); // refer a tree diagram in ppt
		
		return n1 / n2;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Prompt the user to enter two integers
		System.out.print("Enter two integers: ");
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		try{
			System.out.println("Hi");
			int result = quotient1(n1, n2);
			System.out.println("hello");
			System.out.println(n1 + " / " + n2 + " is " + result);
		}
		catch (Throwable e) {
			System.out.println(e);
			
		}
		
		System.out.println("Execution continues ...");
		
		input.close();
	}
}
/*
 public static void main(String[] args) {
		try {
			method1();
		}
		catch (Exception ex3) {
//			ex3.printStackTrace();
			System.out.println(ex3.getMessage());
//			ex3.printStackTrace();
		}
	}

	public static void method1() throws Exception {
		try {
			method2();
		}
		catch (Exception ex2) {
			
			ex2.printStackTrace();
			throw new Exception("New info from method1");
			
		}
	}

	public static void method2() throws Exception {
		throw new Exception("New info from method2");
	}
 */
