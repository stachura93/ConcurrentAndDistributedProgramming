package model;

/*
 * Room "entity"
 * containt information about: roomNumber; maxPeopleInThisRoom; nowPeopleInThisRoom;
 */
public class Room {

	private Integer roomNumber;
	private Integer maxPeopleInThisRoom;
	private Integer nowPeopleInThisRoom = 0;
	
	public Integer getMaxPeopleInThisRoom() {
		return maxPeopleInThisRoom;
	}

	public void setMaxPeopleInThisRoom(Integer maxPeopleInThisRoom) {
		this.maxPeopleInThisRoom = maxPeopleInThisRoom;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Integer getNowPeopleInThisRoom() {
		return nowPeopleInThisRoom;
	}

	public void setNowPeopleInThisRoom(Integer nowPeopleInThisRoom) {
		this.nowPeopleInThisRoom = this.nowPeopleInThisRoom += nowPeopleInThisRoom;
	}	

}
