package concurrency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestStoreManager {

	@Test
	void testOrderIceCream() {
		StoreManager m = new StoreManager(1);
		Clerk c = m.orderIceCream();
		assertNotNull(c);
	}

}
