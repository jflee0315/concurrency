package concurrency;

public class Monitor implements Runnable{
	private Output o;
	private double interval;
	public Monitor(Output o, double interval) {
		this.o = o;
		this.interval = interval;
	}
	public void startMonitor() {
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((int)(interval * 1000));
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			o.println("Money: " + MoneyService.getBalance());
			o.println("Material: " + MaterialService.getBalance());
		}
	}
}

@FunctionalInterface
interface Output {
	void println(String s);
}
