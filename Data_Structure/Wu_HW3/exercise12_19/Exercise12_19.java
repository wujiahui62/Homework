package exercise12_19;

import java.util.Scanner;

public class Exercise12_19 {
	public static void main(String[] args){
		String URLString = "http://cs.armstrong.edu/liang/data/Lincoln.txt";
		
		try{
			java.net.URL url = new java.net.URL(URLString);
			int count = 0;
			Scanner input = new Scanner(url.openStream()) ;
			while(input.hasNext()){
				String words = input.next();
				if((words.charAt(0) >= 'a' && words.charAt(0) <= 'z') ||
					(words.charAt(0) >= 'A' && words.charAt(0) <= 'Z'))
					count++;
			}
			input.close();

			System.out.println("The number of words is: " + count);
		}
		
		catch(java.net.MalformedURLException ex){
			System.out.println("Invalid URL");
		}
		catch(java.io.IOException ex){
			System.out.println("I/O Errors: no such file");
		}
	}
}

