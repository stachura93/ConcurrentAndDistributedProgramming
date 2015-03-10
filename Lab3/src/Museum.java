import java.util.ArrayList;

import service.RoomService;

/*
 * Museum representation (in the furure abstract)
 * We have simple room creater 
 * 
 * Contains reference to RoomService
 * @method openNewExhibition(int roomNumber, int howManyPersonInRoom)
 */
public class Museum {

	private RoomService roomService;
	private ArrayList<RoomService> allExhibitionRoom = new ArrayList<RoomService>();

	public RoomService openNewExhibition(int roomNumber, int howManyPersonInRoom) {
		roomService = new RoomService();
		getAllExhibitionRoom().add(
				roomService.createNewRoom(roomNumber, howManyPersonInRoom));
		return roomService;
	}

	@Override
	public String toString() {
		for (RoomService room : getAllExhibitionRoom()) {
			room.toString();
		}
		return new String("");
	}

	public ArrayList<RoomService> getAllExhibitionRoom() {
		return allExhibitionRoom;
	}

	public void setAllExhibitionRoom(ArrayList<RoomService> allExhibitionRoom) {
		this.allExhibitionRoom = allExhibitionRoom;
	}

}
