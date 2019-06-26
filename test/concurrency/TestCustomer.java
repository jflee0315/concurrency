package concurrency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCustomer {

	@Test
	void testConstructor() throws InterruptedException{
		assertDoesNotThrow(()->new Customer(new Store(new StoreManager(1)), new Order(1)));
	}

}
