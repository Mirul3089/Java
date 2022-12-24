
import java.io.*;
import java.util.*;

public class replace {

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }

        // Check command line parameter usage
        if (args.length != 4) {
            System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr newStr");
            System.exit(0);
        }

        // Check if source file exists
        File sourceFile = new File("src/" + args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + sourceFile.getCanonicalPath() + " does not exist");
            System.exit(1);
        }

        // Check if target file exists
        File targetFile = new File("src/" + args[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + sourceFile.getAbsolutePath() + " already exists");
            System.exit(2);
        }

        try ( Scanner input = new Scanner(sourceFile);
              PrintWriter output = new PrintWriter(targetFile);) {
            while (input.hasNextLine()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[2], args[3]);
                output.println(s2);
            }
        }
    }
}
*****************************************************************************************888

File file = new File("hangman.txt");

String wordss;

try(Scanner input = new Scanner(file);)
{
	while (input.hasNextLine())
	{
		 wordss = input.next();
        System.out.println(input.nextLine());
        System.out.println(wordss);
    }
}

catch (FileNotFoundException e) {
    System.err.println(e);
}
public static void pwrite() 
{
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


