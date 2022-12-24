
import java.io.File;
import java.util.Date;

public class File1 {

    public static void main(String[] args) {
    	// file object either reprsents the directory or file

        File currentDir = new File("."); // "" === "."
        System.out.println("Current directory is " + currentDir.getAbsolutePath());

        File directory = new File("src/File1.java");
        System.out.println("Does the directory exist? " + directory.exists());
        System.out.println("The directory has " + directory.length() + " Bytes");
        System.out.println("Is the directory a directory in the system? " + directory.isDirectory());
        System.out.println("Is the directory a file in the system? " + directory.isFile());

        System.out.println("\n********************************\n");

        File file = new File("src/w2p2.java");
        System.out.println("Does the file exist? " + file.exists());
        System.out.println("The file has " + file.length() + " Bytes");
        System.out.println("Is the file a directory in the system? " + file.isDirectory());
        System.out.println("Is the file a file in the system? " + file.isFile());

        File fileFlag = new File("src/bank.java");
        System.out.println("Does it exist? " + fileFlag.exists());
        System.out.println("The file has " + fileFlag.length() + " Bytes");
        System.out.println("The file has " + Math.round(fileFlag.length() / 1024.0) + " KB");

        System.out.println("Can it be read? " + fileFlag.canRead());
        System.out.println("Can it be written? " + fileFlag.canWrite());
        System.out.println("Is it a directory? " + fileFlag.isDirectory());
        System.out.println("Is it a file? " + fileFlag.isFile());
        System.out.println("Is it absolute? " + fileFlag.isAbsolute());
        System.out.println("Is it hidden? " + fileFlag.isHidden());
        System.out.println("Absolute path is " + fileFlag.getAbsolutePath());
        System.out.println("Last modified on " + new Date(fileFlag.lastModified()));
    }
}

