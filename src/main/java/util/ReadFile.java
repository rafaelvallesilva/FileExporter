package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

public class ReadFile extends SimpleFileVisitor<Path> {

	public String read(Path path) {
		return convertFileStreamContentToString(path.toFile());
	}

	public String read(String input) {
		Path path = Path.of(input);
		return read(path);
	}

	public String convertFileStreamContentToString(File file) {

		int size = (int)file.length();
		try (InputStream inputstream = new BufferedInputStream(new FileInputStream(file))) {
			byte[] byteArray = new byte[size];
			long checkSum = 0L;
			int nRead;
			while ((nRead = inputstream.read(byteArray, 0, size)) != -1) {
				for (int i = 0; i < nRead; i++) {
					checkSum += byteArray[i];
				}
			}

			return new String(byteArray);

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
		return null;

	}

}