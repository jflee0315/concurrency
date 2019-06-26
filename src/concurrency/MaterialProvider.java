package concurrency;

public class MaterialProvider {
	public static int unitPrice = 2;
	public static int amountPerTruck = 100;
	public static void requestForMaterial() {
		MoneyService.takeAway(unitPrice * amountPerTruck);
		MaterialService.receive(amountPerTruck);
	}
}
