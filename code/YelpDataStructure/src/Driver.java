import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver {

	public static void main(String[] args) {

		YelpUsers userList = new YelpUsers();

		YelpUser user1 = new YelpUser("Bob", "112233", 5);
		YelpUser user2 = new YelpUser("Sue", "223344", 56);
		YelpUser user3 = new YelpUser("Ralph", "334455", 23);
		YelpUser user4 = new YelpUser("Roger", "445566", 8);
		YelpUser user5 = new YelpUser("Sally", "556677", 19);

		userList.add(user5);
		userList.add(user1);
		userList.add(user3);
		userList.add(user2);
		userList.add(user4);

		System.out.println("*******************");
		System.out.println("**  DEBUG BY ID  **");
		System.out.println("*******************");
		userList.debugById();
		System.out.println();		
		System.out.println();
		//
		//		System.out.println("*******************");
		//		System.out.println("** DEBUG BY NAME **");
		//		System.out.println("*******************");
		//		userList.debugByName();
		//		System.out.println();		
		//		System.out.println();

	}

}
