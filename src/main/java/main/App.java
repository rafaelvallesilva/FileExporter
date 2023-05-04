package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

		// Root path of the search
		Path dir = Paths.get("C:\\Users\\bruno.pansarim\\Documents\\Protheus\\Atual\\Compras");
		// Path dir = Paths.get("C:\\Users\\rafael.silva\\Documents\\GitHub");

		// String to receive the Keyboard entry
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
			StringListToFile.exportList(searchFile.getFoundFilesList());
			
			
		}
	}
}
