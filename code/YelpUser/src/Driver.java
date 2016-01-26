import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver {

	public static void main(String[] args) {

		Path path = Paths.get("input/user_dataset.json");
		YelpUserStatistics stats = new YelpUserStatistics(path);
		System.out.printf("Active users: %d\n", stats.getNumberActiveUsers());
		//System.out.printf("Voters: %d\n", stats.getVoters());
	
	}

}
