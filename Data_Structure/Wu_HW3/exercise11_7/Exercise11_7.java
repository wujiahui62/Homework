package exercise11_7;

import java.util.ArrayList;

public class Exercise11_7 {
	public static void shuffle(ArrayList<Integer> list){
		for (int i = 0; i < list.size(); i++){
			int index = (int)(Math.random() * list.size());
			int temp = list.get(index);
			list.remove(index);
			list.add(i, temp);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		shuffle(list);
		for(int number : list)
			System.out.print(number + " ");
	}
}

