package util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import domain.Arquivo;

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

	private List<Arquivo> arquivos = new ArrayList<>();

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
		if (file.getFileName().toString().toUpperCase().endsWith(fileName)) {

			String nomeArquivo = file.getFileName().toString();
			Arquivo arquivo = new Arquivo();
			arquivo.setFonte(nomeArquivo);
			arquivos.add(arquivo);

			System.out.println("File found: " + file);

			String pathString = file.getParent().toString();
			Path path = Paths.get(pathString);
			String[] tokens = StreamSupport.stream(path.spliterator(), false).map(Path::toString)
			.toArray(String[]::new);
			String diretorio = tokens[tokens.length -1];  

			System.out.println("Adding " + file + " to list");
			try {
				foundFilesList.add(
						"<a href = 'https://github.com/Corpus-Saneamento-e-Obras-Ltda/Protheus/blob/main/Atual/"
								+ diretorio + "/"
								+ file.getFileName().toString() + "'> "
								+ file.getFileName().toString() + "</a> <br>");
			} catch (Exception e) {
				
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
