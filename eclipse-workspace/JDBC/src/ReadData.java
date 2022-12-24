
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {

    public static void main(String[] args) {
        // Create a File instance
        File file = new File("src/m1.txt");
        if (!file.exists()) {
            System.out.println("File does not exist; We cannot read it!");
            System.exit(0);
        }

        try ( Scanner input = new Scanner(file); ) {

            // Read data from a file
            while (input.hasNext()) {
                String firstName = input.next();
                String lastName = input.next();
                int score = input.nextInt();
                System.out.println(firstName+ " "+ lastName + " " + score);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

       /* try ( Scanner input = new Scanner(file);) {
            // Read data from a file (Alternative approach)
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Scanner inputLine = new Scanner(line); // read from String
                String firstName = inputLine.next();
                String lastName = inputLine.next();
                int score = inputLine.nextInt();
                System.out.println(firstName + " " + lastName + " " + score);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }*/
    }
}
