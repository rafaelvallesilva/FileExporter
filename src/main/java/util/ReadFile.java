package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

public class ReadFile extends SimpleFileVisitor<Path>{
	
	public String read(Path path) {
		String content = "";
		
		try {
			content = Files.readString(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return content;
	}
	
	public String read(String input) {
		Path path = Path.of(input);
		return read(path);
	}

}