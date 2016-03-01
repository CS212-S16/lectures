
public class BasicThreads {

	public static void main(String[] args) {

		//instantiate a Runnable object				
		//pass the runnable to a Thread object
		InfinitePrinter p1 = new InfinitePrinter("T1");
		Thread t1 = new Thread(p1);
		
		InfinitePrinter p2 = new InfinitePrinter("T2");
		Thread t2 = new Thread(p2);
		
		//start the Thread
		t1.start();
		t2.start();
				
		/* TBD: using join */
		try {
		
			
			
			t1.join();
			t2.join();

		
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Finished");
		
		
	}

}
