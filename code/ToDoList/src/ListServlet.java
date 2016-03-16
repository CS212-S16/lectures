import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Servlet invoked at login.
 * Creates cookie and redirects to main AddScoresServlet.
 */
public class ListServlet extends BaseServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Data data = (Data) getServletConfig().getServletContext().getAttribute(DATA);
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute(NAME);
		
		//user is not logged in, redirect to login page
		if(name == null || !data.userExists(name)) {
			response.sendRedirect(response.encodeRedirectURL("/login?" + STATUS + "=" + NOT_LOGGED_IN));
			return;
		}
		
		//if user has entered a new item add it to the list
		String item = request.getParameter(ITEM);
		if(item != null && !item.trim().isEmpty()) {
			data.add(name, item);
		}
		
		//if user has clicked delete, delete item from list
		String delete = getParameterValue(request, DELETE);
		if(delete != null) {
			int deleteIndex = Integer.parseInt(delete); //should error check here!
			data.delete(name, deleteIndex);
		}
		
		
		PrintWriter out = prepareResponse(response);
		out.println(header("ToDo List"));		
		out.println("<center>");		
		out.println(data.listToHtml(name));
		out.println("<br/><hr/>");
		out.println("<form action=\"list\" method=\"post\">");
		out.println("New todo item: <input type=\"text\" name=\"item\"><input type=\"submit\" value=\"Enter\">");
		out.println("</form>");
		
		out.println("</center>");
		out.println(footer());
		
	}
}
