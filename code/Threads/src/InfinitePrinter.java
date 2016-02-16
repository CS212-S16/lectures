
public class InfinitePrinter implements Runnable {

	private String prefix;
	private boolean running;
	
	
	public InfinitePrinter(String prefix) {
		//do any initialization
		this.prefix = prefix;
		this.running = true;
	}
	
	
	@Override	
	public void run() {		
		//main job executed in this thread
		//this will execute when Thread's start method is invoked
		
		int count = 1;
		while(running &&
				count < 100) {
			System.out.println(prefix + " - " + count++);
		}
	}

}
