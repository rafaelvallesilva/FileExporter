package util;

import java.nio.file.Path;

public class StringUtils {

	public static String[] stringToArray(String string, String regex) {
		return string.split(regex);
	}

	public static String[] splitCommentBlock(String string) {
		String[] tokens = string.split("(\\/\\*)|(\\*\\/)");
		String comentario = tokens[1].replace("/{Protheus.doc}", "");
		// comentario = comentario.replace("/{protheus.doc}", "");
		comentario = comentario.replace("ÄÄ", "");
		// comentario = comentario.replace("Ä", "");
		comentario = comentario.replace("ÀÀ", "");
		comentario = comentario.replace("ÚÚ", "");
		// comentario = comentario.replace("\\È", "");
		comentario = comentario.replace("ÜÜ", "");
		comentario = comentario.replace("Ü", "");
		comentario = comentario.replace("Ñ", "");
		comentario = comentario.replace("ßß", "");
		// comentario = comentario.replace("Ñ", "");
		// comentario = comentario.replace("ß", "");
		comentario = comentario.replace("====", "");
		comentario = comentario.replace("===", "");
		comentario = comentario.replace("---", "");
		comentario = comentario.replace("--", "");
		comentario = comentario.replace("\\|", "");
		comentario = comentario.replace("\\*|\\|", "");
		comentario = comentario.replace("\\±±", "");
		comentario = comentario.replace("ÍÍ", "");
		comentario = comentario.replace("\\Ë", "");
		comentario = comentario.replace("\\*", "");
		comentario = comentario.replace("¦¦", "");
		comentario = comentario.replace("¦", "");
		comentario = comentario.replace("ØØ", "");
		comentario = comentario.replace("Ø", "");
		comentario = comentario.replace("³³", "");
		comentario = comentario.replace("³", "");
		comentario = comentario.replace("ºº", "");
		comentario = comentario.replace("º", "");
		comentario = comentario.replace("°", "");
		comentario = comentario.replace("**", "");
		comentario = comentario.replace("* *", "");
		comentario = comentario.replace("\\#", "");
		comentario = comentario.replace("++", "");
		comentario = comentario.replace("++--", "");
		comentario = comentario.replace("##", "");
		// comentario = comentario.replace("\\/", "");
		// comentario = comentario.replace("//", "");
		comentario = comentario.replace("\\||", "");
		comentario = comentario.replace("||", "");
		comentario = comentario.replace("££", "");
		comentario = comentario.replace("±±", "");
		comentario = comentario.replace("", "");
		comentario = comentario.replace("ÏÏ", "");
		// comentario = comentario.replace("", "");
		comentario = comentario.replace("(\\| )|( \\|)", "");
		comentario = comentario.replace("[^\\w\\.@-]", "");
		comentario = comentario.replace("/%(7C|60|5E)/g", "");
		comentario = comentario.replace("\\¿¿", "");
		comentario = comentario.replace("¿¿", "");
		comentario = comentario.replace("¿", "");
		comentario = comentario.replace("½", "");
		comentario = comentario.replace("/[\u0020-\u007e\u00a0-\u00ff]/g", "");
		comentario = comentario.replace("/^[\\x20-\\x7E\\xA0-\\xA3\\xA5\\xA7\\xA9-\\xB3\\xB5-\\xB7\\xB9-\\xBB\\xBF-\\xFF\\u20AC\\u0160\\u0161\\u017D\\u017E\\u0152\\u0153\\u0178]*$", "");
		
		// comentario = comentario.replace("(±±)|(Ø)|(È)|(º)|(Ø¹)|(Ï)|(¦)|(/)|(ÍØ)|(ÜÜ)|(Ü)", "");

		// string = decodeURIComponent.replace(comentario);
		tokens[1] = comentario;
		return tokens;
	}

	public static String getComment(String conteudo) {
		String[] tokens = splitCommentBlock(conteudo);
		
		if(tokens.length > 0 ) {

			// System.out.println("COM COMENTÁRIOS" + tokens[0].length());
			return tokens[1];
		}
		
		return "Sem comentário";
	}

	public static String[] splitDescricao(String string) {
		return string.split("(\\| )|( \\|)");
	}

	public static String[] splitDescricaoTitulos(String string) {
		return string.split("(Programa)|(Descricao)");

	}

	public static String convert(Path file) {
		String conteudo = new ReadFile().read(file);
		return StringUtils.getComment(conteudo);

	}

}
