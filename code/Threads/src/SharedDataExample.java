
public class SharedDataExample {

	public static void main(String[] args) {
		SharedDataStructure sds = new SharedDataStructure();
		
		Thread t1 = new Thread(new Worker(sds));
		Thread t2 = new Thread(new Worker(sds));
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(sds.size());
		
	}
	
	
}
