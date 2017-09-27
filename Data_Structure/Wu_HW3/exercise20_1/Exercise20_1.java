package exercise20_1;

import java.util.*;
import java.io.*;

public class Exercise20_1{
	public static void main(String[] args) throws Exception{
		if(args.length != 1){
			System.out.println("Usage: java Exercise20_1 fileName");
			System.exit(1);
		}
		
		File file = new File(args[0]);
		if(!file.exists()){
			System.out.println("Source file " + args[0] + " does not exit");
			System.exit(2);
		}
		
		try(Scanner input = new Scanner(file);){
			List <String> list = new ArrayList<>();
			while(input.hasNext()){
				String word = input.next();
				if((word.charAt(0) >= 'a' && word.charAt(0) <= 'z') ||
						(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'))
				list.add(word.toLowerCase());
			}
			
			Collections.sort(list);
			for(String words: list)
				System.out.print(words + " ");
		}
	}
}
