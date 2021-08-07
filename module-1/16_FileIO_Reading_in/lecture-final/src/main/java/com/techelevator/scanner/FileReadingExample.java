package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadingExample {
    public static void main(String[] args) {

        // Step 1: Path to the file
        String pathToFile = "C:\\Users\\Student\\source\\repos\\java-blue-main\\module-1\\16_FileIO_Reading_in\\lecture-final\\Dracula.txt";

        // Step 2: Create a File object to reference the file
        File file = new File(pathToFile);

        // Can use the file object to check if the File exists and if it is a File or a directory
        if (!file.exists()) {
            System.out.println("The file doesn't exist");
        }
        if (!file.isFile()) {
            System.out.println("This is not a file");
        }
        // Step 3: Create a Scanner and pass it the File object
        // With a file object, scanner has a checked FileNotFoundException
        // With a file object, scanner MUST be closed!
        // Put the Scanner in a try-with-resource, which will automatically close the connection
        try (Scanner fileScanner = new Scanner( file )) {
            // Loop while hasNextLine() is true, because hasNextLine() will be true when there is more left and
            // false when we are at the end
            while( fileScanner.hasNextLine() ) {
                // Read the next line
                String lineFromTheBook = fileScanner.nextLine();
                System.out.println(lineFromTheBook);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The File was not found");
        }

    }
}
