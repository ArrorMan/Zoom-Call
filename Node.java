/**
 * Course: 		CS300 - Summer 2020
 * Program:		Program 7 Zoom Call
 * Name: 		<Jiangang Chen>
 * Wisc Email: 		<jchen747@wisc.edu>
 * Web Sources: 		<None>
 * Personal Help: 	<None>
 */

/**
 * A class that represents a generic node in a linked list
 * @author Andy Kuemmel, CS300
 * @param <T> the generic type of the data held by the Node
 */

import java.util.Iterator;

public class Node<T> {
	private T data;	  // the data object stored by Nodes
	private Node<T> next; // a reference to the next node in the sequence
	
	/**
	 * constructs a Node with a next field as input
	 * @param data the data object stored by this node
	 * @param next a reference to the next Node after this node
	 */
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	/**
	 * constructs a Node with a next field of null
	 * @param data the data object stored by this node
	 */
	public Node(T data) {
		this(data, null);
	}
	
	/**
	 * @return the value of the data object
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the new value of the data object
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * @return a reference to next node object after this node
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next a reference to the node object that comes after this
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

//	@Override
//	public String toString() {
//		return this.getData() + "";
//	}
	
	//public static void main(String[] args) {
		// General initialize
//		ZoomParticipant A = new ZoomParticipant("A");
//		ZoomParticipant B = new ZoomParticipant("B");
//		ZoomParticipant C = new ZoomParticipant("C");
//		ZoomParticipant D = new ZoomParticipant("D");
//		Node nA = new Node(A);
//		Node nB = new Node(B);
//		Node nC = new Node(C);
//		Node nD = new Node(D);
		
		// Node test
//		System.out.println(nA.getData());
//		nA.setNext(nB);
//		System.out.println(nB.getNext());
		
		// LinkedList test
//		LinkedList list1 = new LinkedList();
//		list1.addAtEnd(nA);
//		list1.addAtEnd(nB);
//		list1.addAtEnd(nC);
//		list1.print();
//		list1.add(2, nD);
//		list1.add(2, nA);
//		list1.print();
//		//list1.removeFromFront();
//		list1.remove(0);
//		list1.remove(0);
//		list1.remove(0);
//		list1.remove(0);
//		list1.remove(0);
//		list1.print();
		
		// LinkedListIterator Test
//		LinkedList list1 = new LinkedList();
//		list1.addAtEnd(nA);
//		list1.addAtEnd(nB);
//		list1.addAtEnd(nC);
//		list1.addAtEnd(nC);
//		list1.addAtEnd(nC);
//		list1.addAtEnd(nC);
//		//list1.print();
//		Iterator listIterator = new LinkedListIterator(list1.getNode(0));		
//		while(listIterator.hasNext()) {
//			System.out.println(listIterator.next());
//		}
		
		// BreakoutRoom Test
//		BreakoutRoom test = new BreakoutRoom("TestRoom");
//		ZoomParticipant A = new ZoomParticipant("A");
//		ZoomParticipant B = new ZoomParticipant("B");
//		ZoomParticipant C = new ZoomParticipant("C");
//		ZoomParticipant D = new ZoomParticipant("D");
//		test.addToRoom(A);
//		test.addToRoom(B);
//		test.addToRoom(C);
//		System.out.println(test.getSize());
//		test.removeFromRoom(1);
//		test.printBreakoutRoom();
		
		
		// ZoomCall Test
//		ZoomCall test = new ZoomCall("TestRoom");
//		test.addToCall("A");
//		test.addToCall("B");
//		test.addToCall("C");
//		//System.out.println(test.getMainRoomSize());
//		test.unMuteAll();
//		test.printMainRoom();
//		System.out.println(test.dropFromCall(2));
//		test.muteAll();
//		test.changeName(1, "ABC");
//		test.printMainRoom();
		
		// Breakout Test
//		ZoomCall test = new ZoomCall("TestRoom");
//		test.addToCall("A");
//		test.addToCall("B");
//		test.addToCall("C");
//		test.addToCall("D");
//		test.addToCall("A");
//		test.addToCall("B");
//		test.addToCall("C");
//		test.addToCall("D");
//
//		test.printMainRoom();
		
		//test.unMuteAll();
		//test.printMainRoom();
		//test.muteAll();
		//test.printMainRoom();
		//System.out.println("ZoomCall size: " + test.getMainRoomSize());
		
//		test.startBreakoutRooms(2);
//		System.out.println("main");
//		test.printMainRoom();
//		System.out.println("break");
//		test.printBreakoutRooms();
//		System.out.println("getNumBreakoutRooms: " + test.getNumBreakoutRooms());
//		test.endBreakoutRooms();
////		System.out.println("break1");
////		test.printBreakoutRooms();
//		System.out.println("main1---|");
//		test.printMainRoom();
		
		//System.out.println(test.dropFromCall(8, 0));
		//test.changeRooms(7, 0, 8);
		//test.printBreakoutRooms();
	//} // main
	
}
