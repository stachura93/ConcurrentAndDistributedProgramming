package thread;

import service.PersonService;
import service.RoomService;

/*
 * MainEntrace represent simple gate.
 * They must get in X person to Room
 * We must remeber about room capacity
 * If can't create new people wait the place release in Room 
 * 
 * @param Threads.times = 1000 and howManyPeopleCreate = 20
 * 
 * Includes references to RoomSerice an PersonService 
 */
public class MainEntrace implements Runnable {

	private PersonService personService;
	private RoomService roomService;
	
	private volatile int howManyThreadRepeat = 0;
	private static int howManyPeopleCreate = 20;
	private long threadTimeSleep = 1000;
	private boolean threadIsRun = true;

	public MainEntrace(long threadTimeSleep) {
		this.threadTimeSleep = threadTimeSleep;
	}

	public MainEntrace(long threadTimeSleep, int howManyPeopleCreate) {
		this.threadTimeSleep = threadTimeSleep;
		this.howManyThreadRepeat = howManyPeopleCreate;
	}

	@Override
	public void run() {
		while (threadIsRun) {
			synchronized (personService) {
				
				while (roomService.peopleInRoom() == roomService
						.maxPeopleInRoom()) {
					try {
						personService.wait();
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}
				if (howManyThreadRepeat == howManyPeopleCreate)
					break;
				
				howManyThreadRepeat += 1;
				getPersonService().createPerson(" " + howManyThreadRepeat);
				System.out.println("Add person"
						+ getPersonService().getPerson().getName() + " room: "
						+ roomService.getRoom().getRoomNumber() + " "
						+ Thread.currentThread().getName());
				roomService.personGetIn();
			}
		}
		try {
			Thread.sleep(threadTimeSleep);
		} catch (InterruptedException e1) {
			System.out.println(e1);
		}
	}

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
