package Exercise26_5;

import java.util.Scanner;

public class TestAVLTree {
	public static void main(String[] args) {
		AVLTree<Double> tree = new AVLTree<>();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 15 numbers: ");
		for(int i = 0; i < 15; i++)
			tree.insert(input.nextDouble());
		
		System.out.print("Enter k: ");
		int k = input.nextInt();
		System.out.println("The " + k + "th smallest number is " +
		tree.find(k));
		System.out.print("The inorder of the tree is: ");
		tree.inorder();
		
		
	}
}	

/**
23 54 12 5 9 50 3 67 32 49 50 43 66 33 59
*/

