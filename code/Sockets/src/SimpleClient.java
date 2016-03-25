import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SimpleClient {
	final static int PORT = 1024;

	public static void main(String[] args) {
		
		//client just sends a message ending with EOT  
		try (Socket s = new Socket(InetAddress.getLocalHost(), PORT);
				PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()))) {
			
			out.println("My message!");
			out.println("EOT");
			out.flush();

		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
