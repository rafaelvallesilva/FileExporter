package util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a file's search that list paths and export it to a text file.
 * 
 * @author Rafael.Valle
 * @version beta 1.1 : works offline (Only on your PC)
 * 
 * @extends SimpleFileVisitor<Path> : Java's API 7 class, responsible to manage
 *          access to files and directories. Implements interface FileVisitor<T>
 */
public class SearchFile extends SimpleFileVisitor<Path> {

	// String field to receive file's name (can be only piece of name or extension)
	private String fileName;

	// List of paths founded
	private List<String> foundFilesList = new ArrayList<>();

	// Constructor that receive a String with fileName
	public SearchFile(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see java.nio.file.SimpleFileVisitor#visitFile(java.lang.Object,
	 *      java.nio.file.attribute.BasicFileAttributes)
	 */
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (file.getFileName().toString().contains(fileName)) {
			System.out.println("File found: " + file);

			System.out.println("Adding " + file + " to list");
			try {
				foundFilesList.add(file.getFileName().toString());				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return FileVisitResult.CONTINUE;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<String> getFoundFilesList() {
		return foundFilesList;
	}

	public void setFoundFilesList(List<String> foundFilesList) {
		this.foundFilesList = foundFilesList;
	}
	
}
