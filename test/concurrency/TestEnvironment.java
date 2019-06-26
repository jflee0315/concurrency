package concurrency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestEnvironment {

	@Test
	void testBuilder() {
		Object e = new Environment.Builder().clerkPerStore(1).customerPerSecond(1).build();
		assertNotNull(e);
		assertTrue(e instanceof Environment);
	}

}
