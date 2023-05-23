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
	private List<String> linhas = new ArrayList<>();

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
		if (file.getFileName().toString().toUpperCase().endsWith(fileName) ||
				(file.getFileName().toString().toLowerCase().endsWith(fileName))) {

			String nomeArquivo = file.getFileName().toString();
			Arquivo arquivo = new Arquivo();
			arquivo.setFonte(nomeArquivo);
			arquivos.add(arquivo);

			System.out.println("File found: " + file);

			String pathString = file.getParent().toString();
			Path path = Paths.get(pathString);
			String[] tokens = StreamSupport.stream(path.spliterator(), false).map(Path::toString)
					.toArray(String[]::new);
			String diretorio = "";

			String pastaRoot = "Atual";
			int indexRoot = -1;
			for (int i = 0; i < tokens.length; i++) {
				if (tokens[i].equals(pastaRoot))
					indexRoot = i + 1;
			}

			StringBuilder sbDiretorio = new StringBuilder();
			if (indexRoot > -1) {
				for (; indexRoot < tokens.length; indexRoot++) {
					sbDiretorio.append(tokens[indexRoot]);
					sbDiretorio.append("/");
				}
			} else {
				System.out.println("Pasta root não encontrada.");
			}

			diretorio = sbDiretorio.toString();

			System.out.println("Adding " + file + " to list");
			try {

				String url = "https://github.com/Corpus-Saneamento-e-Obras-Ltda/Protheus/blob/main/Atual";
				String fileName = file.getFileName().toString();
				String htmlLink = HtmlMaker.criaLink(fileName, url, diretorio, fileName);

				String[] colunas = HtmlMaker.criaColunas(htmlLink, StringUtils.convert(file));
				String linha = HtmlMaker.criaLinha(colunas);

				String linhaUppercase = linha.toUpperCase();

				if (!linhaUppercase.contains("#DEFINE") || !linhaUppercase.contains("#INCLUDE")) {
					linhas.add(linha);
				}


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

	public List<String> getlinhas() {
		return linhas;
	}

	public void setlinhas(List<String> linhas) {
		this.linhas = linhas;
	}

	@Override
	public String toString() {

		return "fileName: " + fileName + "\n" +
				"linhas: " + linhas + "\n" +
				"arquivos: " + arquivos;
	}

}
