package util;

public class HtmlMaker {

    public static final String CABECALHO = "<!DOCTYPE html><html lang='en'><head>" +
            "<meta charset='UTF-8'>" +
            "<meta http-equiv='X-UA-Compatible' content='IE=edge'>" +
            "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
            "<link rel='stylesheet' href='css\\estilo.css'>" +
            "<title>Lista de Arquivos</title>" +
            "</head>" +
            "<body>" +
            "<h1>" +
            "Lista de Arquivos" +
            "</h1>" +
            "<div id='tabela'>" +
            "<table>" +
            "<tr class='título'>" +
            "<th> FONTE / PATCH </th>" +
            "<th> MODULO </th>" +
            "<th> ROTINA(S) </th>" +
            "<th> DATA COMPILAÇÃO </th>" +
            "<th> OBSERVAÇÃO </th>" +
            "</tr>";


    public static String criaLink(String url, String texto) {
        StringBuilder sb = new StringBuilder();
        sb.append("<a href=\"");
        sb.append(url);
        sb.append("\">");
        sb.append(texto);
        sb.append("</a>");

        return sb.toString();
    }

    public static String[] criaColunas(String... conteudos) {
		String[] colunas = new String[conteudos.length];
		
		for (int i = 0; i < colunas.length; i++) {
			colunas[i] = "<td>" + conteudos[i] + "</td>";
		}
		
		return colunas;
	}
	
	public static String criaLinha(String[] colunas) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<tr>");
		
		for (String coluna : colunas) {
			sb.append(coluna);
		}
		
		sb.append("</tr>");
		
		return sb.toString();
	}
}