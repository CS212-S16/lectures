import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ExceptionsExamples {

	public void processFile(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
	}

	public void promptUser() throws IOException {  
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter file name: ");
		String fileName = scan.nextLine();
		processFile(fileName); //was this successful?
	}

	public static void main(String[] args) throws IOException {

		ExceptionsExamples ee = new ExceptionsExamples();
		ee.promptUser();
		
		
	}

}
