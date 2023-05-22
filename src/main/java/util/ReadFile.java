package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;

public class ReadFile extends SimpleFileVisitor<Path>{
	
	public String read(Path path) {
		String conteudo = "";

		StringBuilder sb = new StringBuilder();
		try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
			String line;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			System.out.println("readFileException: AAAAA");
			e.printStackTrace();
		}

		conteudo = isoToUtf(sb.toString());
		
		// try {
			
		// 	conteudo = Files.readString(path, Charset.defaultCharset());
			
		// } catch (IOException e) {
		// 	System.out.println("readFileException: AAAAA");
		// 	e.printStackTrace();
		// }
		
		return conteudo;
	}
	
	public String read(String input) {
		Path path = Path.of(input);
		return read(path);
	}

	private String isoToUtf (String texto) {
		try {
			byte[] isoBytes = texto.getBytes("UTF-8");
			return new String(isoBytes, "ISO-8859-1");
			// return new String(isoBytes, "ISO-8859-1");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "falha na conversão";
		
	}

}