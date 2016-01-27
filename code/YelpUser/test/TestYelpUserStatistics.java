import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class TestYelpUserStatistics {

	@Test
	public void testGetActiveUsers() {
		Path path = Paths.get("input/user_dataset.json");
		YelpUserStatistics stats = new YelpUserStatistics(path);
		assertEquals(60430, stats.getNumberActiveUsers());
	}

}
