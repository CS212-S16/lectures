import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();

		boolean newUser = false;
		Integer userID = (Integer) session.getAttribute("userID");
		Integer visitCount = 0;

		//new user?
		if(userID == null) {
			newUser = true;
			userID = UserData.getNextUserID();
			session.setAttribute("userID", userID);
			visitCount = 1;
		} else {
			visitCount = ((Integer)session.getAttribute("visitCount")) + 1;
		}

		session.setAttribute("visitCount", visitCount);

		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		PrintWriter out = response.getWriter();

		String title = "Session Servlet";
		String bootstrapHeader = "<!DOCTYPE html>" +
				"<html lang=\"en\">\n" +
				"	<head>\n" +
				"		<title>" + title + "</title>\n" +
				"		<meta charset=\"utf-8\">\n" +
				"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
				"		<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n" +
				"		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n" +
				"		<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n" +
				"	</head>\n";

		String body = "	<body>\n" +
				"		<div class=\"container\">\n" +	
				"			<p>Hello, "  + (newUser?"new":"existing") + " user! "+
				"							You have visited " + visitCount + " time(s).</p>\n" +
				"		</div>\n" +
				"	</body>\n";

		String footer = "</html>";

		String page = bootstrapHeader + body + footer;					
		out.println(page);		



	}

}
