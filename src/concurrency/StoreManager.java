package concurrency;

import java.util.ArrayList;
import java.util.List;

public class StoreManager {
	private List<Clerk> workers;
	public StoreManager(int clerks) {
		List<Clerk> workers = new ArrayList<>();
		for(int i = 0; i < clerks; i++) {
			workers.add(new Clerk());
		}
		this.workers = workers;
	}
	public StoreManager(List<Clerk> workers) {
		this.workers = workers;
	}
	public synchronized Clerk orderIceCream() {
		return grabWorker();
	}
	private Clerk grabWorker() {
		// Find an available clerk
		for (Clerk c: workers) {
			// Find an idle clerk
			if (c.getOrders().size() == 0) {
				return c;
			}
		}
		// Put into the queue of a random clerk
		int randomIndex = (int) (Math.random() * workers.size());
		return workers.get(randomIndex);	
	}
}
