package concurrency;

import java.util.ArrayList;
import java.util.List;

public class Clerk implements Runnable{
	private List<Order> orders = new ArrayList<Order>();
	public List<Order> getOrders() {
		return orders;
	}
	public synchronized void acceptOrder(Order o) {
		orders.add(o);
		start();
	}
	private void start() {
		Thread t = new Thread(this);
		t.start();
	}
	@Override
	public void run() {
		synchronized (this) {
			Order order = orders.remove(0);
			//prepare for ice cream
			try {
				Thread.sleep(order.amount * 1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new RuntimeException("Unexpected interrupt. " + e.getMessage());
			}
			
			// prepare for transactions
			MoneyService.receive(order.amount * Constants.UNIT_PRICE);
			boolean finished = false;
			while (!finished) {
				try {
					MaterialService.takeAway(Constants.UNIT_MATERIAL);
					finished = true;
				} catch (OutOfStockException e) {
					MaterialProvider.requestForMaterial();
				}
			}
			// wake up waiting customer
			notify();
		}
	}
	
}