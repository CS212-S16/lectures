import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AnotherClass {
	private static final Logger logger = LogManager.getLogger(AnotherClass.class.getName());

	public static void method() {
		
		logger.warn("Warn");
		
	}
	
}

