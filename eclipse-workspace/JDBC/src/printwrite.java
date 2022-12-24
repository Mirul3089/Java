
import java.io.*;
import java.io.Writer;

public class printwrite {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/m1.txt");
//		if (file.exists()) {
//			System.out.println("File already exists");
//			System.exit(0);
//		}

        // Create a file
        PrintWriter output = new PrintWriter(file);

        // Write formatted output to the file
        output.print("John M Smith ");
        output.println(90);
        output.print("Eric K Jones ");
        output.println(85);
        
        System.out.println("Done");

        // Close the file
        output.close();
    }
}