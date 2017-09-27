package exercise18_10;

import java.util.Scanner;
public class Exercise18_10 {
	public static int count(String str, char a){
		if(str.indexOf(a) >= 0)
			return count(str.substring(str.indexOf(a) + 1), a) + 1;
		else
			return 0;
	}
	
	//test the method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = input.nextLine();
		System.out.println("Enter a character: ");
		char a = input.nextLine().charAt(0);
		System.out.println("The number of occurrences for " 
		+ a + " is " + count(str, a));
	}
}
