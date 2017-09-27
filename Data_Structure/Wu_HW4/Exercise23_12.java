import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise23_12 {
	
	public static void radixSort(int[] list, int size){
		for(int i = 1; i <= size; i *= 10){
			list = bucketSort(list, i);
		}
	}
	
	public static int[] bucketSort(int[] list, int digit){
		ArrayList[] bucket = new java.util.ArrayList[10];
		//distribute the elements from list to buckets
		for(int i = 0; i < list.length; i++){
			int key = (list[i] / digit) % 10;
			
			if(bucket[key] == null)
				bucket[key] = new java.util.ArrayList<>();
			
			bucket[key].add(list[i]);
		}
		
		//now move the elements from the buckets to the list
		int k = 0;
		for(int i = 0; i < bucket.length; i++){
			if(bucket[i] != null){
				for(int j = 0; j < bucket[i].size(); j++)
					list[k++] = (int) bucket[i].get(j);
			}
		}
		return list;
	}
		
	//Test the radix sort method
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the range of integer array: ");
		int size = input.nextInt();
		int[] list = new int[size];
		for(int i = 0; i < list.length; i++){
			list[i] = (int)(Math.random() * size);
		}
		radixSort(list, size);
		
		//print sorted data in console
		int count = 0;
		for(int i = 0; i < list.length; i++){
			count++;
			if(count % 10 != 0)
				System.out.print(list[i] + " ");
			else
				System.out.println(list[i]);
		}
		
		//write sorted data into a binary file
		try(DataOutputStream output = 
				new DataOutputStream(new BufferedOutputStream
						(new FileOutputStream("sorted data.dat")));){
			for(int i: list)
				output.writeInt(i);;
			output.close();
		}
	}
	
}
