package concurrency;

public class MaterialService {
	private static int materialInstock = 100;
	public synchronized static void receive(int amount) {
		materialInstock += amount;
	}
	public synchronized static void takeAway(int amount) throws OutOfStockException {
		if (materialInstock < amount) {
			throw new OutOfStockException();
		}
		materialInstock -= amount;
	}
	public static int getBalance() {
		return materialInstock;
	}
}

class OutOfStockException extends Exception {
	
}