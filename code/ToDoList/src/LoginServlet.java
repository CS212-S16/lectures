import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Allows a user to log in
 */
public class LoginServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{		
		Data data = (Data) getServletConfig().getServletContext().getAttribute(DATA);
		HttpSession session = request.getSession();
		
		//if user is logged in, redirect
		if(session.getAttribute(NAME) != null) {
			response.sendRedirect(response.encodeRedirectURL("/list"));
			return;
		}
				
		String status = getParameterValue(request, STATUS);
				
		boolean statusok = status != null && status.equals(ERROR)?false:true;
		boolean redirected = status != null && status.equals(NOT_LOGGED_IN)?true:false;
		
		//output text box requesting user name
		PrintWriter out = prepareResponse(response);
		
		out.println(header("Login Page"));		

		//if the user was redirected here as a result of an error
		if(!statusok) {
			out.println("<h3><font color=\"red\">Invalid Request to Login</font></h3>");
		} else if(redirected) {
			out.println("<h3><font color=\"red\">Log in first!</font></h3>");
		}

		out.println("<form name=\"name\" action=\"verifyuser\" method=\"post\">");
		out.println("Name:");
		out.println("<input type=\"text\" name=\"name\"/>");
		out.println("<input type=\"submit\" value=\"Login\"/>");
		out.println("</form");
		
		out.println(footer());
		
	}
	
}
