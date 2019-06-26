package concurrency;

import java.util.List;

public class Store {
	private StoreManager manager;

	
	public StoreManager getManager() {
		return manager;
	}
	
	public Store(StoreManager m) {
		manager = m;
	}
}
