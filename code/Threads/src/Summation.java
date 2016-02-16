
public class Summation implements Runnable {

	private long number;
	
	public Summation(long number) {
		this.number = number;
	}
	
	
	public void run() {		
		calcSummation(number);		
	}

	public static void calcSummation(long value) {
		if(value >= 0) {
			long sum = 0;
			for(int i = 1; i <= value; i++) {
				sum += i;
			}
		}
	}
	
}
