import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is a very poorly designed HTTP server able to reply to one request with a static HTML page.
 * @author srollins
 *
 */
public class HTTPServer {
	
	public static void main(String[] args) {
		
		try (ServerSocket serve = new ServerSocket(1024);
				Socket sock = serve.accept();
				BufferedReader instream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				PrintWriter writer = new PrintWriter(sock.getOutputStream())
		) {
			
			String message = "";
			String line = instream.readLine();
			
			//read in the request from the client
			while(line != null && !line.trim().isEmpty()) {
				message += line + "\n";
				line = instream.readLine();
			}
			//debug
			System.out.println("Request: \n" + message);
			
			//return static test page
			String headers = "HTTP/1.0 200 OK\n" +
						"\r\n";
			
			String page = "<html> " + 
						"<head><title>TEST</title></head>" + 
					    "<body>This is a short test page.</body>" + 
						"</html>";
			
			writer.write(headers);
			writer.write(page);
			writer.flush();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
