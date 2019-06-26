package concurrency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMaterialService {

	@Test
	void testRecieve() {
		int m = MaterialService.getBalance();
		MaterialService.receive(10);
		assertTrue(MaterialService.getBalance() == m + 10);
	}
	@Test
	void testTakeAway() {
		int m = MaterialService.getBalance();
		try {
			MaterialService.takeAway(10);
		} catch (OutOfStockException e) {
			assertNotNull(e);
			return;
		}
		
		assertTrue(MaterialService.getBalance() == m - 10);
	}

}
