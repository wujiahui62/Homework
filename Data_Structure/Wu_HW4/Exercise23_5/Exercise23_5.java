package Exercise23_5;

import java.util.Comparator;

public class Exercise23_5 {
	public static <E extends Comparable<E>> void heapSort1(E[] list){
		HeapComparable<E> heapComparable = new HeapComparable<>();
		for(int i = 0; i < list.length; i++){
			heapComparable.add(list[i]);
		}
		
		for(int i = list.length - 1; i >= 0; i--){
			list[i] = heapComparable.remove();
		}
		
	}
	
	public static <E> void heapSort2(E[] list, Comparator<? super E> comparator) {
		HeapComparator<E> heapComparator = new HeapComparator<>(comparator);

		for (int i = 0; i < list.length; i++)
			heapComparator.add(list[i]);

		for (int i = list.length - 1; i >= 0; i--)
			list[i] = (E) heapComparator.remove();
	}
		
	public static void main(String[] args){
		Integer[] list1 = {23, 43, 54, 65, 2, 76, 9, 7, 45, 8, 3, 0};
		heapSort1(list1);
		System.out.print("heap sort using comparable: ");
		for(Integer i: list1)
			System.out.print(i + " ");
		
		System.out.println();
		
		Integer[] list2 = {23, 43, 54, 65, 2, 76, 9, 7, 45, 8, 3, 0};
		heapSort2(list2, new IntegerComparator());
		System.out.print("heap sort using comparator: ");
		for(Integer i: list2)
			System.out.print(i + " ");

	}
}
