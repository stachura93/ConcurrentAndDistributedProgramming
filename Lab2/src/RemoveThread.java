
public class RemoveThread implements Runnable {
	private	World world;
		
	public RemoveThread(World world) {
		this.world = world;
	}
		
		@Override
		public void run() {
			int i = 0;
			while(true) {
				try {
					Thread.sleep(3000);
					try {
						System.out.println("Watek:" + " " + Thread.currentThread().getName() + " "
								+ "Liczba usunięta:" + " " + world.toString() + " " + world.removeCollectionValue(i));						
						i+=1;
					} catch (IndexOutOfBoundsException e) {
						// TODO: handle exception
						System.out.println("Brak elementów w tablicy" + " " + e);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}			
			}
		}
}
