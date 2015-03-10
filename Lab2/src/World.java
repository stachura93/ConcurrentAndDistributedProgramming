import java.util.ArrayList;
/*
 * Create by Stachura Bartłomiej
 */
public class World {
	private ArrayList<Integer> integerNumbers = new ArrayList<Integer>();
	
	/*
	 * add one Integer number to list
	 */
	public synchronized int setInteger(int nextValue){
		integerNumbers.add((Integer)nextValue);
		return nextValue;
	}
	
	/*
	 * remove param fields from the list
	 */
	public synchronized int removeCollectionValue(int arrayLocalisation) throws IndexOutOfBoundsException {
		int removeValue = integerNumbers.get(arrayLocalisation);
		if((integerNumbers.size()-1) > arrayLocalisation)
			integerNumbers.remove(arrayLocalisation);
		return removeValue;
	}
	
	/*
	 * To remove items from the list, start from the end and go to backwards
	 */
	public int removeCollectionAllFields() {
		int removeValue = 0;
		for(int i=integerNumbers.size()-1; i>-1; i--)
		{
		    removeValue = integerNumbers.get(i);
		    integerNumbers.remove(i);
		}
		return removeValue;
	}
	
	@Override
	public String toString() {
		for (Integer integer : integerNumbers) {
			System.out.print(integer);
			System.out.print(" , ");
		}
		return new String("");
	}
	
	public static void main(String[] args) throws InterruptedException {
		World world = new World();
		
		Thread thread1 = new Thread(new NumbersThread(world));
		Thread thread2 = new Thread(new NumbersThread(world));
		Thread thread3 = new Thread(new RemoveThread(world));

		if(!thread1.isAlive() && !thread2.isAlive() && !thread3.isAlive()) {
			thread1.setName(new String("W-1"));
			thread2.setName(new String("W-2"));
			thread3.setName(new String("W-3"));
				thread1.start();			
				thread2.start();			
				thread3.start();			
		}
				
	}
}
