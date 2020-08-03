/**
 * Course: 		CS300 - Summer 2020
 * Program:		Program 7 Zoom Call
 * Name: 		<Jiangang Chen>
 * Wisc Email: 		<jchen747@wisc.edu>
 * Web Sources: 		<None>
 * Personal Help: 	<None>
 */

/**
 * A class that represents one Breakout room.  
 * @author Andy Kuemmel
 * @see also LinkedList, ZoomParticipant
 */
public class BreakoutRoom {
	private LinkedList<ZoomParticipant> roomList;
	private String name;
	
	/**
	 * constructor
	 * @param name
	 */
	public BreakoutRoom(String name) {
		this.name = name;
		roomList = new LinkedList<>();
	}
	
        // moved getNumBreakoutRooms to the ZoomCall class
	
	/**
	 * adds participant to this room's roomList and unmutes
	 * @param participant
	 */
	public void addToRoom(ZoomParticipant participant) {
		this.roomList.addAtEnd(participant);
		participant.setMuted(false);
	}

	/**
	 * removes the participant at index from this room
	 * @param index
	 * @return the participant removed
	 * @throws IllegalArgumentException if index is out of bounds
	 */
	public ZoomParticipant removeFromRoom(int index) throws IllegalArgumentException { 
		ZoomParticipant elementToRemove;
		if ((index < 0) || (index >= this.roomList.size())) {
			throw new IllegalArgumentException();
		}
		elementToRemove = this.roomList.get(index);
		this.roomList.remove(index);
		return elementToRemove;
	}

	/**
	 * @return the size of the room list
	 */
	public int getSize() { 
		return this.roomList.size();
	}

	/**
	 * prints out the info in roomList
	 */
	public void printBreakoutRoom() { 
		System.out.print(this.name + ":\t"); // TODO
		this.roomList.print();
	}

}
