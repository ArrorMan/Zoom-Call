/**
 * Course: 		CS300 - Summer 2020
 * Program:		Program 7 Zoom Call
 * Name: 		<Jiangang Chen>
 * Wisc Email: 		<jchen747@wisc.edu>
 * Web Sources: 		<None>
 * Personal Help: 	<None>
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {
	private Node<T> curElement;
	
	public LinkedListIterator(Node<T> head){
		this.curElement = head;
	}
	
	@Override
	public boolean hasNext(){
		return (this.curElement != null);
	}
	
	@Override
	public T next() throws NoSuchElementException {
		if(! hasNext()) {
			throw new NoSuchElementException();
		}
		T data = this.curElement.getData();
		this.curElement = this.curElement.getNext();
		return data;
	}
	
}// class
