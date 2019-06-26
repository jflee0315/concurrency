package concurrency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestClerk {

	@Test
	void testAcceptOrder() throws InterruptedException{
		Clerk c = new Clerk();
		c.acceptOrder(new Order(1));
		// wait for the clerk to finish processing
		synchronized (c) {
			c.wait();
		}
		// the order list should be cleared
		assertEquals(0, c.getOrders().size());
	}

}
