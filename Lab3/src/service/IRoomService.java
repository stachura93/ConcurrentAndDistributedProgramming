package service;

public interface IRoomService {
	public RoomService createNewRoom(int roomNumber, int howManyPersonInRoom);
	public Integer peopleInRoom();
	public Integer maxPeopleInRoom();
	public String personGetIn();
	public String personGetOut();
}
