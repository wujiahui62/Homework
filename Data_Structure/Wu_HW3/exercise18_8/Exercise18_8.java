package exercise18_8;

import java.util.Scanner;
public class Exercise18_8{
	
	public static void reverseDisplay(int value){
		if(value / 10 == 0){
			System.out.print(value);;
		}
		else{
			System.out.print(value % 10);
			reverseDisplay(value / 10);
		}
	}
	
	//test the method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int value = input.nextInt();
		reverseDisplay(value);		
	}
}
