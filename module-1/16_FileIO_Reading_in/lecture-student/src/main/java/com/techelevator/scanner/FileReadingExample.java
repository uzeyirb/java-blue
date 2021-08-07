package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadingExample {
    public static void main(String[] args) {
        //Step 1: Path to the file
        String pathToFile = "C:\\Users\\Student\\source\\repos\\uzeyirbaghirov-java-blue\\module-1\\16_FileIO_Reading_in\\lecture-student\\Dracula.txt";

        //Step 2: Create a File object to reference the file

        // Can use the file object to check if the File exists and if it is a File or a directory

        File file = new File(pathToFile);
        if(!file.exists()){
            System.out.println("The file doesn't exist");
        }
        if(!file.isFile()){
            System.out.println("This is not a file");
        }
        //Step 3: Create a Scanner and pass if the file object
        //With the file object scanner has a checked FileNotFoundException
        //With a file object, scanner must be closed!
        //Put Scanner in the try-with resources, which will automatically close the connection

        try(Scanner fileScanner = new Scanner(file)) {
            //Loop while hasNextLine() is true, because hasNextLine() will be true when there is more left and
            // false when we are at the end
            while(fileScanner.hasNextLine()){
                //Read the next line
                String lineFromTheBook = fileScanner.nextLine();
                System.out.println(lineFromTheBook);
            }

        }catch (FileNotFoundException e){

        }

    }
}
