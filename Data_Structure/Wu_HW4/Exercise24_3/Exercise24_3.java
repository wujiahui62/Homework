package Exercise24_3;

import java.util.ListIterator;

public class Exercise24_3 {
	public static void main(String[] args) {
		TwoWayLinkedList <String> list = new TwoWayLinkedList<>();
		list.add("London");
		System.out.println("(1)" + list);
		list.add("Shanghai");
		System.out.println("(2)" + list);
		list.addFirst("Beijing");
		System.out.println("(3)" + list);
		list.addLast("New York");
		System.out.println("(4)" + list);
		list.set(2, "DC");
		System.out.println("(5)" + list);
		System.out.println("(6)" + list.getFirst());
		System.out.println("(7)" + list.getLast());
		System.out.println("(8)" + list.contains("London"));
		System.out.println("(9)" + list.contains("Boston"));
		list.add(3, "Paris");
		System.out.println("(10)" + list);
		System.out.println("(11)" + list.get(0));
		
		ListIterator<String> iterator = list.listIterator();
		System.out.print("(12)");
		while(iterator.hasNext())
			System.out.print(iterator.next() + " ");
	}
}
