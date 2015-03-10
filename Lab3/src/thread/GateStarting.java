package thread;

import java.util.Random;

import service.PersonService;
import service.RoomService;

/*
 * GateStarting represent simple exit gate.
 * Random person in the random number method is remove.
 * Waiting for his turn and remove people in room
 * On the end restart all threads 
 * @param Threads.times = 1000
 * 
 * Includes references to RoomSerice an PersonService 
 */
public class GateStarting implements Runnable {

	private PersonService personService;
	private RoomService roomService;
	private long threadTimeSleep = 1000;

	public GateStarting(long threadTimeSleep) {
		this.setThreadTimeSleep(threadTimeSleep);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(threadTimeSleep);
				synchronized (personService) {
					if (personService.howManyPeopleExist() <= 1)
						break;
					roomService.toString();
					/*
					 * Remove random person, random times
					 */
					removeRandomPerson();
					toString();
					personService.notify();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Wystawa zamknięta");
	}

	/*
	 * Random person in the random number method is remove. 
	 * We must go deeper ;-)
	 */
	public void removeRandomPerson() {
		Random random = new Random();
		for (int i = 0; i < random.nextInt(personService.howManyPeopleExist()); i++) {
			personService.allPerson().remove(
					random.nextInt(personService.howManyPeopleExist()));
			roomService.personGetOut();
		}
	}

	@Override
	public String toString() {
		System.out.println();
		System.out.println("Person who stay in room:" + " "
				+ roomService.getRoom().getRoomNumber() + " stay person: "
				+ personService.allPerson().size());
		System.out.println("-----------------------");
		personService.toString();
		System.out.println("-----------------------");
		System.out.println();
		return super.toString();
	}

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public RoomService getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}

	public long getThreadTimeSleep() {
		return threadTimeSleep;
	}

	public void setThreadTimeSleep(long threadTimeSleep) {
		this.threadTimeSleep = threadTimeSleep;
	}

}
