package concurrency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMoneyService {

	@Test
	void testRecieve() {
		int m = MoneyService.getBalance();
		MoneyService.receive(10);
		assertTrue(MoneyService.getBalance() == m + 10);
	}
	@Test
	void testTakeAway() {
		int m = MoneyService.getBalance();
		MoneyService.takeAway(10);
		assertTrue(MoneyService.getBalance() == m - 10);
	}

}
