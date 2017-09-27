package exercise12_22;

import java.io.*;
import java.util.*;

public class Exercise12_22 {
	public static void main(String[] args) throws Exception {
		if (args.length != 3) {
			System.out.println("Usage: java Exercise12_22 dir oldString newString");
			System.exit(1);
		}

		File dir = new File(args[0]);
		if (!dir.exists()) {
			System.out.println("directory " + args[0] + " does not exist");
			System.exit(2);
		} else if (!dir.isDirectory()) {
			System.out.println(args[0] + " is not direcotry");
			System.exit(3);
		}

		File[] files = new File[dir.listFiles().length];
		files = dir.listFiles();

		// get filenames and extensions of each file
		String[] fileNames = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			fileNames[i] = files[i].getName();
		}

		String[] extensions = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			int j = fileNames[i].lastIndexOf('.');
			if (j > 0)
				extensions[i] = fileNames[i].substring(j + 1);
		}

		// copy the content from files to fileCopies
		File[] fileCopies = new File[files.length];

		for (int i = 0; i < files.length; i++) {
			fileCopies[i] = new File("copy" + i + "." + extensions[i]);
			try (Scanner input = new Scanner(files[i]); PrintWriter output = new PrintWriter(fileCopies[i]);) {
				while (input.hasNextLine()) {
					String s1 = input.nextLine();
					output.println(s1);
				}
			}
		}

		// replace the oldString in the fileCopies with newString and re-write
		// into the original files
		for (int i = 0; i < files.length; i++) {
			try (Scanner input2 = new Scanner(fileCopies[i]); PrintWriter output2 = new PrintWriter(files[i]);) {
				while (input2.hasNext()) {
					String s2 = input2.nextLine();
					String s3 = s2.replaceAll(args[1], args[2]);
					output2.println(s3);
				}
			}
		}
		
//		//delete fleCopies
	    for (int i = 0; i < files.length; i++){
		    fileCopies[i].delete();
	    }
	}
}

