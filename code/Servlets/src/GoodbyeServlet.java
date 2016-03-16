import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodbyeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		if(name == null) {
			name = "anonymous";
		}
		out.println("<html><title>GoodbyeServlet</title><body>Goodbye, " + name + "!<br/>Come again soon</body></html>");
		
	}
	
}
