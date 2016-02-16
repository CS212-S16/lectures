import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SummationExample {

	public static final long MAX = 300000; 
	
	public static void main(String[] args) {
		
		
		/* TBD: list of threads */
		//ArrayList<Thread> threadList = new ArrayList<>();
		
		/* TBD: executor service */		
		//ExecutorService threadPool = Executors.newFixedThreadPool(10);
		
		
		long start = System.currentTimeMillis(); //retrieve current time when starting calculations
		
		for(long i = 1; i < MAX; i++) {
			/* TBD: sequential execution */
			Summation.calcSummation(i);
			
			/* TBD: one thread per task */
			//Thread t = new Thread(new Summation(i));
			//threadList.add(t);
			//t.start();
			
			
			/* TBD: thread pool */
			//threadPool.execute(new Summation(i));			
		
		}
		
		/* TBD: join on all threads */
		//for(Thread t: threadList) {
			//try {
				//t.join();
			//} catch (InterruptedException e) {
				//e.printStackTrace();
			//}
		//}
		
		
		/* TBD: shutdown executor service */
		//threadPool.shutdown();
		//try {
			//threadPool.awaitTermination(2, TimeUnit.MINUTES);
		//} catch (InterruptedException e) {
			//e.printStackTrace();
		//}
		
		long end = System.currentTimeMillis(); //retrieve current time when finishing calculations
		System.out.println("time: " + (end-start));
	}
		
	
}

