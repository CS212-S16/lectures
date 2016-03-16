import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;


public class ToDoServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		Server server = new Server(8080);
        
        //create a ServletHander to attach servlets
        ServletContextHandler servhandler = new ServletContextHandler(ServletContextHandler.SESSIONS);        
        server.setHandler(servhandler);
 
        servhandler.addEventListener(new ServletContextListener() {

			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void contextInitialized(ServletContextEvent sce) {
				sce.getServletContext().setAttribute(BaseServlet.DATA, new Data());
			}
        	
        });

        servhandler.addServlet(LoginServlet.class, "/login");
        servhandler.addServlet(VerifyUserServlet.class, "/verifyuser");
        servhandler.addServlet(ListServlet.class, "/list");

        //set the list of handlers for the server
        server.setHandler(servhandler);
        
        //start the server
        server.start();
        server.join();

	}

}
