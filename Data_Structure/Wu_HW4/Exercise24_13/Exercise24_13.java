package Exercise24_13;

import java.util.Iterator;
import java.util.Scanner;

public class Exercise24_13 {	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the maximum limit of fibonacci: ");
		int number = input.nextInt();
		FibonacciIterator fib = new FibonacciIterator(number);
		Iterator iterator = fib.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}
	}
}