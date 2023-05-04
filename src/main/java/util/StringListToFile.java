package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 
 * Exports a list to text file
 * 
 * @author Rafael.Valle
 *
 */
public class StringListToFile {

	/**
	 * Create the report directory in the determined path, create the report file
	 * and print the file's list on the console.
	 * 
	 * @param list : ArrayList<String> to export to file
	 */
	public static void exportList(List<String> list) {
		try {

			// Path to save the report adding current date and time to directory name
			// Path reportPath = Paths.get("exports", "export-" + updateDateNow());
			Path reportPath = Paths.get("", "" + updateDateNow());

			Files.createDirectories(reportPath);
			reportPath = Files.write(reportPath.resolve("arquivos.html"), list, StandardOpenOption.CREATE);
			System.out.println("Number of files founded: " + list.size());
			System.out.println("List exported to: " + reportPath.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * 
	 * Generate date
	 */
	private static String updateDateNow() {
		// Date formatter
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// Static String that receives the formated date
		String date = sdf.format(new Date());
		
		return date;
	}
}
