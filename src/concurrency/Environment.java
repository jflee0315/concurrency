package concurrency;

public class Environment {
	private int customerPerSecond;
	private int clerkPerStore;
	private int stores;
	// Restrict access (Use builder only)
	private Environment() {
	}
	private void setCustomerPerSecond(int customers) {
		customerPerSecond = customers;
	}
	private void setClerkPerStore(int c) {
		clerkPerStore = c;
	}
	private void setStores(int s) {
		stores = s;
	}
	public void start() {	
		// For each stores
		for(int i = 0; i < stores; i++) {
			// create stores
			Store s = new Store(new StoreManager(clerkPerStore));
			// generate customers
			new CustomerSpawner(customerPerSecond, s, new Order(1)).spawn();
		}
	}
	private class CustomerSpawner implements Runnable{
		private int rate;
		private Store store;
		private Order order;
		public CustomerSpawner(int rate, Store store, Order order) {
			this.rate = rate;
			this.order = order;
			this.store = store;
		}
		public void spawn() {
			new Thread(this).run();
		}
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
				for(int i = 0; i < rate; i++) {
					Customer c = new Customer(store, order);
				}
			}
		}
		
	}
	static class Builder {
		private int customerPerSecond = 5;
		private int clerkPerStore = 3;
		private int stores = 3;
		public Builder customerPerSecond(int c) {
			customerPerSecond = c;
			return this;
		}
		public Builder clerkPerStore(int c) {
			clerkPerStore = c;
			return this;
		}
		public Builder stores(int s) {
			stores = s;
			return this;
		}
		public Environment build() {
			Environment e = new Environment();
			e.setCustomerPerSecond(this.customerPerSecond);
			e.setClerkPerStore(this.clerkPerStore);
			e.setStores(this.stores);
			return e;
		}
	}
}
