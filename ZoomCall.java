/**
 * Course: 		CS300 - Summer 2020
 * Program:		Program 7 Zoom Call
 * Name: 		<Jiangang Chen>
 * Wisc Email: 		<jchen747@wisc.edu>
 * Web Sources: 		<None>
 * Personal Help: 	<None>
 */

import java.util.Iterator;
// Class header  and some javadocs missing due to space restrictions
public class ZoomCall {
	private String callName;		// the name of the call 
	private LinkedList<ZoomParticipant> mainRoomList;  // the list of participants
	private boolean inBreakoutMode; // states if we are currently in breakout mode
	private BreakoutRoom [] breakoutRooms; // an array of breakout rooms
	
	// constructor
	public ZoomCall(String callName) { 
		this.callName = callName;
		this.mainRoomList = new LinkedList<>();
		this.inBreakoutMode = false;
	}

	/**
	 * @return the number of participants in mainRoomList (do not include moderator)
	 */
	public int getMainRoomSize() {	
		return this.mainRoomList.size();
	}

	/**
	 * instantiates a ZoomParticipant, muted, and adds at end of mainRoomList
	 * @param name
	 */
	public void addToCall(String name) { 
		ZoomParticipant person = new ZoomParticipant(name);
		this.mainRoomList.addAtEnd(person);
	}
	
	/**
	 * overloaded method to call when using main room
	 * if the call is in breakout room, return null
	 * @param index
	 * @return the ZoomParticipant at this index in mainRoomList
	 * @throws IllegalArgumentException if index is out of range
	 */
	public ZoomParticipant dropFromCall(int index) throws IllegalArgumentException{
		if ((index < 0) || (index >= this.mainRoomList.size())) {
			throw new IllegalArgumentException("index " + index + " is not valid"); // TODO be careful with this place
		}else {
			if (this.inBreakoutMode) {
				return null;
			}else {
				return this.mainRoomList.remove(index);
			}
		}
	}
	
	/**
	 * sets the ZoomParticipant at index in the main room to muted
	 * @param index
	 * @throws IllegalArgumentException if index is out of range
	 */
	public void mute(int index) throws IllegalArgumentException { 
		if ((index < 0) || (index >= getMainRoomSize())) {
			throw new IllegalArgumentException("index " + index + " is not valid");
		}
		this.mainRoomList.get(index).setMuted(true);
	}
	
	// uses an iterator to mute all participants in the main room (WE WILL CHECK)
	public void muteAll() { 
		Iterator<ZoomParticipant> muteOfAll = this.mainRoomList.iterator();
		while(muteOfAll.hasNext()) {
			muteOfAll.next().setMuted(true);
		}
	}
	
	// uses an iterator to unmute all participants in the main room (WE WILL CHECK)
	public void unMuteAll() {
		Iterator<ZoomParticipant> unMuteOfAll = this.mainRoomList.iterator();
		while(unMuteOfAll.hasNext()) {
			unMuteOfAll.next().setMuted(false);
		}
	}

	/**
	 * if inBreakoutMode, do nothing, otherwise change the name
	 * @param index the index of the participant in the mainRoom
	 * @param newName the new name for this participant
	 * @throws IllegalArgumentException if index is out of range
	 */
	public void changeName(int index, String newName) throws IllegalArgumentException{
		if ((index < 0) || (index >= getMainRoomSize())) {
			throw new IllegalArgumentException("index " + index + " is not valid");
		}
		if (!this.inBreakoutMode) {
			this.mainRoomList.get(index).setName(newName);
		}else {
		}
	}
	
	// prints the participants in the main room
	public void printMainRoom() {
		System.out.println("\n" + this.callName + " Main Room:");
		this.mainRoomList.print();
	}
	
