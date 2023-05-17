package util;

import java.nio.file.Path;

public class StringUtils {

	public static String[] stringToArray(String string, String regex) {
		return string.split(regex);
	}

	public static String[] splitCommentBlock(String string) {
		String[] tokens = string.split("(\\/\\*)|(\\*\\/)");
		// String comentario = tokens[1].replace("/{Protheus.doc}", " ");
		// comentario = comentario.replace("ÄÄ", "");
		// comentario = comentario.replace("Ä", "");
		// comentario = comentario.replace("ÀÀ", "");
		// comentario = comentario.replace("ÚÚ", "");
		// comentario = comentario.replace("ÜÜ", "");
		// comentario = comentario.replace("ßß", "");
		// comentario = comentario.replace("Ñ", "");
		// comentario = comentario.replace("ß", "");
		// comentario = comentario.replace("==", "");
		// comentario = comentario.replace("\\--", "");
		// comentario = comentario.replace("\\|", "");
		// comentario = comentario.replace("\\|\\", "");
		// comentario = comentario.replace("\\\\*|\\\\|", "");
		// comentario = comentario.replace("\\±±", "");
		// comentario = comentario.replace("\\ÍÍ", "");
		// comentario = comentario.replace("\\Ë", "");
		// comentario = comentario.replace("°", "");
		// comentario = comentario.replace("\\³", "");
		// comentario = comentario.replace("\\±±", "");
		// comentario = comentario.replace("(\\| )|( \\|)", "");
		// comentario = comentario.replace("¿", "");
	
		string[] acentos = new string[] { "ç", "Ç", "á", "é", "í", "ó", "ú", "ý", "Á", "É", "Í", "Ó", "Ú", "Ý", "à", "è", "ì", "ò", "ù", "À", "È", "Ì", "Ò", "Ù", "ã", "õ", "ñ", "ä", "ë", "ï", "ö", "ü", "ÿ", "Ä", "Ë", "Ï", "Ö", "Ü", "Ã", "Õ", "Ñ", "â", "ê", "î", "ô", "û", "Â", "Ê", "Î", "Ô", "Û" };
		string[] semAcento = new string[] { "c", "C", "a", "e", "i", "o", "u", "y", "A", "E", "I", "O", "U", "Y", "a", "e", "i", "o", "u", "A", "E", "I", "O", "U", "a", "o", "n", "a", "e", "i", "o", "u", "y", "A", "E", "I", "O", "U", "A", "O", "N", "a", "e", "i", "o", "u", "A", "E", "I", "O", "U" };

		for (int i = 0; i < acentos.Length; i++)
		{
			str = str.Replace(acentos[i], semAcento[i]);
		}
		/** Troca os caracteres especiais da string por "" **/
		string[] caracteresEspeciais = { "¹", "²", "³", "£", "¢", "¬", "º", "¨", "\"", "'", ".", ",", "-", ":", "(", ")", "ª", "|", "\\\\", "°", "_", "@", "#", "!", "$", "%", "&", "*", ";", "/", "<", ">", "?","[", "]", "{", "}", "=", "+", "§" ,"´", "`", "^", "~" };

		for (int i = 0; i < caracteresEspeciais.Length; i++)
		{
			str = str.Replace(caracteresEspeciais[i], "");
		}

		/** Troca os caracteres especiais da string por " " **/
		str = Regex.Replace("[^\w\.@-]", " ", RegexOptions.None, TimeSpan.FromSeconds(1.5));

		return str.Trim();

		// comentario = comentario.replace("(±±)|(Ø)|(È)|(º)|(Ø¹)|(Ï)|(¦)|(/)|(ÍØ)|(ÜÜ)|(Ü)|(\\| )|( \\|)", " ");
		
		// tokens[1] = comentario;
		return tokens;
	}

	// public static String ObterStringSemAcentosECaracteresEspeciais(String str)
    //     {
    //         /** Troca os caracteres acentuados por não acentuados **/
          
    //     }

	public static String[] splitDescricao(String string) {
		return string.split("(\\| )|( \\|)");
	}

	public static String[] splitDescricaoTitulos(String string) {
		return string.split("(Programa)|(Descricao)");

	}

	public static String convert(Path file) {
		String conteudo = new ReadFile().read(file);
		String[] array = StringUtils.splitCommentBlock(conteudo);
		String descricao = array[1];
		return descricao;

	}

}
