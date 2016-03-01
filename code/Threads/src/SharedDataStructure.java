import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class SharedDataStructure {

	private List<Integer> numbers;
	private ReadWriteLock lock;

	public SharedDataStructure() {
		this.numbers = new ArrayList<Integer>();
		this.lock = new ReentrantReadWriteLock();
	}
	
	public void addNumber(int number) {

		lock.writeLock().lock();
		this.numbers.add(number);
		lock.writeLock().unlock();
	}	

	public int size() {
		try {
			lock.readLock().lock();
			return this.numbers.size();
		} finally {
			lock.readLock().unlock();
		}
	}
}
