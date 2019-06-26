package concurrency;

public class Customer implements Runnable{
	private Order order;
	public Store store;
	public Customer(Store s, Order o) {
		store = s;
		order = o;
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		Clerk c = store.getManager().orderIceCream();
		synchronized (c) {
			c.acceptOrder(order);
			try {
				// wait for clerk to deliver ice cream
				c.wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}
}