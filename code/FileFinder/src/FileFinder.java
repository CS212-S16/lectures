import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileFinder {

	/**
	 * Recursively traverse the file system and add file names of all
	 * files ending with the given extension to an ArrayList.
	 * Return the ArrayList of file names.
	 * @param path
	 * @param extension
	 * @return
	 */
	public static ArrayList<String> findFiles(Path path, String extension) {
		return null;
	}
	
	/**
	 * Helper method.
	 * @param path
	 * @param extension
	 * @param files
	 */
	public static void findFiles(Path path, String extension, ArrayList<String> files) {
		
	}
	
	
	/**
	 * Recursively traverse the file system and return a count of the number of files
	 * ending with the given extension.
	 * @param path
	 * @param extension
	 * @return
	 */
	public static int countFiles(Path path, String extension) {
		return 0;
	}

	public static void main(String[] args) {
		//TODO: some test code
	}
	
}
