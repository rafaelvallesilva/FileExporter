package main_pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a file's search that list paths and export
 * it to a text file.
 *  
 * @author Rafael.Valle
 * @version beta 1.1 : works offline (Only on your PC)
 * 
 * @extends SimpleFileVisitor<Path> : Java's API 7 class,
 *			responsible to manage access to files
 *			and directories. Implements interface FileVisitor<T>
 */
public class SearchFile extends SimpleFileVisitor<Path> {

	//String field to receive file's name (can be only piece of name or extension)
	private String fileName;
	
	//List of paths founded
	private List<String> foundFilesList = new ArrayList<>();

	//Constructor that receive a String with fileName
	public SearchFile(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.nio.file.SimpleFileVisitor#visitFile(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
	 */
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (file.getFileName().toString().contains(fileName)) {
			System.out.println("File found: " + file);
			
			System.out.println("Adding " + file + " to list");
			foundFilesList.add(file.getFileName().toString());
		}
		return FileVisitResult.CONTINUE;
	}

	/**
	 * 
	 * Exports a list to text file
	 * 
	 * @author Rafael.Valle
	 *
	 */
	public static class StringListToFile {
		
		//Date formatter
		private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		
		//Static String that receives the formated date
		private static String date = sdf.format(new Date());
		
		//Path to save the report adding current date and time to directory name
		private static Path reportPath = Paths.get("C:", "Temp", "exports","export-" + date);
		
		/**
		 * Create the report directory in the determined path,
		 * create the report file and print the
		 * list file's list on the console.
		 * 
		 * @param list : ArrayList<String> to export to file
		 */
		public static void exportList(List<String> list) {
			try {
				Files.createDirectories(reportPath);
				reportPath = Files.write(reportPath.resolve("report.txt"), list, StandardOpenOption.CREATE);
				System.out.println("List exported to: " + reportPath.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * Manage inputs from console and the possible data errors
	 * 
	 * @author Rafael.Valle
	 *
	 */
	public static class Console {

		//Read string from console
		public static String readString() {
			try {
				String str = new String();
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				str = reader.readLine();
				return str;
			} catch (IOException e) {
				throw new RuntimeException("Error to reading key: " + e);
			}
		}

		//Read integer from console
		public static int readInt() {
			String str = readString();
			int num = Integer.parseInt(str);
			return num;
		}
		
		//Read double from console
		public static double readDouble() {
			String str = readString();
			double num = Integer.parseInt(str);
			return num;
		}
	}
	
	/**
	 * Main method
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		//Root path of the search
		Path dir = Paths.get("C:\\Temp\\Dir");
		
		//String to receive the Keyboard entry
		String keyEntry = new String();
		
		/**
		 * Looping soliciting data from the keyboard.
		 */
		while (true) {
			//Print message
			System.out.print("Type the file's name or extension to search: ");
			//String receive the keyboard data input
			keyEntry = Console.readString();
			
			//Executes the search
			SearchFile searchFile = new SearchFile(keyEntry);
			Files.walkFileTree(dir, searchFile);
			
			//Print founded files list
			StringListToFile.exportList(searchFile.foundFilesList);
		}	
	}
}