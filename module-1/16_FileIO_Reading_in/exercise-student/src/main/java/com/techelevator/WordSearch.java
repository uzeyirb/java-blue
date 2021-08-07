package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordSearch {

    public static void main(String[] args) {

        File inputFileFromUser = getInputFileFromUser();
        String wordEnteredByUser = wordToSearch();
        searchForWord(inputFileFromUser, wordEnteredByUser);

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
        System.out.println("Please enter a word to search");
        String searchWord = scanner.nextLine();

        return searchWord;

    }

    public static String searchForWord(File inputFile, String searchWord) {

<<<<<<< HEAD
=======
	  public static String searchForWord(File inputFile, String searchWord) {

>>>>>>> 2fafa5f69acc59b38cb257c3347fb49c0423aa2a
        Scanner caseSensitiveQuestion = new Scanner(System.in);
        System.out.println("Would you like your search to be case sensitive? (Y)es or (N)o ");
        String caseSensitiveOrNot = caseSensitiveQuestion.nextLine().toLowerCase().substring(0, 1);

        try (Scanner input = new Scanner(inputFile)) {
            int lineCount = 0;

            while (input.hasNextLine()) {
<<<<<<< HEAD
                String textFromFile = input.nextLine();
                lineCount++;
                Pattern pattern;
                if(caseSensitiveOrNot.equalsIgnoreCase("Y")){
                    pattern = Pattern.compile(searchWord);
                } else {
                    pattern = Pattern.compile(searchWord, Pattern.CASE_INSENSITIVE);
                }
                Matcher matcher = pattern.matcher(textFromFile);
                if(matcher.find()){
                    System.out.println((lineCount + ")" + textFromFile));
=======
                if (caseSensitiveOrNot.equalsIgnoreCase("n")) {
                    lineCount++;
                    String text = input.nextLine();
                    if (text.toLowerCase().contains(searchWord.toLowerCase(Locale.ROOT))) {
                        System.out.println(lineCount + ") " + text);
                    } else {
                    }
                } else {
                    lineCount++;
                    String text = input.nextLine();
                    if (text.contains(searchWord)) {
                        System.out.println(lineCount + ") " + text);
                    }
>>>>>>> 2fafa5f69acc59b38cb257c3347fb49c0423aa2a
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Your file doesn't exist");
        }
        return "";
    }
<<<<<<< HEAD

=======
>>>>>>> 2fafa5f69acc59b38cb257c3347fb49c0423aa2a

}