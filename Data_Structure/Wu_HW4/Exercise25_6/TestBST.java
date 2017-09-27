package Exercise25_6;

import java.util.Scanner;

public class TestBST {
	  public static void main(String[] args) {
		Integer[] numbers = new Integer[10];
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 10 distinct integer numbers: ");
		for(int i = 0; i < numbers.length; i++){
			numbers[i] = input.nextInt();
;
		}
	    BST<Integer> tree = new BST<>(numbers);
	    // Traverse tree
	    System.out.print("Inorder (sorted): ");
	    tree.inorder();
	    System.out.println();
	    System.out.print("Preorder (sorted): ");
	    tree.preorder();
	    System.out.println();
	    System.out.print("Postorder (sorted): ");
	    tree.postorder();
	    System.out.println();
	    System.out.println(tree.getNumberOfLeaves());
	  }
	}
