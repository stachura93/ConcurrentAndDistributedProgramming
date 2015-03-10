import service.PersonService;
import service.RoomService;
import thread.GateStarting;
import thread.MainEntrace;

/*
 * Create by Stachura Bartłomiej
 * 10.03.2015r.
 */
public class TestMuseum {

	public static void main(String[] args) {

		/*
		 * Museum is a simple object contains a room In the future can be
		 * abstract clas includes more information about real museum
		 */
		Museum museum = new Museum();

		/*
		 * Information about people
		 */
		PersonService personService = new PersonService();
		/*
		 * Create new room
		 * 
		 * @method Museum.openNewExhibition return RoomService object
		 * 
		 * @param room number, max peopleInRoom
		 */
		RoomService roomService = museum.openNewExhibition(1, 10);
//		RoomService roomService2 = museum.openNewExhibition(2, 5);


		/*
		 * Clas contains runnable implementation. MainEntrace -> Gate allow
		 * people get in. 2.@param howManyPeopleCreate GateStarting -> exit Gate
		 */
		MainEntrace mainEntrace = new MainEntrace(1000);
		GateStarting gateStarting = new GateStarting(1000);

		/*
		 * Thread includes reference to room and people
		 * 
		 * @method setRoomService and setPersonService
		 */
		mainEntrace.setRoomService(roomService);
		mainEntrace.setPersonService(personService);

		gateStarting.setPersonService(personService);
		gateStarting.setRoomService(roomService);
		
		/*
		 * Show all rooms in the museum
		 */
		museum.toString();
		System.out.println("===================================");

		/*
		 * Create threads adding people to room Start all exist people add
		 * threads
		 * 
		 * @param x -> threads number
		 */
		int howManyThreads = 10;
		Thread[] threads = new Thread[howManyThreads];

		for (int i = 0; i < howManyThreads; i++) {
			threads[i] = new Thread(mainEntrace);
		}

		for (int i = 0; i < howManyThreads; i++) {
			threads[i].start();
		}

		Thread exitGate = new Thread(gateStarting);
		exitGate.start();


//		/*
//		 * Second room
//		 */
//		PersonService personService2 = new PersonService();
//
//		MainEntrace mainEntrace2 = new MainEntrace(1000);
//		mainEntrace2.setRoomService(roomService2);
//		mainEntrace2.setPersonService(personService2);
//
//		GateStarting gateStarting2 = new GateStarting(1000);
//		gateStarting2.setPersonService(personService2);
//		gateStarting2.setRoomService(roomService2);
//
//
//
//		Thread[] threads2 = new Thread[howManyThreads];
//
//		for (int i = 0; i < howManyThreads; i++) {
//			threads2[i] = new Thread(mainEntrace2);
//		}
//
//		for (int i = 0; i < howManyThreads; i++) {
//			threads2[i].start();
//		}
//
//		Thread exitGate2 = new Thread(gateStarting2);
//		exitGate2.start();

	}

}
