package Exercise23_5;

import java.util.Comparator;

public class HeapComparator<E>{
	
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();
	private Comparator<? super E> comparator;
	
	public HeapComparator(E[] elements){
		for(int i = 0; i < elements.length; i++)
			add(elements[i]);
	}
	
	public HeapComparator(Comparator<? super E> comparator){
		this.comparator = comparator;
	}
	
	public void add(E newElement){
		list.add(newElement);
		int currentIndex = list.size() - 1;
		
		while(currentIndex > 0){
			int parentIndex = (currentIndex - 1) / 2;
			if(comparator.compare(list.get(currentIndex), list.get(parentIndex)) > 0){
				E temp = list.get(currentIndex);
				list.set(currentIndex, list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else
				break;
			
			currentIndex = parentIndex;
		}
	}
	
	public E remove(){
		if(list.size() == 0)
			return null;
		E removedElement = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		int currentIndex = 0;
		while(currentIndex < list.size()){
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			
			if(leftChildIndex >= list.size())
				break;
			int maxIndex = leftChildIndex;
			if(rightChildIndex < list.size()){
				if(comparator.compare(list.get(maxIndex), list.get(rightChildIndex)) < 0)
					maxIndex = rightChildIndex;
			}
			if(comparator.compare(list.get(currentIndex), list.get(maxIndex)) < 0){
				E temp = list.get(maxIndex);
				list.set(maxIndex,  list.get(currentIndex));
				list.set(currentIndex, temp);
				currentIndex = maxIndex;
			}
			else
				break;
		}
		return removedElement;

	}
	
	public int getSize(){
		return list.size();
	}
		
}