import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ContactsList {

	private ArrayList<Contact> contacts;
	private ReentrantReadWriteLock lock;
	private ReadLock reader;
	private WriteLock writer;

	public ContactsList() {
		this.contacts = new ArrayList<>();
		this.lock = new ReentrantReadWriteLock();
		this.reader = lock.readLock();
		this.writer = lock.writeLock();
	}

	//TODO: are the following methods thread safe?

	public void addContact(String name, String phone) {
		try {
			this.writer.lock();
			this.contacts.add(new Contact(name, phone));
		} finally {
			this.writer.unlock();
		}
	}

	public String getPhone(String name) {	
		try {
			this.reader.lock();
			for(Contact c: this.contacts) {
				if(c.getName().equals(name)) {					
					return c.getPhone();					
				}
			}
			return null;
		} finally {
			this.reader.unlock();
		}
	}

	public ArrayList<Contact> getContacts() {
		ArrayList<Contact> result = new ArrayList<>();
		try {
			this.reader.lock();
			for(Contact c: this.contacts) {
				result.add(c.clone());
			}

			return result;
		} finally {
			this.reader.unlock();
		}
	}	
}
