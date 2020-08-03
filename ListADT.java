/**
 * Course: 		CS300 - Summer 2020
 * Program:		Program 7 Zoom Call
 * Name: 		<Jiangang Chen>
 * Wisc Email: 		<jchen747@wisc.edu>
 * Web Sources: 		<None>
 * Personal Help: 	<None>
 */

/**
 * Describes a Generic Abstract Data Type
 * @author Andy Kuemmel, CS 300
 * @param <T> represents the Type of the elements of the list
 */
interface ListADT<T>{
	/** assume T is not null, do not need to throw an Exception
	 * adds element of type T at the end of the list
	 * @param element the object to be added
	 */
	public void addAtEnd(T element);
	
	/** assume T is not null, do not need to throw an Exception
	 * adds element at given index position, subsequent elements moved down
	 * @param index the index of the new object
	 * @param element
	 * @throws IndexOutOfBoundsTxception if index < 0 or index > size
	 */
	public void add(int index, T element) throws IndexOutOfBoundsException;  
		
	/**
	 * @return the number of elements in the list
	 */
	public int size(); 
	

	/**
	 * This method removes the element from the list that has 
	 * the given index and returns it
	 * @param index
	 * @return the removed item 
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public T remove(int index) throws IndexOutOfBoundsException; 
	
	/**
	 * This method removes the node at the front of this list and returns it
	 * @return the object in the node at the front, null if the list is empty
	 */
	public T removeFromFront();

	/** you may find this method very useful, so its being added to the ADT
	 * @param index
	 * @return the element of the list at the given index    
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size
	 */
	public T get(int index) throws IndexOutOfBoundsException; 

}
