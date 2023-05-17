package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import util.HtmlMaker;
import util.SearchFile;
import util.StringListToFile;

public class App {

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Path dir = Paths.get("C:\\Users\\bruno.pansarim\\Documents\\GitHub\\Protheus\\Atual");

		String keyEntry = new String();

		/**
		 * Looping soliciting data from the keyboard.
		 */
		while (true) {
			// Print message
			System.out.print("Type the file's name or extension to search: ");
			// String receive the keyboard data input
			keyEntry = util.Console.readString();

			SearchFile searchFile = new SearchFile(keyEntry);
			try {
				// Executes the search
				if(searchFile != null) {
					System.out.println("searchFIle: " + searchFile.toString());
					Files.walkFileTree(dir, searchFile);
				}
				
			} catch (Exception e) {
				System.out.println("Não é possível acessar diretório " + e.getMessage() + ". Motivo: " + e.getCause());
				e.printStackTrace();
				continue;
			}

			// Print founded files list

			List<String> linhas = new ArrayList<>();
			linhas.add(HtmlMaker.CABECALHO);
			linhas.add(HtmlMaker.TOP_BODY);

			for (String linha : searchFile.getlinhas()) {
				linhas.add(linha);				
			}

			System.out.println("Number of files founded: " + searchFile.getlinhas().size());

			linhas.add(HtmlMaker.BOTTOM_BODY);

			StringListToFile.exportList(linhas);
			

		}
	}
}
