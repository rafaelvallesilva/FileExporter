package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Manage inputs from console and the possible data errors
 * 
 * @author Rafael.Valle
 *
 */
public class Console {

	// Read string from console
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

	// Read integer from console
	public static int readInt() {
		String str = readString();
		int num = Integer.parseInt(str);
		return num;
	}

	// Read double from console
	public static double readDouble() {
		String str = readString();
		double num = Integer.parseInt(str);
		return num;
	}
}
