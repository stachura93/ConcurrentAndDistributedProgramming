package service;

import java.util.ArrayList;

import model.Room;

/*
 * RoomService can manage a rom entity
 * includes reference to Room
 * 
 * We have creator to create room
 * @method createNewRoom(int roomNumber, int howManyPersonInRoom)
 * 
 * All new room is added to ArayList
 */
public class RoomService implements IRoomService {

	private Room room;
	private ArrayList<Room> allExhibitionRoom = new ArrayList<Room>();

	public RoomService createNewRoom(int roomNumber, int howManyPersonInRoom) {
		setRoom(new Room());
		getRoom().setRoomNumber(roomNumber);
		getRoom().setMaxPeopleInThisRoom(howManyPersonInRoom);
		allExhibitionRoom.add(getRoom());
		return this;
	}

	@Override
	public Integer peopleInRoom() {
		return getRoom().getNowPeopleInThisRoom();
	}

	@Override
	public Integer maxPeopleInRoom() {
		return getRoom().getMaxPeopleInThisRoom();
	}

	@Override
	public String personGetIn() {
		getRoom().setNowPeopleInThisRoom(1);
		return new String("One person get IN this room");
	}

	@Override
	public String personGetOut() {
		getRoom().setNowPeopleInThisRoom(-1);
		return new String("One person get OUT this room");
	}

	@Override
	public String toString() {
		System.out.println("--------------------");
		System.out.println("Room number: " + getRoom().getRoomNumber());
		System.out.println("--------------------");
		System.out.println("Max people in room: "
				+ getRoom().getMaxPeopleInThisRoom());
		System.out.println("Now people in room: "
				+ getRoom().getNowPeopleInThisRoom());
		System.out.println("--------------------");
		System.out.println();
		return super.toString();
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
