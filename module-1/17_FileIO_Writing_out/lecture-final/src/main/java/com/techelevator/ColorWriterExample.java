package com.techelevator;

import java.io.*;

public class ColorWriterExample {

    /*
    Set a Path to write the colors and numbers to
     */
    private final static String FILE_NAME = "";
    private final static int UPPER_LIMIT = 200;

    public static void main(String[] args) throws IOException {

        String pathToFile = "C:\\Users\\Student\\source\\repos\\java-blue-main\\module-1\\17_FileIO_Writing_out\\lecture-final\\colors.txt";
        File file = new File( pathToFile );


        try (PrintWriter printWriter = new PrintWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(printWriter)) {

            for (int i = 1; i <= UPPER_LIMIT; i++) {
                //System.out.println(getOutput(i));
                bufferedWriter.write(getOutput(i));
                bufferedWriter.newLine();
            }

        }



        System.out.println("DONE!");
    }


    private static String getOutput(int i) {

        String output = String.valueOf(i);

        if (i % 5 == 0) {
            output = "RED";
        } else if (i % 7 == 0) {
            output = "BLUE";
        } else if (i % 9 == 0) {
            output = "GREEN";
        }

        return output;
    }
}
