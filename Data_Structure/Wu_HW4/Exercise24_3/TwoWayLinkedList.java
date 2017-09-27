package Exercise24_3;

import java.util.ListIterator;

import Lists.MyLinkedList.LinkedListIterator;

public class TwoWayLinkedList<E> extends java.util.AbstractSequentialList{
	private Node<E> head, tail;
	private int size = 0;
	
	public TwoWayLinkedList(){
	}
	
	public TwoWayLinkedList(E[] e){
		for(int i = 0; i < e.length; i++)
			add(e[i]);
	}
		
	public E getFirst(){
		if(size == 0)
			return null;
		else
			return head.element;
	}
	
	public E getLast(){
		if(size == 0)
			return null;
		else
			return tail.element;
	}
		
	public void addFirst(E e){
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		size++;
		
		if(tail == null)
			tail = head = newNode;
	}
	
	public void addLast(E e){
		Node<E> newNode = new Node<>(e);
		if(tail == null)
			head = tail = newNode;
		else{
			tail.next = newNode;
			newNode.previous = tail;
			tail = tail.next;
		}
		size++;
	}
	
	public E removeFirst(){
		if(size == 0)
			return null;
		else {
			Node<E> temp = head;
			head = head.next;
			head.previous = null;
			size--;
			if(head == null)
				tail = null;
			return temp.element;
		}
	}
	
	public E removeLast(){
		if(size == 0)
			return null;
		else if(size == 1){
			Node<E> temp = head;
			head = tail = null;
			size = 0;
			return temp.element;
		}
		else{
			Node<E> current = head;
        //if size == 2, for loop will not be executed, current = head
			for(int i = 0; i < size - 2; i++){
				current = current.next;
			}
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}
	
	@Override
	public E remove(int index){
		if(index == 0)
			return removeFirst();
		else if(index == size - 1)
			return removeLast();
		else if(index < 0 || index >= size)
			return null;
		else{
			Node<E> current = head;
			//Note the difference between index and size
			for(int i = 0; i  < index - 1; i++){
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = temp.next;
			(temp.next).previous = current;
			size--;
			return temp.element;
		}
	}
	
	@Override
	public String toString(){
		StringBuilder result = new StringBuilder("[");
		Node<E> current = head;
		for(int i = 0; i < size; i++){
			result.append(current.element);
			current = current.next;
			if(current != null)
				result.append(", ");
			else
				result.append("]");
		}
		return result.toString();
	}
	
	@Override
	public void clear(){
		size = 0;
		head = tail = null;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public void add(int index, E e){
		if(index == 0)
			addFirst(e);
		else if(index >= size)
			addLast(e);
		else{
			Node<E> newNode = new Node<>(e);
			Node<E> current = head;
			for(int i = 1; i < index; i++)
				current = current.next;
			Node<E> temp = current.next;
			current.next = newNode;
			newNode.previous = current;
			(current.next).next = temp;
			temp.previous = newNode;
			size++;
		}
	}
	
	public boolean contains(E e){
		Node<E> current = head;
		for(int i = 0; i < size; i++){
			if(e.equals(current.element)){
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	@Override
	public E get(int index){
		if(index < 0 || index >= size)
			return null;
		else if(index == 0)
			return getFirst();
		else if(index == size - 1)
			return getLast();
		else{
			Node<E> current = head;
			for(int i = 0; i < index; i++){
				current = current.next;
			}
			return current.element;
		}
	}
	
	public int indexOfE(E e){
		Node<E> current = head;
		for(int i = 0; i < size; i++){
			if(e.equals(current.element))
				return i;
			current = current.next;
		}
		return -1;
	}
	
	public int lastIndexOfE(E e){
		Node<E> current = tail;
		for(int i = size - 1; i >= 0; i--){
			if(e.equals(current.element))
				return i;
			current = current.previous;
		}
		return -1;
	}
	
	public E set(int index, E e){
		Node<E> newNode = new Node<E>(e);
		if(index < 0 || index >= size)
			return null;
		else if(index == 0 && size == 1){
			head = tail = newNode;
			return newNode.element;
		}
		else if(index == 0){
			Node<E> temp = head.next;
			head = newNode;
			head.next = temp;
			temp.previous = head;
			return newNode.element;
		}
		else if(index == size - 1){
			Node<E> temp = tail.previous;
			tail = newNode;
			tail.previous = temp;
			temp.next = tail;
			return newNode.element;
		}
		else{
			Node<E> current = head;
			for(int i = 1; i < index; i++)
				current = current.next;
			Node<E> temp = (current.next).next;
			current.next = newNode;
			newNode.previous = current;
			(current.next).next = temp;
			temp.previous = newNode;
			return newNode.element;
		}
	}
	
	@Override
	public ListIterator<E> listIterator(){
		return new LinkedListIterator();
	}
	
	@Override
	public ListIterator<E> listIterator(int index) {
		LinkedListIterator iterator = new LinkedListIterator();
		for(int i = 0; i < index; i++){
			iterator.next();
		}
		return iterator;
	}
	
	private class LinkedListIterator implements java.util.ListIterator<E> {
		private Node<E> current = head; // Current index
	
		@Override
		public boolean hasNext() {
			return (current != null);
		}
	 
		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			return e;
		}
		
		public boolean hasPrevious(){
			return (current.previous != null);
		}
		
		public E previous(){
			E e = current.element;
			current = current.previous;
			return e;
		}
			
		@Override
		public void remove() {
			(current.previous).next = current.next;
			(current.next).previous = current.previous;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void set(E e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void add(E e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public class Node<E>{
		E element;
		Node<E> next;
		Node<E> previous;
		
		public Node(E e){
			this.element = e;
		}
	}
}
