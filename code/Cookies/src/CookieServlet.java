import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CookieServlet extends HttpServlet {


	private Logger logger = Logger.getLogger(CookieServlet.class.getName());

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Cookie[] cookies = request.getCookies();

		int userID = -1;
		boolean newUser = false;

		//determine whether we've seen this user before
		if(cookies != null) {
			for(Cookie c: cookies) {
				if(c.getName().equals("userID")) {
					userID = Integer.parseInt(c.getValue());
					logger.log(Level.INFO, "Existing user: " + userID);			
				}
			}
		}

		//new user
		if(userID == -1) {
			newUser = true;
			userID = UserData.getNextUserID();
			Cookie c = new Cookie("userID", String.valueOf(userID));
			response.addCookie(c);
			logger.log(Level.INFO, "New user: " + userID);			
		}


		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);

		PrintWriter out = response.getWriter();

		String title = "Cookie Servlet";
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
				"			<p>Hello, "  + (newUser?"new":"existing") + " user!</p>\n" +
				"		</div>\n" +
				"	</body>\n";

		String footer = "</html>";

		String page = bootstrapHeader + body + footer;					
		out.println(page);		
	}

}
