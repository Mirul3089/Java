import java.util.*;
public class prgram3 {

	public static void main(String[] args) {
		
		int age;
		String name, city, college, profession, animal, pet;
		
		Scanner s= new Scanner(System.in);
		
		System.out.println(" 1.What is your Name? ");
		name= s.nextLine();
		
		System.out.println("2. What is your name of the City? ");
		city= s.nextLine();
		
		System.out.println("3. What is your Age? ");
		age= s.nextInt();
		s.nextLine();
		
		System.out.println("4. What is your name of a college? ");
		college= s.nextLine();
		
		
		System.out.println("5. What is your Profession? ");
		profession= s.nextLine();
		
		
		System.out.println("6. Which type of animal you do have? ");
		animal= s.nextLine();
		
		System.out.println("7. What is your pet's name? ");
		pet= s.nextLine();
		
		System.out.println("There once was a person named " +name+ " who lived in " +city+ ". At the age of " +age+", " +name+ " went to college at "+college+"." +name+ " graduated and went to work as a " +profession+". Then, " +name+ " adopted a " +animal+ " named " +pet+ ".");
	}

}
