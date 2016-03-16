import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class HelloServlet extends HttpServlet {

	
	private Logger logger = Logger.getLogger(HelloServlet.class.getName());
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
		String name = request.getParameter("name");
		if(name == null) {
			name = "anonymous";
		}		

		logger.log(Level.INFO, "Request from: " + name);
		
		response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
                
		PrintWriter out = response.getWriter();
		
		out.println("<html><title>HelloServlet</title><body>Hello, " + name + "!<br/>Thanks for visiting</body></html>");
		
	}
	
	
}
