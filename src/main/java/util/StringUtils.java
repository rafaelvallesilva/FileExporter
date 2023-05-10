package util;

public class StringUtils {

	public static String[] stringToArray(String string, String regex) {
		return string.split(regex);
	}
	
	public static String[] splitCommentBlock(String string) {
		return string.split("(\\/\\*)|(\\*\\/)");
	}
	
	public static String[] splitDescricao(String string) {
		return string.split("(\\| )|( \\|)");
	}
	
	public static String[] splitDescricaoTitulos(String string) {
		return string.split("(Programa)|(Descricao)");
	}
}
