
public class Worker implements Runnable {

	private SharedDataStructure sds;
	
	public Worker(SharedDataStructure sds) {
		this.sds = sds;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			this.sds.addNumber(i);
		}
	}

}
