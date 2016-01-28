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
		ArrayList<String> result = new ArrayList<>();
		findFiles(path, extension, result);
		return result;
	}
	
	/**
	 * Helper method.
	 * @param path
	 * @param extension
	 * @param files
	 */
	private static void findFiles(Path path, String extension, ArrayList<String> files) {
		
		if(Files.isDirectory(path)) {
			
			try(DirectoryStream<Path> dir = 
				Files.newDirectoryStream(path)) {
				
				for(Path entry: dir) {
					findFiles(entry, extension, files);
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} else if(path.toString().endsWith(extension.toLowerCase().trim())) {
			files.add(path.toString());
		}
		
		
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
		Path path = Paths.get("input");
		System.out.println(findFiles(path, ".json"));
	}
	
}
