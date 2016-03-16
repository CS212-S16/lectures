import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;


public class CookieServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		Logger logger = Logger.getLogger(CookieServer.class.getName());
		
		//Example from http://www.eclipse.org/jetty/documentation/current/embedding-jetty.html
		
		
		// Create a basic jetty server object that will listen on port 8080.
        // Note that if you set this to port 0 then a randomly available port
        // will be assigned that you can either look in the logs for the port,
        // or programmatically obtain it for use in test cases.
        Server server = new Server(8080);
 
        ServletContextHandler servhandler = new ServletContextHandler(ServletContextHandler.SESSIONS);        
        server.setHandler(servhandler);
 
        servhandler.addServlet(CookieServlet.class, "/cookies");
        servhandler.addServlet(SessionServlet.class, "/session");

        //set the list of handlers for the server
        server.setHandler(servhandler);
        logger.log(Level.INFO, "Starting cookie server...");
        
        // Start things up!
        server.start();
        logger.log(Level.INFO, "Cookie server started...");
 
        // The use of server.join() the will make the current thread join and
        // wait until the server is done executing.
        // See
        // http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html#join()
        server.join();

		
	}

}
