package exercise18_11;

import java.util.Scanner;

public class Exercise18_11 {
	public static int sumDigits(long n){
		if(n / 10  == 0)
			return (int)n;
		else
			return sumDigits(n / 10) + (int)(n % 10);
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		long number = input.nextLong();
		System.out.println("The sum of the digits are: " + sumDigits(number));
	}
}
