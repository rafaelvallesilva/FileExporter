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
		comentario = comentario.replace("ßß", "");
		// comentario = comentario.replace("Ñ", "");
		// comentario = comentario.replace("ß", "");
		comentario = comentario.replace("====", "");
		comentario = comentario.replace("---", "");
		comentario = comentario.replace("\\|", "");
		comentario = comentario.replace("\\\\*|\\\\|", "");
		comentario = comentario.replace("\\±±", "");
		comentario = comentario.replace("\\ÍÍ", "");
		comentario = comentario.replace("\\Ë", "");
		comentario = comentario.replace("°", "");
		comentario = comentario.replace("\\¦", "");
		comentario = comentario.replace("\\Ø", "");
		comentario = comentario.replace("\\º", "");
		comentario = comentario.replace("\\#", "");
		comentario = comentario.replace("\\/", "");
		comentario = comentario.replace("\\³", "");
		comentario = comentario.replace("££", "");
		comentario = comentario.replace("±±", "");
		comentario = comentario.replace("", "");
		// comentario = comentario.replace("", "");
		comentario = comentario.replace("(\\| )|( \\|)", "");
		comentario = comentario.replace("[^\\w\\.@-]", "");
		comentario = comentario.replace("/%(7C|60|5E)/g", "");
		comentario = comentario.replace("\\¿", "");
		comentario = comentario.replace("/[\u0020-\u007e\u00a0-\u00ff]/g", "");
		comentario = comentario.replace("/^[\\x20-\\x7E\\xA0-\\xA3\\xA5\\xA7\\xA9-\\xB3\\xB5-\\xB7\\xB9-\\xBB\\xBF-\\xFF\\u20AC\\u0160\\u0161\\u017D\\u017E\\u0152\\u0153\\u0178]*$", "");
		
		// comentario = comentario.replace("(±±)|(Ø)|(È)|(º)|(Ø¹)|(Ï)|(¦)|(/)|(ÍØ)|(ÜÜ)|(Ü)", "");

		// string = decodeURIComponent.replace(comentario);
		tokens[1] = comentario;
		return tokens;
	}

	public static String getComment(String conteudo) {
		String[] tokens = splitCommentBlock(conteudo);
		
		if(tokens.length > 1 && tokens[0].length() <= 1000) {

			// System.out.println("COM COMENTÁRIOS" + tokens[0].length());
			return tokens[1];
		}
		
		return "Sem comentário";
	}

	// public static String ObterStringSemAcentosECaracteresEspeciais(String str)
    //     {
    //         /** Troca os caracteres acentuados por não acentuados **/
    //         String[] acentos = new String[] { "ç", "Ç", "á", "é", "í", "ó", "ú", "ý", "Á", "É", "Í", "Ó", "Ú", "Ý", "à", "è", "ì", "ò", "ù", "À", "È", "Ì", "Ò", "Ù", "ã", "õ", "ñ", "ä", "ë", "ï", "ö", "ü", "ÿ", "Ä", "Ë", "Ï", "Ö", "Ü", "Ã", "Õ", "Ñ", "â", "ê", "î", "ô", "û", "Â", "Ê", "Î", "Ô", "Û" };
    //         String[] semAcento = new String[] { "c", "C", "a", "e", "i", "o", "u", "y", "A", "E", "I", "O", "U", "Y", "a", "e", "i", "o", "u", "A", "E", "I", "O", "U", "a", "o", "n", "a", "e", "i", "o", "u", "y", "A", "E", "I", "O", "U", "A", "O", "N", "a", "e", "i", "o", "u", "A", "E", "I", "O", "U" };

    //         for (int i = 0; i < acentos.length; i++)
    //         {
    //             str = str.replace(acentos[i], semAcento[i]);
    //         }
    //         /** Troca os caracteres especiais da string por "" **/
    //         String[] caracteresEspeciais = { "¹", "²", "³", "£", "¢", "¬", "º", "¨", "\"", "'", ".", ",", "-", ":", "(", ")", "ª", "|", "\\\\", "°", "_", "@", "#", "!", "$", "%", "&", "*", ";", "/", "<", ">", "?","[", "]", "{", "}", "=", "+", "§" ,"´", "`", "^", "~" };

    //         for (int i = 0; i < caracteresEspeciais.length; i++)
    //         {
    //             str = str.replace(caracteresEspeciais[i], "");
    //         }

            /** Troca os caracteres especiais da string por " " **/
            // str = Regex.Replace(str, @"[^\\w\\.@-]", " ",
            //                     RegexOptions.None, TimeSpan.FromSeconds(1.5));

            // return str.Trim();
        // }

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
