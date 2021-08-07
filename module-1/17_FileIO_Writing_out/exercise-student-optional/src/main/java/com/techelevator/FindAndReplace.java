package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class FindAndReplace {

    public static void main(String[] args) {
        String wordEnteredByUser = wordToSearch();
        File inputFileFromUser = getInputFileFromUser();
        String replacementWordEnteredByUser = wordToReplace();
      //  searchForWordAndReplace(inputFileFromUser, wordEnteredByUser,  wordEnteredByUser, replacementWordEnteredByUser);

       // File outputFile = getOutputFile();

    }

    private static File getInputFileFromUser() {

        Scanner fileInput = new Scanner(System.in);
        System.out.println("What is the fully qualified name of the file that should be searched?");
        String path = fileInput.nextLine();

        File inputFile = new File(path);
        if (!inputFile.exists()) {
            System.out.println(path + " Does not exist");
            fileInput.close();

        } else if (!inputFile.isFile()) {
            System.out.println(path + " is not a file");
            fileInput.close();

        }
        return inputFile;
    }

    public static String wordToSearch() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the search word?");
        String searchWord = scanner.nextLine();

        return searchWord;

    }

    public static String wordToReplace() {


        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the replacement word??");
        String replacementWord = scanner.nextLine();

        return replacementWord;

    }
    public static String searchForWordAndReplace(File inputFile, File outputFile,  String searchWord, String replacementWordEnteredByUser) {



        try (
                Scanner dataInput = new Scanner(inputFile);
                PrintWriter dataOutput = new PrintWriter(outputFile)
        ) {
            while(dataInput.hasNext()) {
                String lineOfInput = dataInput.nextLine();
                dataOutput.println(lineOfInput.replace("mobile", "cellphone"));
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Can not open the file for writing.");
        }
        return "";
    }

}
