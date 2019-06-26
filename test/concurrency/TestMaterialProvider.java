package concurrency;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMaterialProvider {

	@Test
	void testRequestForMaterial() {
		assertDoesNotThrow(()->{MaterialProvider.requestForMaterial();});
	}

}
