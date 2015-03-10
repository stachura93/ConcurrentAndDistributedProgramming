import java.util.Random;


public class NumbersThread implements Runnable {
	
	private	World world;
	
	public NumbersThread(World world) {
		this.world = world;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		while(true) {
			System.out.println("Watek:" + " " + Thread.currentThread().getName() + " "
							  + "Liczba dodana:" + " " + world.setInteger(random.nextInt(100)));
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}

}
