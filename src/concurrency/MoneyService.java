package concurrency;

public class MoneyService {
	private static int moneyInPocket = 1000;
	public synchronized static void receive(int dollars) {
		moneyInPocket += dollars;
	}
	public synchronized static void takeAway(int dollars) {
		moneyInPocket -= dollars;
	}
	public static int getBalance() {
		return moneyInPocket;
	}
}
