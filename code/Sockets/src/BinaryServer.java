import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This is a very poorly designed HTTP server able to receive a binary file and return a static web page.
 * @author srollins
 *
 */
public class BinaryServer {
	
	public static void main(String[] args) {
		
		try (ServerSocket serve = new ServerSocket(1024);
				Socket sock = serve.accept();
				BufferedReader instream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				PrintWriter writer = new PrintWriter(sock.getOutputStream())
		) {

			String message = "";
			String line = instream.readLine();

			//read in headers
			int length = 0;
			while(line != null && !line.trim().isEmpty()) {
				message += line + "\n";
				line = instream.readLine();
				
				//TODO: fix this messy hack
				if(line.startsWith("Content-Length:")) {
					//extract content length from header
					length = Integer.parseInt(line.split(":")[1].trim());
				}
				//1. is this a valid format (key : value)?
				//2. is the key valid? (constants defined somewhere)
				//3. is the value valid for the key?
				
				
			}
			//debug
			System.out.println("Request: \n" + message);
					
			//read expected bytes from file
			byte[] bytes = new byte[length];
			int read = sock.getInputStream().read(bytes);
			
			//if expected bytes weren't read, read more bytes
			/*
			while(read < length) {
				read += sock.getInputStream().read(bytes, read, (bytes.length-read));
			}
			*/
			
			//debug
			System.out.println("Bytes expected: " + length + " Bytes read: " + read);
			
			//save uploaded binary content to a file.
			try (FileOutputStream fout = new FileOutputStream("out.jpg")) {
				fout.write(bytes);
			} 
			
			
			//return a short page for testing purposes
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
