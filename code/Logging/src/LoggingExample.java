import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggingExample {
	
	private static final Logger logger = LogManager.getLogger(LoggingExample.class.getName());
	
	public static void main(String[] args) {
	
		//Setup the log levels
		//Configurator.setLevel(LoggingExample.class.getName(), Level.TRACE);
		//Configurator.setLevel(AnotherClass.class.getName(), Level.WARN);
						
		//trace
		//debug
		//info
		//warn
		//error
		//fatal
		
		logger.trace("Trace");
		logger.debug("Debug");
		logger.info("Info");
		logger.warn("Warn");
		logger.error("Error");
		logger.fatal("Fatal");
		
		//AnotherClass.method();
		
	}

}
