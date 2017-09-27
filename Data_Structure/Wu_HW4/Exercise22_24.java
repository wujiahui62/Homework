public class Exercise22_24 {
	public static int findSmallest(int[] list){
		if(list.length == 1)
			return list[0];
		int[] list1 = new int[list.length / 2];
		System.arraycopy(list, 0, list1, 0, list.length / 2);
		
		int list2Length = list.length - list.length / 2;
		int[] list2 = new int[list2Length];
		System.arraycopy(list, list.length / 2, list2, 0, list2Length);
		return compare(findSmallest(list1), findSmallest(list2));
	}
	
	public static int compare(int a, int b){
		if(a > b)
			return b;
		else
			return a;
	}

	//Test the result
	public static void main(String[] args) {
		int[] list = new int[8];
		for(int i = 0; i < 8; i++){
			list[i] = (int)(Math.random() * 10);
		}
		
		for(int i: list)
			System.out.print(i + " ");
		int x = findSmallest(list);
		System.out.println();
		System.out.println(x);
		
	}
}
