package concurrency;

public class Test {
	public static void main(String[] args) {
		final double showDataInSeconds = 0.7;
		Environment e = new Environment.Builder().customerPerSecond(4).build();
		Monitor monitor = new Monitor((String s)->{System.out.println(s);}, showDataInSeconds);
		monitor.startMonitor();
		e.start();
	}
}
