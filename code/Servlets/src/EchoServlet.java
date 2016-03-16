import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EchoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//GET /echo
		
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
		
		PrintWriter out = response.getWriter();
		out.println("<html><title>EchoServlet</title><body>");
		
		out.println("<form action=\"echo\" method=\"post\">");
		out.println("Message: <br/>");
		out.println("<input type=\"text\" name=\"usermsg\"><br/>");
		out.println("<input type=\"submit\" value=\"Submit\"></form>");		
		
		out.println("</body></html>");

		
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//POST /echo
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
		
		PrintWriter out = response.getWriter();

		String msg = request.getParameter("usermsg");
		
		out.println("<html><title>EchoServlet</title><body>You said: " + msg + "</body></html>");

	}
	
}
