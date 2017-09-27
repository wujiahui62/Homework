package exercise19_7;

public class Exercise19_7 {
	public static<E extends Comparable<E>> int binarySearch(E[] list, E key){
		int low = 0;
		int high = list.length - 1;
		while(high >= low){
			int mid = (low + high) / 2;
			if(key.compareTo(list[mid]) < 0)
				high = mid - 1;
			else if(key.compareTo(list[mid]) == 0)
				return mid;
			else
				low = mid + 1;
		}
		return - low - 1;
	}
	
	//Test the method
	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5};
		System.out.println(binarySearch(intArray, 4));
		System.out.println(binarySearch(intArray, 6));
		
		Character[] charArray = {'a', 'b', 'c', 'd', 'e'};
		System.out.println(binarySearch(charArray, 'a'));
		System.out.println(binarySearch(charArray, 'z'));
		
		String[] stringArray = {"Anna", "Frank", "Lee", "Zack"};
		System.out.println(binarySearch(stringArray, "Lee"));
		System.out.println(binarySearch(stringArray, "Evan"));
	}		
}
