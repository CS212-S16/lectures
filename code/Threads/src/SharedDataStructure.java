import java.util.ArrayList;
import java.util.List;


public class SharedDataStructure {

	private List<Integer> numbers;
	//private ReadWriteLock lock;
	
	public SharedDataStructure() {
		this.numbers = new ArrayList<Integer>();
		//this.lock = new ReadWriteLock();
	}
	
	/* TBD: use of the synchronized keyword */
	public  void addNumber(int number) {
		//lock write
		//lock.lockWrite();
		this.numbers.add(number);
		//unlock write
		//lock.unlockWrite();
	}	

	public  int size() {
		//lock read
		return this.numbers.size();
		//unlock read
	}
}
