package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileLecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */
		File file = new File("C:\\Users\\Student\\source\\repos\\java-blue-main\\module-1\\17_FileIO_Writing_out\\lecture-final\\Dracula.txt");

		System.out.println( file.length());
		System.out.println( file.canRead());
		System.out.println( file.getAbsolutePath());
		System.out.println( file.getName());

		String newDir = "C:\\Users\\Student\\source\\repos\\java-blue-main\\module-1" +
				"\\17_FileIO_Writing_out\\lecture-final\\testdir";

		File newDirFileObj = new File(newDir);

		newDirFileObj.mkdir();

		String newFile = newDir + "\\testfile.txt";

		File newFileFileObj = new File(newFile);
		newFileFileObj.createNewFile();

		try (PrintWriter writer = new PrintWriter(newFileFileObj)) {
			writer.println("First line written to a file");
		}

	}

}
