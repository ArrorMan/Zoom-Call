/**
 * Course: 		CS300 - Summer 2020
 * Program:		Program 7 Zoom Call
 * Name: 		<Jiangang Chen>
 * Wisc Email: 		<jchen747@wisc.edu>
 * Web Sources: 		<None>
 * Personal Help: 	<None>
 */

import java.util.Iterator;

public class LinkedList<T> implements ListADT<T>, Iterable<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;

    // Constructor 
	public LinkedList () {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	// TODO check if needed to add more constructor
	public LinkedList (Node<T> head, Node<T>tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}
	
	@Override
	/**
	 * return a new Iterator object
	 */
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>(this.head);
	}
	
    // Methods that are required for ListADT
	
	@Override
	/** assume T is not null, do not need to throw an Exception
	 * adds element of type T at the end of the list
	 * @param element the object to be added
	 */
	public void addAtEnd(T element) {
		Node<T> newElement = new Node<T>(element);
		if (this.head == null) {
			this.head = newElement;
			this.tail = newElement;
			++this.size;
		}else {
			this.tail.setNext(newElement);
			this.tail = newElement;
			++this.size;
		}
	}
	
	@Override
	/** assume T is not null, do not need to throw an Exception
	 * adds element at given index position, subsequent elements moved down
	 * @param index the index of the new object
	 * @param element
	 * @throws IndexOutOfBoundsTxception if index < 0 or index > size
	 */
	public void add(int index, T element) throws IndexOutOfBoundsException {
		if ((index < 0) || (index > this.size)) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> newElement = new Node<T>(element);
		Node<T> originalElement = null;
		Node<T> originalElementBefore = null;
		if (index == 0) { // add at the head
			originalElement = this.head;
			this.head = newElement;
			this.head.setNext(originalElement);
		}else if (index == this.size) { // add at the tail
			this.tail.setNext(newElement);
			this.tail = newElement;
		}else { // add at middle
			originalElementBefore = getNode(index - 1);
			originalElement = getNode(index);
			originalElementBefore.setNext(newElement);
			newElement.setNext(originalElement);
		}
		++this.size;
	}
	
	@Override
	/**
	 * @return the number of elements in the list
	 */
	public int size() {
		return this.size;
	}
	
	@Override
	/**
	 * This method removes the element from the list that has 
	 * the given index and returns it
	 * @param index
	 * @return the removed item 
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public T remove(int index) throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= this.size)) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> originalElement = null;
		Node<T> originalElementBefore = null;
		Node<T> originalElementAfter = null;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
			return null;
		}else {
			if (index == 0) {
				originalElement = this.head;
				this.head = getNode(1);
			}else if (index == this.size -1) {
				originalElement = this.tail;
				this.tail = getNode(index - 1);
			}else {
				originalElement = getNode(index);
				originalElementBefore = getNode(index - 1);
				originalElementAfter = getNode(index + 1);
				originalElementBefore.setNext(originalElementAfter);
			}
			--this.size;
			return originalElement.getData();
		}
	}
	
	@Override
	/**
	 * This method removes the node at the front of this list and returns it
	 * @return the object in the node at the front, null if the list is empty
	 */
	public T removeFromFront() {
		if (this.size == 0) {
			return null;
		} else if (this.size == 1) { // if only left one element
			Node<T> originalElement1 = null;
			originalElement1 = this.head;
			this.head = null;
			this.tail = null;
			this.size = 0;
			return originalElement1.getData();
		} else { // if left more than one element
			Node<T> originalElement = null;
			originalElement = this.head;
			this.head = getNode(1);
			--this.size;
			return originalElement.getData();
		}
	}
	
	@Override
	/** you may find this method very useful, so its being added to the ADT
	 * @param index
	 * @return the element of the list at the given index    
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public T get(int index) throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= this.size)) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> curElement = this.head; // avoid null initialization
		for (int i = 0; i <= index; ++i) {
			if(i == 0) {
				curElement = this.head;
			}else {
				curElement = curElement.getNext();
			}
		}
		return curElement.getData();
	}
	
	/** Same code as get() method, but just return Node<T> type rather than T type
	 * @param index
	 * @return the node of the list at the given index    
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public Node<T> getNode(int index) throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= this.size)) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> curElement = this.head; // avoid null initialization
		for (int i = 0; i <= index; ++i) {
			if(i == 0) {
				curElement = this.head;
			}else {
				curElement = curElement.getNext();
			}
		}
		return curElement;
	}
	
	/**
	 * prints out a representation of the list using sample output as a guide
	 * get(i) return T type rather than ZoomParticipant type
	 */
	public void print() {
		// TODO: IMPLEMENT USING THE SAMPLE OUTPUT AS A GUIDE
		System.out.print("Size: " + this.size + " Contents: ");
		for (int i = 0; i < this.size; ++i) {
			System.out.print(get(i) + ", ");
		}
		System.out.println();
	}
	
}