	/**
	 * starts breakout rooms and places participants one at a time into a room
	 * pattern: room 0, room 1, room 2, room 0, room 1, room 2
	 * sets inBreakoutMode to true
	 * when added to a breakout room, unmute a participant and remove it from the main room
	 * @param numRooms
	 * @throws IllegalArgumentException if numRooms is <= 0
	 */
	public void startBreakoutRooms(int numRooms) throws IllegalArgumentException { 
		if (numRooms <= 0) {
			throw new IllegalArgumentException();
		}
		this.breakoutRooms = new BreakoutRoom[numRooms];
		this.inBreakoutMode = true;
		System.out.println();
		System.out.println("CS 300 Breakout Rooms:");
		for (int i = 0; i < numRooms; ++i) { // initialize the BreakoutRoom
			BreakoutRoom newRoom = new BreakoutRoom("Room " + i);
			this.breakoutRooms[i] = newRoom;
		}
		while (this.mainRoomList.size() > 0) {
			if (this.mainRoomList.size() < numRooms) { // if there breakout room size is 
													   // greater than mainroomList size
				numRooms = this.mainRoomList.size();
			}
			for (int i = 0; i < numRooms; ++i) {
				if (this.mainRoomList.get(0) != null) {
					this.mainRoomList.get(0).setMuted(false);
					this.breakoutRooms[i].addToRoom(this.mainRoomList.get(0));
					this.mainRoomList.removeFromFront();
				}
			}
		} // while
	}

	/**
	 * if there are no breakout rooms, return 0
	 * @return the number of current breakout rooms
	 */
	public int getNumBreakoutRooms() { 
		if(this.inBreakoutMode) {
			return this.breakoutRooms.length;
		}else {
			return 0;
		}
	}

	/**
	 * sets the value of inBreakoutMode to false
	 * removes participants from each room, one room at a time,
	 * mutes each participant, and adds them to main room
	 * sets the array this.breakoutRooms to null
	 */
	public void endBreakoutRooms() {
		ZoomParticipant elementToRemove;
		int num = this.getNumBreakoutRooms();
		this.inBreakoutMode = false;
		for (int i = 0; i < num; ++i) {
			if (this.breakoutRooms[i].getSize() != 0) {
				for (int j = 0; j < this.breakoutRooms[i].getSize(); ++j) { // <= is print all, < miss one
					elementToRemove = this.breakoutRooms[i].removeFromRoom(0);
					elementToRemove.setMuted(true);
					this.mainRoomList.addAtEnd(elementToRemove);
					--j;
				}
			}
		}
		this.breakoutRooms = null;
	}

	/**
	 * overloaded method to call when using breakout rooms
	 * if the call is not in breakout mode, return null
	 * @param room the room number
	 * @param index the index of the person in the room
	 * @return the ZoomParticipant at this index in mainRoomList
	 * @throws IllegalArgumentException if index is out of range OR room is out of range
	 */
	public ZoomParticipant dropFromCall(int room, int index) throws IllegalArgumentException{
		if ((room < 0) || (room >= getNumBreakoutRooms())) {
			throw new IllegalArgumentException("room " + room + " is not valid");
		}
		if ((index < 0) || (index >= this.breakoutRooms[room].getSize())) {
			throw new IllegalArgumentException("index " + index + " is not valid");
		}
		ZoomParticipant removeElement;
		removeElement = this.breakoutRooms[room].removeFromRoom(index);
		if (this.inBreakoutMode) {
			System.out.println();
			System.out.println("CS 300 Breakout Rooms:");
			return removeElement;
		}else {
			return null;
		}
	}

	/**
	 * moves a participant from one room to another
	 * if not in breakoutMode, do nothing
	 * @param roomNumber the original room
	 * @param indexNumber the index of this participant in the breakout room
	 * @param newRoomNumber the new room
	 * @throws IndexOutOfBoundsException if any parameter is out of bounds
	 */
	public void changeRooms(int roomNumber, int indexNumber, int newRoomNumber) 
			throws IndexOutOfBoundsException{
		// TODO: COMPLETE THIS METHOD
		if ((roomNumber < 0) || (roomNumber >= getNumBreakoutRooms()) 
				|| (indexNumber < 0) || (indexNumber >= this.breakoutRooms[roomNumber].getSize()) 
				|| (newRoomNumber < 0) || (newRoomNumber >= getNumBreakoutRooms())) {
			throw new IndexOutOfBoundsException();
		}
		ZoomParticipant removeElement;
		if (this.inBreakoutMode) {
			System.out.println();
			System.out.println("CS 300 Breakout Rooms:");
			removeElement = this.breakoutRooms[roomNumber].removeFromRoom(indexNumber);
			this.breakoutRooms[newRoomNumber].addToRoom(removeElement);
		}
	}
	
	/**
	 * prints out each room and the participants..
	 */
	public void printBreakoutRooms() {
		if (this.inBreakoutMode) {
			for (int i = 0; i < getNumBreakoutRooms(); ++i) {
				this.breakoutRooms[i].printBreakoutRoom();
			}
		}
	}

}